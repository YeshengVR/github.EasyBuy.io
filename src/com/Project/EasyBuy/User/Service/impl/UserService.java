package com.Project.EasyBuy.User.Service.impl;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.*;
import com.Project.EasyBuy.User.Service.IUserService;
import com.Project.EasyBuy.User.Util.JDBCUtil;
import com.Project.EasyBuy.User.Util.PageEntry;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserService implements IUserService {
    private static UserService userService;
    private IUserDao userDao;

    private UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    //双重检查锁----单例模式
    public static UserService getInstance(IUserDao userDao) {
        if (userService == null) {
            synchronized (UserService.class) {
                if (userService == null) {
                    userService = new UserService(UserDao.getInstance());
                }
            }
        }
        return userService;
    }

    @Override
    public User login(String amount, String password) {
        return userDao.login(amount, password);
    }

    @Override
    public User register(User user) {
        return userDao.register(user);
    }

    public Boolean isrepeatEmail(String email) {
        return userDao.isrepeat(email, "EMAIL");
    }

    public Boolean isrepeatMobile(String mobile) {
        return userDao.isrepeat(mobile, "MOBILE");
    }

    public Boolean isrepeatUsername(String name) {
        return userDao.isrepeat(name, "USERNAME");
    }

    public Boolean isrepeatIdentitycode(String Identitycode) {
        return userDao.isrepeat(Identitycode, "IDENTITYCODE");
    }

    @Override
    public Boolean isSubmitOrder(Order order, ArrayList<OrderDetail> orderDetail) throws SQLException {
        Boolean flag = false;
        Boolean b = userDao.OrderSubmit(order);
        if (orderDetail == null || orderDetail.size() == 0) {
            return false;
        } else {
            Boolean aBoolean = userDao.OrderDetailSubmit(orderDetail);
            flag = b && aBoolean;
        }
        return flag;
    }

    @Override
    public User ModifyUser(User user) {
        return userDao.ModifyUser(user);
    }

    @Override
    public PageEntry<Product> PageProduct(PageEntry<Product> pe, Object var, String order, Boolean flag) {
        return userDao.PageProduct(pe, var, order, flag);
    }

    @Override
    public Product ProductByID(String Table, String column, Number ID) {
        return userDao.ProductByID("EASYBUY_PRODUCT", column, ID);
    }

    @Override
    public Boolean AddShoppingRecord(ShoppingRecord sr) {
        return userDao.AddShoppingRecord(sr);
    }

    @Override
    public Boolean AddAddress(Address address) {
        Boolean flag = false;
        if (address.getISDEFAULT().intValue() == 0) {
            flag = userDao.ModifyAddressDefault(address.getUSERID().intValue());
        }
        Boolean aBoolean = userDao.AddAddress(address);
        return aBoolean;
    }

    @Override
    public PageEntry<Address> Page(PageEntry<Address> pe, User user) {
        return userDao.Page(pe, user);
    }

    @Override
    public Address ModifyAddress(Address address) {
        return userDao.ModifyAddress(address);
    }

    @Override
    public Address ADDRESSByDefault(User user) {
        return userDao.ADDRESSByDefault(user);
    }

    @Override
    public Boolean ModifyAddressDefault(Integer userid) {
        return userDao.ModifyAddressDefault(userid);
    }

    @Override
    public Integer productSales(OrderDetail orderDetail) {
        return userDao.productSales(orderDetail);
    }

    @Override
    public PageEntry<Product> selePageProductByPrice(PageEntry<Product> pe, Class<Product> clazz, Integer mixPrice, Integer maxPrice, Object var, String order, Boolean flag) {
        return userDao.selePageProductByPrice(pe, Product.class, mixPrice, maxPrice, var, order, flag);
    }
    /**
     * 根据2级品牌ID查找商品
     * @param pm    商品分页封装集合
     * @param var   二级id
     * @return      封装好的分页商品集合
     */
    public PageEntry<Product> selectPageProductBy2Lv(PageEntry<Product> pm, Object var){
        return userDao.selectPageProductBy2Lv(pm,var);
    }
    /**
     * 根据2级品牌ID查找商品
     * @param pm    商品分页封装集合
     * @param var   二级id
     * @return      封装好的分页商品集合
     */
    public PageEntry<Product> selectPageProductBy1Lv(PageEntry<Product> pm, Object var){
        return userDao.selectPageProductBy1Lv(pm,var);
    }

    @Override
    public CCODE Stock(Number codeid) {
        return userDao.Stock(codeid);
    }

    @Override
    public PageEntry<Product> selectPageProductBy3Lv(PageEntry<Product> pm, Object var) {
        pm = userDao.selectPageProductBy3Lv(pm, Integer.parseInt(var.toString()));
        return pm;
    }

    @Override
    public ArrayList<News> News() {
        return userDao.News();
    }

    @Override
    public ArrayList<Category> Categorylv1() {
        return userDao.Categorylv1();
    }

    @Override
    public ArrayList<Category> Categorylv2(Number category1) {
        return userDao.Categorylv2(category1);
    }

    @Override
    public ArrayList<Category> Categorylv3(Number category2) {
        return userDao.Categorylv3(category2);
    }

    @Override
    public PageEntry<ShoppingRecord> selectPageShop(PageEntry<ShoppingRecord> pe, Integer userid) {
        return userDao.selectPageShop(pe, userid);
    }

    @Override
    public HashMap<String, ArrayList<CCODE>> getType(Integer var) {
        return userDao.getType(var);
    }

    @Override
    public ArrayList<Category> selectType1(Integer id) {
        return userDao.selectType1(8, id);
    }

    @Override
    public ArrayList<Category> selectType2(Integer id) {
        return userDao.selectType1(9, id);
    }

    @Override
    public Category CateByid(Integer id) {
        return userDao.CateByid(id);
    }
    /**
     * 删除全部历史记录
     * @param userid    用户id
     * @return      true：删除成功；false：删除失败
     */
    public Boolean deletehistory(Number userid){
        return userDao.deletehistory(userid);
    }

    /**
     * 根据品牌名查找品牌
     *
     * @param name 品牌名
     * @return 品牌数据
     */
    @Override
    public Category sCateByname(String name) {
        return userDao.sCateByname(name);
    }

    @Override
    public ArrayList<String> getColor(Number productid) {
        return userDao.getColor(productid);
    }

    @Override
    public ArrayList<String> getspec(Number productid) {
        return userDao.getspec(productid);
    }

    @Override
    public CCODE getstock(Number productid, String color, String spec) {
        return userDao.getstock(productid, color, spec);
    }

    @Override
    public ArrayList<ShoppingRecord> selectallshoprecord(Integer userid) {
        return userDao.selectallshoprecord(userid);
    }

    /**
     * 通过CCODEid查找CCODE
     *
     * @param codeid CODEID
     * @return 返回属性
     */
    @Override
    public CCODE getid(Number codeid) {
        return userDao.getid(codeid);
    }

    /**
     * 通过recordid删除
     *
     * @param id record的id
     * @return true：删除成功；false：删除失败
     */
    @Override
    public Boolean deleterecord(Number id) {
        return userDao.deleterecord(id);
    }

    public ArrayList<ShoppingRecord> selectallShop(Integer userid) {
        return userDao.selectallshoprecord(userid);
    }

    /**
     * 删除这个User的所有购物车记录
     *
     * @param userid 用户的id
     * @return true：删除成功；false：删除失败
     */
    public Boolean deleteallrecor(Number userid) {
        return userDao.deleteallrecor(userid);
    }

    @Override
    public Boolean OrderSubmit(Order order) {
        return userDao.OrderSubmit(order);
    }

    @Override
    public Boolean OrderDetailSubmit(ArrayList<OrderDetail> orderDetails) {
        return userDao.OrderDetailSubmit(orderDetails);
    }

    @Override
    public Order selectOrder(Order order) {
        return userDao.selectOrder(order);
    }

    @Override
    public Boolean addhistor(BrowsingHistory bh) {
        return userDao.addhistor(bh);
    }

    @Override
    public ArrayList<BrowsingHistory> selectBHistory(Integer userid) {
        return userDao.selectBHistory(userid);
    }

    @Override
    public Boolean updatestock(Number num, Number Codeid) {
        return userDao.updatestock(num,Codeid);
    }
    /**
     * 更新商品销量
     * @param num       商品的数量
     * @param prodectid 商品的id
     * @return          true：更新成功；false：更新失败
     */
    public Boolean updateSales(Number num,Number prodectid){
        return userDao.updateSales(num,prodectid);
    }

    /**
     * 更新购物车的数量数据
     * @param num   数量
     * @param id    购物记录的id
     * @return
     */
    public Boolean updateShoprecordamount(Number num,Number id){
        return userDao.updateShoprecordamount(num,id);
    }

    /**
     * 查询该用户是否有购物车记录
     * @param userid    用户的id
     * @return          true：有记录；false：没有记录
     */
    public Boolean numrecord(Number userid){
        return userDao.numrecord(userid);
    }

    /**
     * 查找这个用户的订单集合
     * @param userid    用户id
     * @return          返回一个Order集合
     */
    public ArrayList<Order> selectallOrder(Integer userid){
        return userDao.selectallOrder(userid);
    }
    /**
     * 查找这个订单详情的集合
     * @param orderid   订单id
     * @return          返回一个订单详情集合
     */
    public ArrayList<OrderDetail> selectallOrderDetail(Integer orderid){return userDao.selectallOrderDetail(orderid);}

    /**
     * 通过销量/创建时间排序
     * @param pm        封装好的分页数据集合
     * @param var       根据什么来进行查找
     * @param flag      true：根据商品名称查找；false：根据商品描述的模糊查询
     * @param index     index：1升序排序；其他为降序排序
     * @return
     */
    public PageEntry<Product> selectPageProductBySales(PageEntry<Product> pm, Object var,Boolean flag,String index){
        return userDao.selectPageProductBycreatetimeorSales(pm,Product.class,var,"SALES",flag,index);
    }
    /**
     * 通过销量/创建时间排序
     * @param pm        封装好的分页数据集合
     * @param var       根据什么来进行查找
     * @param flag      true：根据商品名称查找；false：根据商品描述的模糊查询
     * @param index     index：1升序排序；其他为降序排序
     * @return
     */
    public PageEntry<Product> selectPageProductBycreatetime(PageEntry<Product> pm,Object var,Boolean flag,String index){
        return userDao.selectPageProductBycreatetimeorSales(pm,Product.class,var,"CREATEDATE",flag,index);
    }

    /**
     * 判断购物车是否有该物品
     * @param productid     物品的id
     * @param userid        用户的id
     * @return              true：已有；不可添加；false：没有，可以添加
     */
    public Boolean isrepeartshoprecord(Number productid,Number userid,Number codeid){
        return userDao.isrepeartshoprecord(productid, userid,codeid);
    }

    /**
     * 查询该用户的收藏夹信息
     * @param userid    用户id
     * @return          用户的所有收藏物品
     */
    public ArrayList<Favority> showFavority(Number userid){
        return userDao.showFavority(userid);
    }

    /**
     * 添加收藏
     * @param fav   收藏的物品
     * @return      true：删除成功；false：删除失败
     */
    public Boolean addFay(Favority fav){
        return userDao.addFay(fav);
    }

    /**
     * 删除收藏
     * @param userid    用户id
     * @param productid 商品ID
     * @return      true：删除成功；false：删除失败
     */
    public Boolean deleteFav(Number userid,Number productid){
        return  userDao.deleteFav(userid,productid);
    }

    /**
     * 删除全部收藏
     * @param userid    用户id
     * @return          true：删除全部成功；false：删除全部失败
     */
    public Boolean deleteallFav(Number userid){
        return userDao.deleteallFav(userid);
    }

    /**
     * 判断是否收藏夹中已有该商品
     * @param userid        用户ID
     * @param productid     商品ID
     * @return              true:可以添加，收藏夹中没有；false：不可添加，收藏夹中已有
     */
    public Boolean oneFav(Number userid,Number productid){
        return userDao.oneFav(userid,productid);
    }

    /**
     * 根据收藏夹得商品ID查找商品
     * @param fav   收藏的数据
     * @return      商品信息
     */
    public Product selectshoucangid(Favority fav){
        return userDao.selectshoucangid(fav);
    }

    /**
     * 查找商品的分页方法
     * @param pm        封装好的分页数据
     * @param mixPrice  最小价格
     * @param maxPrice  最大价格
     * @param var       查询的事物
     * @param sort      根据什么来排序例如：创建时间，价格或者品牌id
     * @param order     顺序还是倒序“asc”顺序，“desc”倒叙
     * @param flag      true：通过名称的模糊查找 false：通过描述的模糊查找
     * @return
     */
    public PageEntry<Product> selectPageProduct(PageEntry<Product> pm, Integer mixPrice, Integer maxPrice, Object var,String sort,String order,Boolean flag){
        if(mixPrice==null||maxPrice==null){
            return userDao.selectPageProduct(pm,Product.class,null,null,var,sort,order,flag);
        }
        return userDao.selectPageProduct(pm,Product.class,mixPrice,maxPrice,var,sort,order,flag);
    }
}
