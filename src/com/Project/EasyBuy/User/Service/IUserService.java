package com.Project.EasyBuy.User.Service;

import com.Project.EasyBuy.User.Entry.*;
import com.Project.EasyBuy.User.Util.PageEntry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IUserService {

    /**
     * 获取相应密码的所有账户集合
     * @param amount 传入的账号数据
     * @param password  传入密码数据
     * @return      返回一个是这个密码的用户,null为没有这个用户
     */
    public User login(String amount, String password);

    /**
     * 对用户进行注册
     * @param user  一个封装好的用户数据
     * @return      返回注册成功的数据，null为没成功注册
     */
    public User register(User user);

    /**
     * 判断这个数据在是否在数据库中已存在
     * String 传入的数据
     * @return          返回是否重复，true：没重复，可使用；false：已重复，不可使用
     */
    public Boolean isrepeatEmail(String email);

    public Boolean isrepeatMobile(String mobile);

    public Boolean isrepeatUsername(String name);

    public Boolean isrepeatIdentitycode(String Identitycode);

    /**
     * 执行提交订单结算功能
     * @param order         order订单信息对象，用于存储
     * @param orderDetail   orderDetail订单详情对象，用于存储订单详细信息
     * @return              true：提交成功；false：提交失败
     */
    public Boolean isSubmitOrder(Order order, ArrayList<OrderDetail> orderDetail) throws SQLException;

    /**
     * 修改用户信息
     * @param user  传入封装好的用户信息数据
     * @return      返回一个修改好的user对象，如果为null，代表修改失败
     */
    public User ModifyUser(User user);

    /**
     * 获取分页的商品信息
     * @param pe    已经存取了的商品分页信息集合
     * @param var   根据var来进行分类查询 没有则查询全部商品信息
     * @return      返回一个分页好的PageEntry<Product>
     */
    public PageEntry<Product> PageProduct(PageEntry<Product> pe, Object var, String order,Boolean flag);

    /**
     * 根据id查找对应表的数据
     * @param Table     数据库表名
     * @param column    数据库要查找的ID所对应的列名
     * @param ID        需要查找的ID
     * @return          返回一个根据ID所找到的数据信息
     */
    public Product ProductByID(String Table,String column,Number ID);

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

    public Boolean ModifyAddressDefault(Integer userid);

    /**
     * 查询对应商品销量的方法
     * @param orderDetail   订单详情
     * @return              返回一个商品销量的数量
     */
    public Integer productSales(OrderDetail orderDetail);

    /**
     * 判断购物车是否有该物品
     * @param productid     物品的id
     * @param userid        用户的id
     * @return              true：已有；不可添加；false：没有，可以添加
     */
    public Boolean isrepeartshoprecord(Number productid,Number userid,Number codeid);

    /**
     * 删除全部历史记录
     * @param userid    用户id
     * @return      true：删除成功；false：删除失败
     */
    public Boolean deletehistory(Number userid);

    /**
     * 通过销量/创建时间排序
     * @param pm        封装好的分页数据集合
     * @param var       根据销量来进行查找
     * @param flag      true：根据商品名称查找；false：根据商品描述的模糊查询
     * @param index     index：排序顺序
     * @return
     */
    public PageEntry<Product> selectPageProductBySales(PageEntry<Product> pm, Object var,Boolean flag,String index);
    /**
     * 通过销量/创建时间排序
     * @param pm        封装好的分页数据集合
     * @param var       根据创建时间来进行查找
     * @param flag      true：根据商品名称查找；false：根据商品描述的模糊查询
     * @param index     index：1升序排序；其他为降序排序
     * @return
     */
    public PageEntry<Product> selectPageProductBycreatetime(PageEntry<Product> pm,Object var,Boolean flag,String index);

    /**
     * 根据价格区间寻找商品
     * @param mixPrice      最小价格
     * @param maxPrice      最大价格
     * @param var           根据什么来进行分页数据
     * @param flag          true:查找名称；false：查找描述
     * @return              封装好的分页数据集合
     */
    public PageEntry<Product> selePageProductByPrice(PageEntry<Product> pe,Class<Product> clazz,Integer mixPrice,Integer maxPrice,Object var,String order,Boolean flag);

    /**
     * 根据二级标题查找对应的封装好的分页商品集合
     * @param pm        封装好的分页商品集合
     * @param var       二级标题的名称
     * @return          返回一个封装好的商品集合
     */
    public PageEntry<Product> selectPageProductBy3Lv(PageEntry<Product> pm,Object var);

    /**
     * 获取新闻集合
     * @return  返回一个最新的新品描述新闻
     */
    public ArrayList<News> News();

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
     * @param var   要使用父级id    返回类型数据的map集合
     * @return      String：为0，1，2，3的key从0开始，集合为该key锁对应的数据
     */
    public HashMap<String,ArrayList<CCODE>> getType(Integer var);

    /**
     * 通过ID来查找对应的类型集合  8typeid
     * @param id        parentid的id
     * @return          返回一个封装好的Category集合
     */
    public ArrayList<Category> selectType1(Integer id);

    /**
     * 通过ID来查找对应的类型集合  9typeid
     * @param id        parentid的id
     * @return          返回一个封装好的Category集合
     */
    public ArrayList<Category> selectType2(Integer id);

    /**
     * 根据ID查找对应品牌
     * @param id    品牌ID
     * @return      封装好的品牌
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
     * @param productid 商品id
     * @param color     颜色
     * @param spec      属性
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
     * 提交订单
     * @param order 订单数据
     * @return  true：成功
     */
    public Boolean OrderSubmit(Order order);

    /**
     * 提交订单详情
     * @param orderDetails  订单详情集合
     * @return
     */
    public Boolean OrderDetailSubmit(ArrayList<OrderDetail> orderDetails);

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
     * @param mixPrice  最小价格
     * @param maxPrice  最大价格
     * @param var       查询的事物
     * @param sort      根据什么来排序例如：创建时间，价格或者品牌id
     * @param order     顺序还是倒序“asc”顺序，“desc”倒叙
     * @param flag      true：通过名称的模糊查找 false：通过描述的模糊查找
     * @return
     */
    public PageEntry<Product> selectPageProduct(PageEntry<Product> pm, Integer mixPrice, Integer maxPrice, Object var,String sort,String order,Boolean flag);
}
