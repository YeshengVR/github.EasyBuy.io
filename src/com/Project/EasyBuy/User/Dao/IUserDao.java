package com.Project.EasyBuy.User.Dao;

import com.Project.EasyBuy.User.Entry.*;
import com.Project.EasyBuy.User.Util.JDBCUtil;
import com.Project.EasyBuy.User.Util.PageEntry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public interface IUserDao {

    /**
     * 获取相应密码的所有账户集合
     * @param password  传入密码数据
     * @return      返回一个是这个密码的用户
     */
    public User login(String amount,String password);

    /**
     * 对用户进行注册
     * @param user  一个封装好的用户数据
     * @return      返回注册成功的数据，null为没成功注册
     */
    public User register(User user);

    /**
     * 判断这个名称是否和这个列中的数据重复，用来判断用户注册时部分数据是否唯一
     * @param name      用户输入的数据
     * @param column    输入的数据对应的列
     * @return          返回是否重复，true：没重复，可使用；false：已重复，不可使用
     */
    public Boolean isrepeat(String name,String column);

    /**
     * 修改用户信息
     * @param user  传入封装好的用户信息数据
     * @return      返回一个修改好的user对象，如果为null，代表修改失败
     */
    public User ModifyUser(User user);

    /**
     * 获取分页的商品信息通过模糊查询与描述相关的物品
     * @param pe    已经存取了的商品分页信息集合
     * @param var   根据var来进行分类查询 没有则查询全部商品信息
     * @return      返回一个分页好的PageEntry<Product>
     */
    public PageEntry<Product> PageProduct(PageEntry<Product> pe,Object var,String order,Boolean flag);

    /**
     * 根据id查找对应表的数据
     * @param Table     数据库表名
     * @param column    数据库要查找的ID所对应的列名
     * @param ID        需要查找的ID
     * @return          返回一个根据ID所找到的数据信息
     */
    public Product ProductByID(String Table,String column,Number ID);

    /**
     * 判断提交订单操作是否成功
     * @param order     需要提交的订单信息
     * @return          true：成功提交；false：提交失败
     */
    public Boolean OrderSubmit(Order order);

    /**
     * 提交订单时，对订单详情表的插入功能
     * @param orderDetails  一次购买中的所有购买物品
     * @return              true：提交成功；false：提交失败
     */
    public Boolean OrderDetailSubmit(ArrayList<OrderDetail> orderDetails);

    /**
     * 添加购物车记录
     * @param sr    传入封装好的购物车信息对象
     * @return      true：添加购物车记录成功；false：添加购物车记录失败
     */
    public Boolean AddShoppingRecord(ShoppingRecord sr);

    /**
     * 添加地址信息
     * @param address   封装好的地址信息数据
     * @return          true：添加成功；false：添加失败
     */
    public Boolean AddAddress(Address address);

    /**
     * 当用户设置新的地址为默认地址后，则会触发的方法，修改其他默认地址为非默认状态
     * @return      true:执行成功；false：执行失败：可能原因：用户只有一个地址，或者设置更新其他表默认状态失败
     */
    public Boolean ModifyAddressDefault(Integer userid);

    /**
     * 查询用户的所有住址信息
     * @param pe    分页封装好的数据集
     * @param user  登录的用户
     * @return      返回一个分页封装好的集合数据
     */
    public PageEntry<Address> Page(PageEntry<Address> pe,User user);

    /**
     * 修改地址信息
     * @param address   封装好的地址信息数据
     * @return          null：修改失败；有数据代表成功，返回一个新的地址数据
     */
    public Address ModifyAddress(Address address);

    /**
     * 拿取默认的地址信息
     * @param user      登录的用户
     * @return          默认的地址信息
     */
    public Address ADDRESSByDefault(User user);

    /**
     * 查询对应商品销量的方法
     * @param orderDetail   订单详情
     * @return              返回一个商品销量的数量
     */
    public Integer productSales(OrderDetail orderDetail);

    /**
     * 通过销量/创建时间排序
     * @param pm        封装好的分页数据集合
     * @param clazz     商品类型Product
     * @param var       根据什么来进行查找
     * @param order     根据什么来排序
     * @param flag      true：根据商品名称查找；false：根据商品描述的模糊查询
     * @param index     index：1升序排序；其他为降序排序
     * @return
     */
    public PageEntry<Product> selectPageProductBycreatetimeorSales(PageEntry<Product> pm, Class<Product> clazz, Object var,String order,Boolean flag,String index);

    /**
     * 根据价格区间寻找商品
     * @param mixPrice      最小价格
     * @param maxPrice      最大价格
     * @param var           根据什么来进行分页数据
     * @return              封装好的分页数据集合
     */
    public PageEntry<Product> selePageProductByPrice(PageEntry<Product> pe,Class<Product> clazz,Integer mixPrice,Integer maxPrice,Object var,String order,Boolean flag);

    /**
     * 根据三级标题查找对应的封装好的分页商品集合
     * @param pm        封装好的分页商品集合
     * @param var       二级标题的名称
     * @return          返回一个封装好的商品集合
     */
    public PageEntry<Product> selectPageProductBy3Lv(PageEntry<Product> pm,Object var);

    /**
     * 通过名称查找相应的品牌ID
     * @param var   品牌的名称
     * @return      返回一个品牌的ID
     */
    public Integer selectIDbyname(Object var);

    /**
     * 判断购物车是否有该物品
     * @param productid     物品的id
     * @param userid        用户的id
     * @return              true：已有；不可添加；false：没有，可以添加
     */
    public Boolean isrepeartshoprecord(Number productid,Number userid,Number codeid);

    /**
     * 获取新闻集合
     * @return  返回一个最新的新品描述新闻
     */
    public ArrayList<News> News();

    /**
     * 删除全部历史记录
     * @param userid    用户id
     * @return      true：删除成功；false：删除失败
     */
    public Boolean deletehistory(Number userid);
    /**
     * 查询一级品牌
     * 查询二级品牌
     * 查询三级品牌
     * @return  返回该品牌的类型集合
     */
    public ArrayList<Category> Categorylv1();
    public ArrayList<Category> Categorylv2(Number category1);
    public ArrayList<Category> Categorylv3(Number category2);

    /**
     * 查找当前用户的购物车记录
     * @param pe        分页的封装数据
     * @param userid    用户的id
     * @return          分页好的用户购物车记录
     */
    public PageEntry<ShoppingRecord> selectPageShop(PageEntry<ShoppingRecord> pe, Integer userid);

    /**
     * 获取类型数据
     * @param var   要使用父级id 返回类型数据的map集合
     * @return      String：为0，1，2，3的key从0开始，集合为该key锁对应的数据
     */
    public HashMap<String,ArrayList<CCODE>> getType(Integer var);

    /**
     * 通过ID来查找对应的类型集合
     * @param typeid    对应的type的id
     * @param id        parentid的id
     * @return          返回一个封装好的Category集合
     */
    public ArrayList<Category> selectType1(Integer typeid,Integer id);

    /**
     * 根据ID查品牌
     * @param id    品牌ID
     * @return      品牌数据
     */
    public Category CateByid(Integer id);

    /**
     * 根据品牌名查找品牌
     * @param name  品牌名
     * @return      品牌数据
     */
    public Category sCateByname(String name);

    /**
     * 查找商品的颜色类型和属性类型
     * @param productid
     * @return
     */
    public ArrayList<String> getColor(Number productid);
    public ArrayList<String> getspec(Number productid);

    /**
     * 查找商品的颜色类型和属性类型所对应的库存数量
     * @param productid
     * @param color
     * @param spec
     * @return
     */
    public CCODE getstock(Number productid,String color,String spec);

    public ArrayList<ShoppingRecord> selectallshoprecord(Integer userid);

    /**
     * 通过CCODEid查找CCODE
     * @param codeid    CODEID
     * @return          返回属性
     */
    public CCODE getid(Number codeid);

    /**
     * 通过recordid删除
     * @param id    record的id
     * @return      true：删除成功；false：删除失败
     */
    public Boolean deleterecord(Number id);

    public ArrayList<ShoppingRecord> selectallShop(Integer userid);

    /**
     * 删除这个User的所有购物车记录
     * @param userid 用户的id
     * @return      true：删除成功；false：删除失败
     */
    public Boolean deleteallrecor(Number userid);

    /**
     * 查找订单编号
     * @param order
     * @return
     */
    public Order selectOrder(Order order);

    /**
     * 添加历史浏览记录
     * @param bh    封装好的历史浏览记录
     * @return      true：添加成功；false：添加失败
     */
    public Boolean addhistor(BrowsingHistory bh);

    /**
     * 查询历史浏览记录前四条
     * @param userid    用户的id
     * @return
     */
    public ArrayList<BrowsingHistory> selectBHistory(Integer userid);

    /**
     * 更新商品库存
     * @param num       购买的数量
     * @param Codeid    商品类型ID
     * @return          true：操作成功，库存减少；false：操作失败，库存增加
     */
    public Boolean updatestock(Number num,Number Codeid);

    /**
     * 更新商品销量
     * @param num       商品的数量
     * @param prodectid 商品的id
     * @return          true：更新成功；false：更新失败
     */
    public Boolean updateSales(Number num,Number prodectid);

    /**
     * 更新购物车的数量数据
     * @param num   数量
     * @param id    购物记录的id
     * @return
     */
    public Boolean updateShoprecordamount(Number num,Number id);

    /**
     * 查询该用户是否有购物车记录
     * @param userid    用户的id
     * @return          true：有记录；false：没有记录
     */
    public Boolean numrecord(Number userid);

    /**
     * 查找这个用户的订单集合
     * @param userid    用户id
     * @return          返回一个Order集合
     */
    public ArrayList<Order> selectallOrder(Integer userid);

    /**
     * 查找这个订单详情的集合
     * @param orderid   订单id
     * @return          返回一个订单详情集合
     */
    public ArrayList<OrderDetail> selectallOrderDetail(Integer orderid);

    /**
     * 根据2级品牌ID查找商品
     * @param pm    商品分页封装集合
     * @param var   二级id
     * @return      封装好的分页商品集合
     */
    public PageEntry<Product> selectPageProductBy2Lv(PageEntry<Product> pm, Object var);

    /**
     * 根据2级品牌ID查找商品
     * @param pm    商品分页封装集合
     * @param var   二级id
     * @return      封装好的分页商品集合
     */
    public PageEntry<Product> selectPageProductBy1Lv(PageEntry<Product> pm, Object var);

    /**
     * 通过规格ID来查找规格
     * @param codeid    规格id
     * @return          返回该规格ID所对应的CCODE
     */
    public CCODE Stock(Number codeid);

    /**
     * 查询该用户的收藏夹信息
     * @param userid    用户id
     * @return          用户的所有收藏物品
     */
    public ArrayList<Favority> showFavority(Number userid);

    /**
     * 添加收藏
     * @param fav   收藏的物品
     * @return      true：删除成功；false：删除失败
     */
    public Boolean addFay(Favority fav);

    /**
     * 删除收藏
     * @param userid    用户id
     * @param productid 商品ID
     * @return      true：删除成功；false：删除失败
     */
    public Boolean deleteFav(Number userid,Number productid);

    /**
     * 删除全部收藏
     * @param userid    用户id
     * @return          true：删除全部成功；false：删除全部失败
     */
    public Boolean deleteallFav(Number userid);

    /**
     * 判断是否收藏夹中已有该商品
     * @param userid        用户ID
     * @param productid     商品ID
     * @return              true:可以添加，收藏夹中没有；false：不可添加，收藏夹中已有
     */
    public Boolean oneFav(Number userid,Number productid);

    /**
     * 根据收藏夹得商品ID查找商品
     * @param fav   收藏的数据
     * @return      商品信息
     */
    public Product selectshoucangid(Favority fav);

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
    public PageEntry<Product> selectPageProduct(PageEntry<Product> pm, Class<Product> clazz, Integer mixPrice, Integer maxPrice, Object var,String sort,String order,Boolean flag);
}
