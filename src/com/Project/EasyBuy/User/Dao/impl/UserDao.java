package com.Project.EasyBuy.User.Dao.impl;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Entry.*;
import com.Project.EasyBuy.User.Util.JDBCUtil;
import com.Project.EasyBuy.User.Util.MyBatisSession;
import com.Project.EasyBuy.User.Util.PageEntry;
import jdk.nashorn.internal.scripts.JD;
import org.apache.ibatis.session.SqlSession;

import javax.sql.rowset.JdbcRowSet;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class UserDao implements IUserDao {
    private static UserDao userDao;

    private UserDao() {
    }

    //双重检查锁----单例模式
    public static UserDao getInstance() {
        if (userDao == null) {
            synchronized (UserDao.class) {
                if (userDao == null) {
                    userDao = new UserDao();
                }
            }
        }
        return userDao;
    }

    /**
     * 登录
     * @param amount    数量
     * @param password  传入密码数据
     * @return
     */
    @Override
    public User login(String amount, String password) {
        SqlSession session = MyBatisSession.openSession(true);
        User user = null;
        User cond = new User();
        cond.setUsername(amount);
        cond.setPassword(password);
        List<User> login = session.selectList("login", cond);
        if(login!=null&&login.size()!=0){
            user = login.get(0);
        }
        return user;
    }

    /**
     * 注册
     * @param user  一个封装好的用户数据
     * @return
     */
    @Override
    public User register(User user) {
        SqlSession session = MyBatisSession.openSession(true);
        Integer register = session.insert("register", user);
        if(register==0){
            user=null;
        }else{
            user = login(user.getUsername(), user.getPassword());
        }
        return user;
    }

    /**
     * 判断是否重复
     * @param name      用户输入的数据
     * @param column    输入的数据对应的列
     * @return
     */
    @Override
    public Boolean isrepeat(String name, String column) {
        SqlSession session = MyBatisSession.openSession(true);
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name",name);
        map.put("column",column);
        Integer isrepeat = session.selectOne("isrepeat", map);
        if(isrepeat==null||isrepeat==0){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param user  传入封装好的用户信息数据
     * @return
     */
    @Override
    public User ModifyUser(User user) {
        Connection conn = null;
        PreparedStatement state = null;
        Integer rs = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update EASYBUY_USER set LOGINNAME = ?,\n" +
                    "                        USERNAME     = ?,\n" +
                    "                        PASSWORD     = ?,\n" +
                    "                        SEX          = ?,\n" +
                    "                        IDENTITYCODE = ?,\n" +
                    "                        EMAIL        = ?,\n" +
                    "                        MOBILE       = ?,\n" +
                    "                        \"Phone\"      = ?\n" +
                    "where ID = 1";
            state = conn.prepareStatement(sql);
            state.setString(1, user.getLoginname());
            state.setString(2, user.getUsername());
            state.setString(3, user.getPassword());
            state.setInt(4, user.getSex().intValue());
            state.setString(5, user.getIdentitycode());
            state.setString(6, user.getEmail());
            state.setString(7, user.getMobile());
            state.setString(8, user.getPhone());
            rs = state.executeUpdate();
            if (rs == 0) {
                user = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return user;
    }

    /**
     * 获取分页的商品信息通过模糊查询与描述相关的物品
     *
     * @param pe  已经存取了的商品分页信息集合
     * @param var 根据var来进行分类查询 没有则查询全部商品信息
     * @return 返回一个分页好的PageEntry<Product>
     */
    @Override
    public PageEntry<Product> PageProduct(PageEntry<Product> pe, Object var, String order,Boolean flag) {
        if ("CREATEDATE".equalsIgnoreCase(order)) {
            pe = JDBCUtil.selectPageFuzzy(pe, Product.class, var, "EASYBUY_PRODUCT", flag?"DESCRIPTION":"NAME", "CREATEDATE");
        } else if ("PRICE".equalsIgnoreCase(order)) {
            pe = JDBCUtil.selectPageFuzzy(pe, Product.class, var, "EASYBUY_PRODUCT", flag?"DESCRIPTION":"NAME", "PRICE");
        } else if ("SALES".equalsIgnoreCase(order)) {
            pe = JDBCUtil.selectPageFuzzy(pe, Product.class, var, "EASYBUY_PRODUCT", flag?"DESCRIPTION":"NAME", "SALES");
        }
        return pe;
    }

    /**
     *
     * @param Table     数据库表名
     * @param column    数据库要查找的ID所对应的列名
     * @param ID        需要查找的ID
     * @return
     */
    @Override
    public Product ProductByID(String Table, String column, Number ID) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Product temp = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from " + Table + " where ISDELETE = 0 and " + column + " = ?";
            state = conn.prepareStatement(sql);
            state.setInt(1, ID.intValue());
            rs = state.executeQuery();
            ArrayList<Product> select = JDBCUtil.Select(rs, Product.class);
            if (select != null && select.size() != 0) {
                temp = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return temp;
    }

    /**
     *
     * @param order     需要提交的订单信息
     * @return
     */
    @Override
    public Boolean OrderSubmit(Order order) {
        Connection conn = null;
        PreparedStatement state = null;
        Integer rs = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into EASYBUY_ORDER\n" +
                    "values (EASYBUY_ORDER_ID_SEQ.nextval, ?,?,?, sysdate,?, ?)";
            state = conn.prepareStatement(sql);
            state.setInt(1, order.getUSERID().intValue());
            state.setString(2, order.getLOGINNAME());
            state.setString(3, order.getUSERADDRESS());
            state.setInt(4, order.getCOST().intValue());
            state.setString(5, order.getSERIALNUMBER());
            rs = state.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     *
     * @param order 查找订单
     * @return
     */
    @Override
    public Order selectOrder(Order order) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Order ord = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql2 = "select * from EASYBUY_ORDER where SERIALNUMBER = ?";
            state = conn.prepareStatement(sql2);
            state.setString(1,order.getSERIALNUMBER());
            rs = state.executeQuery();
            ArrayList<Order> select = JDBCUtil.Select(rs, Order.class);
            if(select!=null&&select.size()!=0) {
                ord = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return ord;
    }

    /**
     * 订单详情提交
     * @param orderDetails  一次购买中的所有购买物品
     * @return
     */
    public Boolean OrderDetailSubmit(ArrayList<OrderDetail> orderDetails) {
        Connection conn = null;
        PreparedStatement state = null;
        Integer rs = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert all";
            for (OrderDetail orderDetail : orderDetails) {
                sql += " into EASYBUY_ORDER_DETAIL(ORDERID,PRODUCTID,QUANTITY,COST)\n" +
                        "values (" + orderDetail.getORDERID() + ", " + orderDetail.getPRODUCTID() + ", " + orderDetail.getQUANTITY() + ", " + orderDetail.getCOST() + ")";
            }
            sql += " select * from dual";
            state = conn.prepareStatement(sql);
            rs = state.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 分页查找购物车记录
     * @param pe    购物车分页封装数据
     * @param var   查找的数据
     * @return
     */
    public PageEntry<ShoppingRecord> PageShoppingRecord(PageEntry<ShoppingRecord> pe, Object var) {
        pe = JDBCUtil.selectPagePrecise(pe, ShoppingRecord.class, var, "EASYBUY_SHOPPING_RECORD", "USERID", "CREATETIME");
        return pe;
    }

    /**
     *
     * @param sr    传入封装好的购物车信息对象
     * @return
     */
    @Override
    public Boolean AddShoppingRecord(ShoppingRecord sr) {
        Connection conn = null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into EASYBUY_SHOPPING_RECORD\n" +
                    "values (EASYBUY_RECORD_ID_SEQ.nextval,?, ?, ?, ?, sysdate,?,?)";
            state = conn.prepareStatement(sql);
            state.setInt(1, sr.getUSERID().intValue());
            state.setInt(2, sr.getPRODUCTID().intValue());
            state.setInt(3, sr.getPRICE().intValue());
            state.setInt(4, sr.getAMOUNT().intValue());
            state.setString(5, sr.getFILENAME());
            state.setInt(6,sr.getCCODEID().intValue());
            rs = state.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     *
     * @param userid    通过用户id查找购物车记录
     * @return
     */
    public ArrayList<ShoppingRecord> selectallshoprecord(Integer userid){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<ShoppingRecord> select = new ArrayList<ShoppingRecord>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_SHOPPING_RECORD where userid=?";
            state = conn.prepareStatement(sql);
            state.setInt(1, userid);
            rs = state.executeQuery();
            select = JDBCUtil.Select(rs, ShoppingRecord.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return select;
    }

    /**
     * 地址信息
     * @param address   封装好的地址信息数据
     * @return
     */
    public Boolean AddAddress(Address address) {
        Connection conn = null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into EASYBUY_USER_ADDRESS\n" +
                    "values (EASYBUY_UADDRESS_ID_SEQ.nextval,?,?,sysdate,?,?,?,?,?,?)";
            state = conn.prepareStatement(sql);
            state.setInt(1, address.getUSERID().intValue());
            state.setString(2, address.getADDRESS());
            state.setInt(3, address.getISDEFAULT().intValue());
            state.setString(4, address.getREMARK());
            state.setLong(5,address.getPHONE().longValue());
            state.setInt(6,address.getYOUBIAN()==null?100086:address.getYOUBIAN().intValue());
            state.setString(7,address.getNICKNAME());
            state.setString(8,address.getEMAIL());
            rs = state.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 改变默认地址信息
     * @param userid    用户id
     * @return
     */
    @Override
    public Boolean ModifyAddressDefault(Integer userid) {
        Connection conn = null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update EASYBUY_USER_ADDRESS set ISDEFAULT=1 where userid =?";
            state = conn.prepareStatement(sql);
            state.setInt(1, userid);
            rs = state.executeUpdate();
            if (rs != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 地址分页信息方法
     * @param pe    分页封装好的数据集
     * @param user  登录的用户
     * @return
     */
    @Override
    public PageEntry<Address> Page(PageEntry<Address> pe, User user) {
        pe = JDBCUtil.selectPagePrecise(pe, Address.class, user.getId(), "EASYBUY_USER_ADDRESS", "USERID", "CREATETIME");
        return pe;
    }

    /**
     * 改变地址信息
     * @param address   封装好的地址信息数据
     * @return
     */
    @Override
    public Address ModifyAddress(Address address) {
        Connection conn = null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update EASYBUY_USER_ADDRESS set ADDRESS=?,CREATETIME=sysdate,ISDEFAULT=?,REMARK=?,PHONE=?,YOUBIAN=?,NICKNAME=?,EMAIL=? where userid =?";
            state = conn.prepareStatement(sql);
            state.setString(1, address.getADDRESS());
            state.setInt(2, address.getISDEFAULT().intValue());
            state.setString(3, address.getREMARK());
            state.setInt(4,address.getPHONE().intValue());
            state.setInt(5,address.getYOUBIAN()==null?100006:address.getYOUBIAN().intValue());
            state.setString(6,address.getNICKNAME());
            state.setString(7,address.getEMAIL());
            state.setInt(8, address.getUSERID().intValue());
            rs = state.executeUpdate();
            if (rs != 0) {
                return address;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return null;
    }

    /**
     * 默认地址信息
     * @param user      登录的用户
     * @return
     */
    @Override
    public Address ADDRESSByDefault(User user) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Address address = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_USER_ADDRESS where USERID=? and ISDEFAULT=0";
            state = conn.prepareStatement(sql);
            state.setString(1, user.getId().toString());
            rs = state.executeQuery();
            ArrayList<Address> select = JDBCUtil.Select(rs, Address.class);
            if (select != null && select.size() != 0) {
                address = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return address;
    }

    /**
     * 查找订单总详情
     * @param orderDetail   订单详情
     * @return
     */
    @Override
    public Integer productSales(OrderDetail orderDetail) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Integer sum = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select sum(QUANTITY) from EASYBUY_ORDER_DETAIL where PRODUCTID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1, orderDetail.getPRODUCTID().intValue());
            rs = state.executeQuery();
            while (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return sum;
    }

    /**
     * 根据1，2，3级id查找数据
     * @param pm        封装好的分页商品集合
     * @param var       二级标题的名称
     * @return
     */
    @Override
    public PageEntry<Product> selectPageProductBy3Lv(PageEntry<Product> pm, Object var) {
        pm = JDBCUtil.selectPagePrecise(pm, Product.class, var, "EASYBUY_PRODUCT", "CATEGORYLEVEL3ID", "CREATEDATE");
        return pm;
    }
    @Override
    public PageEntry<Product> selectPageProductBy2Lv(PageEntry<Product> pm, Object var) {
        pm = JDBCUtil.selectPagePrecise(pm, Product.class, var, "EASYBUY_PRODUCT", "CATEGORYLEVEL2ID", "CREATEDATE");
        return pm;
    }
    @Override
    public PageEntry<Product> selectPageProductBy1Lv(PageEntry<Product> pm, Object var) {
        pm = JDBCUtil.selectPagePrecise(pm, Product.class, var, "EASYBUY_PRODUCT", "CATEGORYLEVEL1ID", "CREATEDATE");
        return pm;
    }

    /**
     * 判断购物数据是否重复
     * @param productid     物品的id
     * @param userid        用户的id
     * @param codeid
     * @return
     */
    public Boolean isrepeartshoprecord(Number productid,Number userid,Number codeid){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_SHOPPING_RECORD where USERID=? and PRODUCTID=? and CCODEID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1, userid.intValue());
            state.setInt(2,productid.intValue());
            state.setInt(3,codeid.intValue());
            rs = state.executeQuery();
            ArrayList<Category> select = JDBCUtil.Select(rs, Category.class);
            if(select!=null&&select.size()!=0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return false;
    }

    /**
     *
     * @param pm        封装好的分页数据集合
     * @param clazz     商品类型Product
     * @param var       根据什么来进行查找
     * @param order     根据什么来排序
     * @param flag      true：根据商品名称查找；false：根据商品描述的模糊查询
     * @param index     index：1升序排序；其他为降序排序
     * @return
     */
    public PageEntry<Product> selectPageProductBycreatetimeorSales(PageEntry<Product> pm, Class<Product> clazz, Object var,String order,Boolean flag,String index){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Product> arr = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sqlcount = "select count(1) from EASYBUY_PRODUCT where 1=1 ";
            if (var != null && var != "") {
                sqlcount += " and "+(flag?"NAME":"DESCRIPTION")+" like  ?";
            }
            state = conn.prepareStatement(sqlcount);
            if (var != null && var != "") {
                    state.setObject(1, "%"+var+"%");
            } else {
            }
            rs = state.executeQuery();
            rs.next();
            int TotalMessage = rs.getInt(1);//总信息数
            pm.setTotalMessage(TotalMessage);
            Integer TotalPage = (int) Math.ceil(TotalMessage * 1.0 / pm.getMessagePage());//总页数
            pm.setTotalPage(TotalPage);
            //开始下标
            int start = (pm.getCurrentPage() - 1) * pm.getMessagePage() + 1;
            //结束下标
            int end = pm.getCurrentPage() * pm.getMessagePage();
            state = null;
            rs = null;

            String sqlarr = "select *from (select rownum r, T.*from (select * from EASYBUY_PRODUCT where 1=1  ";
            if (var != null && var != "") {
                sqlarr += " and "+(flag?"NAME":"DESCRIPTION")+" like ?";
            }
            sqlarr += " order by "+order+index+") T where rownum <= ?)temp where temp.r >= ?";
            state = conn.prepareStatement(sqlarr);
            if (var != null && var != "") {
                    state.setObject(1, "%" + var + "%");
                    state.setInt(2, end);
                    state.setInt(3, start);
            } else {
                    state.setInt(1, end);
                    state.setInt(2, start);
            }
            rs = state.executeQuery();
            Field[] declaredFields = clazz.getDeclaredFields();
            while (rs.next()) {
                Product product = clazz.newInstance();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    ResultSetMetaData metaData = rs.getMetaData();
                    for (int i = 2; i <= metaData.getColumnCount(); i++) {
                        String columnName = metaData.getColumnName(i);
                        if (columnName.equalsIgnoreCase(declaredField.getName())) {
                            if (metaData.getColumnTypeName(i).equalsIgnoreCase("clob")) {
                                declaredField.set(product, rs.getString(declaredField.getName()));
                            } else {
                                declaredField.set(product, rs.getObject(declaredField.getName()));
                            }
                        }
                    }
                }
                arr.add(product);
            }
            pm.setList(arr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return pm;
    }

    /**
     *
     * @param pm            封装好的商品数据
     * @param clazz         商品类型
     * @param mixPrice      最小价格
     * @param maxPrice      最大价格
     * @param var           根据什么来进行分页数据
     * @param order         订单
     * @param flag          flag:ture:精确查找；false：模糊查找
     * @return
     */
    @Override
    public PageEntry<Product> selePageProductByPrice(PageEntry<Product> pm, Class<Product> clazz, Integer mixPrice, Integer maxPrice, Object var,String order,Boolean flag) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Product> arr = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sqlcount = "select count(1) from EASYBUY_PRODUCT where 1=1 ";
            if(mixPrice!=null&&maxPrice!=null){
                sqlcount +="and PRICE>=? and PRICE<?";
            }
            if (var != null && var != "") {
                sqlcount += " and "+(flag?"NAME":"DESCRIPTION")+" like  ?";
            }
            state = conn.prepareStatement(sqlcount);
            if (var != null && var != "") {
                if(mixPrice!=null&&maxPrice!=null){
                    state.setInt(1, mixPrice);
                    state.setInt(2, maxPrice);
                    state.setObject(3, "%"+var+"%");
                }else{
                    state.setObject(1, "%"+var+"%");
                }
            } else {
                if(mixPrice!=null&&maxPrice!=null){
                    state.setInt(1, mixPrice);
                    state.setInt(2, maxPrice);
                }
            }
            rs = state.executeQuery();
            rs.next();
            int TotalMessage = rs.getInt(1);//总信息数
            pm.setTotalMessage(TotalMessage);
            Integer TotalPage = (int) Math.ceil(TotalMessage * 1.0 / pm.getMessagePage());//总页数
            pm.setTotalPage(TotalPage);
            //开始下标
            int start = (pm.getCurrentPage() - 1) * pm.getMessagePage() + 1;
            //结束下标
            int end = pm.getCurrentPage() * pm.getMessagePage();
            state = null;
            rs = null;

            String sqlarr = "select * from (select rownum r, T.*from (select * from EASYBUY_PRODUCT where 1=1  ";
            if(mixPrice!=null&&maxPrice!=null) {
                sqlarr += "and PRICE>=? and PRICE<?";
            }
            if (var != null && var != "") {
                sqlarr += " and "+(flag?"NAME":"DESCRIPTION")+" like ?";
            }
            sqlarr += " order by PRICE "+order+") T where rownum <= ?)temp where temp.r >= ?";
            state = conn.prepareStatement(sqlarr);
            if (var != null && var != "") {
                if(mixPrice!=null&&maxPrice!=null) {
                    state.setInt(1, mixPrice);
                    state.setInt(2, maxPrice);
                    state.setObject(3, "%" + var + "%");
                    state.setInt(4, end);
                    state.setInt(5, start);
                }else{
                    state.setObject(1, "%" + var + "%");
                    state.setInt(2, end);
                    state.setInt(3, start);
                }
            } else {
                if(mixPrice!=null&&maxPrice!=null) {
                    state.setInt(1, mixPrice);
                    state.setInt(2, maxPrice);
                    state.setInt(3, end);
                    state.setInt(4, start);
                }else{
                    state.setInt(1, end);
                    state.setInt(2, start);
                }
            }
            rs = state.executeQuery();
            Field[] declaredFields = clazz.getDeclaredFields();
            while (rs.next()) {
                Product product = clazz.newInstance();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    ResultSetMetaData metaData = rs.getMetaData();
                    for (int i = 2; i <= metaData.getColumnCount(); i++) {
                        String columnName = metaData.getColumnName(i);
                        if (columnName.equalsIgnoreCase(declaredField.getName())) {
                            if (metaData.getColumnTypeName(i).equalsIgnoreCase("clob")) {
                                declaredField.set(product, rs.getString(declaredField.getName()));
                            } else {
                                declaredField.set(product, rs.getObject(declaredField.getName()));
                            }
                        }
                    }
                }
                arr.add(product);
            }
            pm.setList(arr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return pm;
    }

    /**
     * 查找品牌
     * @param name  品牌名
     * @return
     */
    public Category sCateByname(String name){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Category cate = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_PRODUCT_CATEGORY where name = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, name);
            rs = state.executeQuery();
            ArrayList<Category> select = JDBCUtil.Select(rs, Category.class);
            if(select!=null&&select.size()!=0) {
                cate = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return cate;
    }

    /**
     *
     * @param var   品牌的名称
     * @return
     */
    @Override
    public Integer selectIDbyname(Object var) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Integer ID = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select ID from EASYBUY_PRODUCT_CATEGORY where NAME=?";
            state = conn.prepareStatement(sql);
            state.setString(1, var.toString());
            rs = state.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return ID;
    }

    /**
     * 查找新闻最新的五条
     * @return
     */
    @Override
    public ArrayList<News> News() {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<News> select = new ArrayList<News>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_NEWS where rownum<=5 order by CREATETIME desc";
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            select = JDBCUtil.Select(rs, News.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return select;
    }

    /**
     * 查询1，2，3级品牌集合
     * @return
     */
    public ArrayList<Category> Categorylv1() {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Category> select = new ArrayList<Category>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_PRODUCT_CATEGORY where TYPE=1";
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            select = JDBCUtil.Select(rs, Category.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return select;
    }
    public ArrayList<Category> Categorylv2(Number Categorylv1) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Category> select = new ArrayList<Category>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_PRODUCT_CATEGORY where TYPE=2";
            if (Categorylv1 != null) {
                sql += "and PARENTID = ?";
            }
            state = conn.prepareStatement(sql);
            if (Categorylv1 != null) {
                state.setInt(1, Categorylv1.intValue());
            }
            rs = state.executeQuery();
            select = JDBCUtil.Select(rs, Category.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return select;
    }
    public ArrayList<Category> Categorylv3(Number category2) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Category> select = new ArrayList<Category>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_PRODUCT_CATEGORY where TYPE=3";
            if (category2 != null) {
                sql += "and PARENTID = ?";
            }
            state = conn.prepareStatement(sql);
            if (category2 != null) {
                state.setInt(1, category2.intValue());
            }
            rs = state.executeQuery();
            select = JDBCUtil.Select(rs, Category.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return select;
    }

    /**
     * 删除购物车全部记录
     * @param userid 用户的id
     * @return
     */
    public Boolean deleteallrecor(Number userid){
        Connection conn = null;
        PreparedStatement state = null;
        Integer rs = null;
        ArrayList<Category> select = new ArrayList<Category>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete EASYBUY_SHOPPING_RECORD where USERID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 分页显示购物记录
     * @param pe        分页的封装数据
     * @param userid    用户的id
     * @return
     */
    @Override
    public PageEntry<ShoppingRecord> selectPageShop(PageEntry<ShoppingRecord> pe, Integer userid) {
        pe = JDBCUtil.selectPagePrecise(pe, ShoppingRecord.class, userid, "EASYBUY_SHOPPING_RECORD", "USERID", "CREATETIME");
        return pe;
    }

    /**
     * 废弃方法
     * @param var   要使用父级id 返回类型数据的map集合
     * @return
     */
    public HashMap<String, ArrayList<CCODE>> getType(Integer var) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<CCODE> select = new ArrayList<CCODE>();
        HashMap<String, ArrayList<CCODE>> map = new HashMap<String, ArrayList<CCODE>>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select distinct PRODUCTSPECI from CCODE where 'TypesID'=?";
            state = conn.prepareStatement(sql);
            state.setInt(1, var);
            rs = state.executeQuery();
            select = JDBCUtil.Select(rs, CCODE.class);
            Integer i = 0;
            for (CCODE ccode : select) {
                state = null;
                rs = null;
                ccode.getPRODUCTSPECI();
                String sql2 = "select distinct * from CCODE where 'TypesID'=? and PRODUCTSPECI = ?";
                state = conn.prepareStatement(sql2);
                state.setInt(1, var);
                state.setString(2, ccode.getPRODUCTSPECI());
                rs = state.executeQuery();
                ArrayList<CCODE> select1 = JDBCUtil.Select(rs, CCODE.class);
                map.put(i.toString(), select1);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return map;
    }

    /**
     * 查找类型一的所有品牌类型
     * @param typeid    对应的type的id
     * @param id        parentid的id
     * @return
     */
    public ArrayList<Category> selectType1(Integer typeid, Integer id) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Category> select = new ArrayList<Category>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_PRODUCT_CATEGORY where TYPE=?";
            if (id != null) {
                sql += "and PARENTID = ?";
            }
            state = conn.prepareStatement(sql);
            if (id != null) {
                state.setInt(1, typeid.intValue());
                state.setInt(2, id.intValue());
            } else {
                state.setInt(1, typeid.intValue());
            }
            rs = state.executeQuery();
            select = JDBCUtil.Select(rs, Category.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return select;
    }

    /**
     * 通过id查找品牌
     * @param id    品牌ID
     * @return
     */
    public Category CateByid(Integer id) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Category cate = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_PRODUCT_CATEGORY where ID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1, id.intValue());
            rs = state.executeQuery();
            ArrayList<Category> select = JDBCUtil.Select(rs, Category.class);
            if(select!=null&&select.size()!=0) {
                cate = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return cate;
    }

    /**
     * 获取类型规格颜色集合
     * @param productid 商品id
     * @return
     */
    public ArrayList<String> getColor(Number productid){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<String> select = new ArrayList<String>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select distinct PRODUCTCOLOR from CCODE where PRODUCTID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,productid.intValue());
            rs = state.executeQuery();
            while (rs.next()){
                select.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return select;
    }
    /**
     * 获取类型规格描述集合
     * @param productid 商品id
     * @return
     */
    public ArrayList<String> getspec(Number productid){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<String> select = new ArrayList<String>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select distinct PRODUCTSPECI from CCODE where PRODUCTID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,productid.intValue());
            rs = state.executeQuery();
            while (rs.next()){
                select.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return select;
    }

    /**
     * 获取该类型的库存
     * @param productid 商品id
     * @param color     商品颜色
     * @param spec      商品规格
     * @return
     */
    public CCODE getstock(Number productid,String color,String spec){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        CCODE stock = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select  * from CCODE where PRODUCTID=? and PRODUCTCOLOR = ? and PRODUCTSPECI = ?";
            state = conn.prepareStatement(sql);
            state.setInt(1,productid.intValue());
            state.setString(2,color);
            state.setString(3,spec);
            rs = state.executeQuery();
            ArrayList<CCODE> select = JDBCUtil.Select(rs, CCODE.class);
            if(select!=null&&select.size()!=0) {
                stock = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return stock;
    }

    /**
     * 通过规格id查找规格数据
     * @param codeid    CODEID
     * @return
     */
    public CCODE getid(Number codeid){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        CCODE stock = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from CCODE where id=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,codeid.intValue());
            rs = state.executeQuery();
            ArrayList<CCODE> select = JDBCUtil.Select(rs, CCODE.class);
            if(select!=null&&select.size()!=0) {
                stock = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return stock;
    }

    /**
     * 删除一条购物车记录
     * @param id    record的id
     * @return
     */
    public Boolean deleterecord(Number id){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete EASYBUY_SHOPPING_RECORD where ID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,id.intValue());
            rs = state.executeUpdate();
            if(rs!=0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 查找所有商品购物车记录
     * @param userid
     * @return
     */
    public ArrayList<ShoppingRecord> selectallShop(Integer userid) {
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<ShoppingRecord> asr = new ArrayList<ShoppingRecord>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_SHOPPING_RECORD where USERID=? order by CREATETIME";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            rs = state.executeQuery();
            asr = JDBCUtil.Select(rs, ShoppingRecord.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return asr;
    }

    /**
     * 添加历史记录
     * @param bh    封装好的历史浏览记录
     * @return
     */
    public Boolean addhistor(BrowsingHistory bh){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into BROWSING_HISTORY\n" +
                    "values (HISTORY_SEQ.nextval,?,?,?,?,?,sysdate,?)";
            state = conn.prepareStatement(sql);
            state.setString(1,bh.getFILENAME());
            state.setInt(2,bh.getPRODUCTID().intValue());
            state.setString(3,bh.getNAME());
            state.setString(4,bh.getDESPCRIPTION());
            state.setInt(5,bh.getPRICE().intValue());
            state.setInt(6,bh.getUSERID().intValue());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 查找前六条历史记录
     * @param userid    用户的id
     * @return
     */
    public ArrayList<BrowsingHistory> selectBHistory(Integer userid){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<BrowsingHistory> bhs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from BROWSING_HISTORY where ROWNUM<=6 and USERID = ? order by CREATETIME desc";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            rs = state.executeQuery();
            bhs = JDBCUtil.Select(rs,BrowsingHistory.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return bhs;
    }

    /**
     * 更新库存
     * @param num       购买的数量
     * @param Codeid    商品类型ID
     * @return
     */
    public Boolean updatestock(Number num,Number Codeid){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update CCODE set PRODUCTSTOCK = PRODUCTSTOCK-? where ID = ?";
            state = conn.prepareStatement(sql);
            state.setInt(1,num.intValue());
            state.setInt(2,Codeid.intValue());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 跟新销量
     * @param num       商品的数量
     * @param prodectid 商品的id
     * @return
     */
    public Boolean updateSales(Number num,Number prodectid){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update EASYBUY_PRODUCT set SALES = SALES+? where ID=?";
            state = conn.prepareStatement(sql);
            state.setLong(1,num.longValue());
            state.setLong(2,prodectid.longValue());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 更新购物车记录数量
     * @param num   数量
     * @param id    购物记录的id
     * @return
     */
    public Boolean updateShoprecordamount(Number num,Number id){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update EASYBUY_SHOPPING_RECORD set AMOUNT = ? where ID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,num.intValue());
            state.setInt(2,id.intValue());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 获取数量
     * @param userid    用户的id
     * @return
     */
    public Boolean numrecord(Number userid){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select count(1) from EASYBUY_SHOPPING_RECORD where USERID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            rs = state.executeQuery();
            Integer num = 0;
            while(rs.next()){
                num = rs.getInt(1);
            }
            if(num!=null&&num!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return false;
    }

    /**
     * 查找用户的所有订单
     * @param userid    用户id
     * @return
     */
    public ArrayList<Order> selectallOrder(Integer userid){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Order> bhs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_ORDER where USERID = ? order by CREATETIME";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid);
            rs = state.executeQuery();
            bhs = JDBCUtil.Select(rs,Order.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return bhs;
    }

    /**
     * 查找用户某个订单的订单详情
     * @param orderid   订单id
     * @return
     */
    public ArrayList<OrderDetail> selectallOrderDetail(Integer orderid){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<OrderDetail> bhs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_ORDER_DETAIL where ORDERID = ?";
            state = conn.prepareStatement(sql);
            state.setInt(1,orderid);
            rs = state.executeQuery();
            bhs = JDBCUtil.Select(rs,OrderDetail.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return bhs;
    }

    /**
     * 删除历史记录
     * @param userid    用户id
     * @return
     */
    public Boolean deletehistory(Number userid){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete BROWSING_HISTORY where USERID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 获取规格的库存
     * @param codeid    规格id
     * @return
     */
    public CCODE Stock(Number codeid){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        CCODE ccode = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from CCODE where ID = ?";
            state = conn.prepareStatement(sql);
            state.setInt(1,codeid.intValue());
            rs = state.executeQuery();
            ArrayList<CCODE> select = JDBCUtil.Select(rs, CCODE.class);
            if(select!=null&&select.size()!=0){
                ccode = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return ccode;
    }

    /**
     * 展示收藏夹
     * @param userid    用户id
     * @return
     */
    public ArrayList<Favority> showFavority(Number userid){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Favority> farr = new ArrayList<Favority>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select *\n" +
                    "from \"EASYBUY_Favority\"\n" +
                    "where USERID = ? order by CREATETIME desc";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            rs = state.executeQuery();
            farr = JDBCUtil.Select(rs, Favority.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return farr;
    }

    /**
     * 添加收藏夹
     * @param fav   收藏的物品
     * @return
     */
    public Boolean addFay(Favority fav){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into \"EASYBUY_Favority\"\n" +
                    "values (EASYBUY_FAVORITE_SEQ.nextval, ?, ?, ?, sysdate, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setInt(1,fav.getPRODUCTID().intValue());
            state.setString(2,fav.getFILENAME());
            state.setInt(3,fav.getCCODEID().intValue());
            state.setInt(4,fav.getUSERID().intValue());
            state.setInt(5,fav.getPRICE().intValue());
            state.setString(6,fav.getDESCRIPTION());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 删除收藏夹
     * @param userid    用户id
     * @param productid 商品ID
     * @return
     */
    public Boolean deleteFav(Number userid,Number productid){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete \"EASYBUY_Favority\" where USERID=? and PRODUCTID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            state.setInt(2,productid.intValue());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 删除全部收藏夹
     * @param userid    用户id
     * @return
     */
    public Boolean deleteallFav(Number userid){
        Connection conn =null;
        PreparedStatement state = null;
        Integer rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete \"EASYBUY_Favority\" where USERID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            rs = state.executeUpdate();
            if(rs!=0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return false;
    }

    /**
     * 通过收藏夹的商品id查找商品
     * @param fav   收藏的数据
     * @return
     */
    public Product selectshoucangid(Favority fav){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Product farr = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from EASYBUY_PRODUCT where ID=?";
            state = conn.prepareStatement(sql);
            state.setInt(1,fav.getPRODUCTID().intValue());
            rs = state.executeQuery();
            ArrayList<Product> select = JDBCUtil.Select(rs, Product.class);
            if(select!=null&&select.size()!=0){
                farr = select.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return farr;
    }
    /**
     * 判断是否收藏夹中已有该商品
     * @param userid        用户ID
     * @param productid     商品ID
     * @return              true:可以添加，收藏夹中没有；false：不可添加，收藏夹中已有
     */
    public Boolean oneFav(Number userid,Number productid){
        Connection conn =null;
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from \"EASYBUY_Favority\" where USERID = ? and PRODUCTID = ?";
            state = conn.prepareStatement(sql);
            state.setInt(1,userid.intValue());
            state.setInt(2,productid.intValue());
            rs = state.executeQuery();
            ArrayList<Favority> select = JDBCUtil.Select(rs, Favority.class);
            if(select!=null&&select.size()!=0){
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, state, conn);
        }
        return true;
    }
    /**
     * 查找商品的分页方法
     * @param pm        封装好的分页数据
     * @param clazz     反射的类模板  Product辅助使用
     * @param mixPrice  最小价格
     * @param maxPrice  最大价格
     * @param var       查询的事物
     * @param sort      根据什么来排序例如：创建时间，价格或者品牌id
     * @param order     顺序还是倒序“asc”顺序，“desc”倒叙
     * @param flag      true：通过名称的模糊查找 false：通过描述的模糊查找
     * @return
     */
    public PageEntry<Product> selectPageProduct(PageEntry<Product> pm, Class<Product> clazz, Integer mixPrice, Integer maxPrice, Object var,String sort,String order,Boolean flag) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        ArrayList<Product> arr = new ArrayList<Product>();
        try {
            conn = JDBCUtil.getConnection();
            String sqlcount = "select count(1) from EASYBUY_PRODUCT where 1=1 ";
            if(mixPrice!=null&&maxPrice!=null){
                sqlcount +="and PRICE>=? and PRICE<?";
            }
            if (var != null && var != "") {
                sqlcount += " and "+(flag?"NAME":"DESCRIPTION")+" like  ?";
            }
            state = conn.prepareStatement(sqlcount);
            if (var != null && var != "") {
                if(mixPrice!=null&&maxPrice!=null){
                    state.setInt(1, mixPrice);
                    state.setInt(2, maxPrice);
                    state.setObject(3, "%"+var+"%");
                }else{
                    state.setObject(1, "%"+var+"%");
                }
            } else {
                if(mixPrice!=null&&maxPrice!=null){
                    state.setInt(1, mixPrice);
                    state.setInt(2, maxPrice);
                }
            }
            rs = state.executeQuery();
            rs.next();
            int TotalMessage = rs.getInt(1);//总信息数
            pm.setTotalMessage(TotalMessage);
            Integer TotalPage = (int) Math.ceil(TotalMessage * 1.0 / pm.getMessagePage());//总页数
            pm.setTotalPage(TotalPage);
            //开始下标
            int start = (pm.getCurrentPage() - 1) * pm.getMessagePage() + 1;
            //结束下标
            int end = pm.getCurrentPage() * pm.getMessagePage();
            state = null;
            rs = null;

            String sqlarr = "select * from (select rownum r, T.*from (select * from EASYBUY_PRODUCT where 1=1  ";
            if(mixPrice!=null&&maxPrice!=null) {
                sqlarr += "and PRICE>=? and PRICE<?";
            }
            if (var != null && var != "") {
                sqlarr += " and "+(flag?"NAME":"DESCRIPTION")+" like ?";
            }
            sqlarr += " order by ? "+order+") T where rownum <= ?)temp where temp.r >= ?";
            state = conn.prepareStatement(sqlarr);
            if (var != null && var != "") {
                if(mixPrice!=null&&maxPrice!=null) {
                    state.setInt(1, mixPrice);
                    state.setInt(2, maxPrice);
                    state.setObject(3, "%" + var + "%");
                    state.setObject(4,sort);
                    state.setInt(5, end);
                    state.setInt(6, start);
                }else{
                    state.setObject(1, "%" + var + "%");
                    state.setObject(2,sort);
                    state.setInt(3, end);
                    state.setInt(4, start);
                }
            } else {
                if(mixPrice!=null&&maxPrice!=null) {
                    state.setInt(1, mixPrice);
                    state.setInt(2, maxPrice);
                    state.setObject(3,sort);
                    state.setInt(4, end);
                    state.setInt(5, start);
                }else{
                    state.setObject(1,sort);
                    state.setInt(2, end);
                    state.setInt(3, start);
                }
            }
            rs = state.executeQuery();
            Field[] declaredFields = clazz.getDeclaredFields();
            while (rs.next()) {
                Product product = clazz.newInstance();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    ResultSetMetaData metaData = rs.getMetaData();
                    for (int i = 2; i <= metaData.getColumnCount(); i++) {
                        String columnName = metaData.getColumnName(i);
                        if (columnName.equalsIgnoreCase(declaredField.getName())) {
                            if (metaData.getColumnTypeName(i).equalsIgnoreCase("clob")) {
                                declaredField.set(product, rs.getString(declaredField.getName()));
                            } else {
                                declaredField.set(product, rs.getObject(declaredField.getName()));
                            }
                        }
                    }
                }
                arr.add(product);
            }
            pm.setList(arr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, state, conn);
        }
        return pm;
    }

}
