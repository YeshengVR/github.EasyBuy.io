package com.Project.EasyBuy.User.Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;


public class JDBCUtil {
	
	private static ComboPooledDataSource cs=new ComboPooledDataSource("mvcApp");

	public static <T> PageEntry<T> selectPageFuzzy(PageEntry<T> pm, Class<T> clazz, Object var,String table,String columnusername,String order) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		ArrayList<T> arr = new ArrayList<T>();
		try {
			conn = JDBCUtil.getConnection();
			String sqlcount = "select count(1) from " + table+" where 1=1";
			if(var != null&&var!=""){
				sqlcount+=" and " + columnusername + " like  ?";
			}
			state = conn.prepareStatement(sqlcount);
			if(var != null&&var!="") {
				if ("%".equalsIgnoreCase(var.toString()) || "_".equalsIgnoreCase(var.toString())) {
					state.setObject(1, "%d1wa651d133213%");
				} else {
					state.setObject(1, "%" + var + "%");
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
			String sqlarr = "select *from (select rownum r, T.*from (select * from " + table + " where 1=1 ";
			if(var != null&&var!=""){
				sqlarr +=" and "+columnusername+" like ?";
			}
			sqlarr +=" order by " + order + ") T where rownum <= ?)temp where temp.r >= ?";
			state = conn.prepareStatement(sqlarr);
			if(var != null&&var!=""){
				if ("%".equalsIgnoreCase(var.toString()) || "_".equalsIgnoreCase(var.toString())) {
					state.setObject(1, "%d1wa651d133213%");
				}else {
					state.setObject(1, "%" + var + "%");
				}
				state.setInt(2, end);
				state.setInt(3, start);
			}else {
				state.setInt(1, end);
				state.setInt(2, start);
			}
			rs = state.executeQuery();
			Field[] declaredFields = clazz.getDeclaredFields();
			while (rs.next()) {
				T t = clazz.newInstance();
				for (Field declaredField : declaredFields) {
					declaredField.setAccessible(true);
					ResultSetMetaData metaData = rs.getMetaData();
					for (int i = 2; i <= metaData.getColumnCount(); i++) {
						String columnName = metaData.getColumnName(i);
						if (columnName.equalsIgnoreCase(declaredField.getName())) {
							if(metaData.getColumnTypeName(i).equalsIgnoreCase("clob")){
								declaredField.set(t, rs.getString(declaredField.getName()));
							}else {
								declaredField.set(t, rs.getObject(declaredField.getName()));
							}
						}
					}
				}
				arr.add(t);
			}
			pm.setList(arr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, state, conn);
		}
		return pm;
	}
	public static <T> PageEntry<T> selectPagePrecise(PageEntry<T> pm, Class<T> clazz, Object var,String table,String columnusername,String order) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		ArrayList<T> arr = new ArrayList<T>();
		try {
			conn = JDBCUtil.getConnection();
			String sqlcount = "select count(1) from " + table+" where 1=1";
			if(var != null&&var!=""){
				sqlcount+=" and " + columnusername + " =  ?";
			}
			state = conn.prepareStatement(sqlcount);
			if(var != null&&var!=""){
				state.setObject(1, var);
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

			String sqlarr = "select *from (select rownum r, T.*from (select * from " + table + " where 1=1 ";
			if(var != null&&var!=""){
				sqlarr +=" and "+columnusername+" = ?";
			}
			sqlarr +=" order by " + order + ") T where rownum <= ?)temp where temp.r >= ?";
			state = conn.prepareStatement(sqlarr);
			if(var != null&&var!=""){
				state.setObject(1, var);
				state.setInt(2, end);
				state.setInt(3, start);
			}else {
				state.setInt(1, end);
				state.setInt(2, start);
			}
			rs = state.executeQuery();
			Field[] declaredFields = clazz.getDeclaredFields();
			while (rs.next()) {
				T t = clazz.newInstance();
				for (Field declaredField : declaredFields) {
					declaredField.setAccessible(true);
					ResultSetMetaData metaData = rs.getMetaData();
					for (int i = 2; i <= metaData.getColumnCount(); i++) {
						String columnName = metaData.getColumnName(i);
						if (columnName.equalsIgnoreCase(declaredField.getName())) {
							if(metaData.getColumnTypeName(i).equalsIgnoreCase("clob")){
								declaredField.set(t, rs.getString(declaredField.getName()));
							}else {
								declaredField.set(t, rs.getObject(declaredField.getName()));
							}
						}
					}
				}
				arr.add(t);
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
	 * 返回查询到的数据集合以ArrayList集合传出。
	 */
	public static <T> ArrayList<T> Select(ResultSet rs, Class<T> clazz) {
		ArrayList<T> arr = new ArrayList<T>();
		Field[] fields = clazz.getDeclaredFields();
		try {
			// 指向查询的结果集的每一行属性
			while (rs.next()) {
				// 创建一个对象接受属性信息
				T nowUser = clazz.newInstance();
				for (Field field : fields) {
					field.setAccessible(true);// 可读取私有属性
					// getObject()：获取当前行的指定列的值。field.getName()获取当前属性的指定列名称
					// 将每个字段的值传入nowUser对象中
					ResultSetMetaData metaData = rs.getMetaData();
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						String columnName = metaData.getColumnName(i);
						if (columnName.toLowerCase().equals(field.getName().toLowerCase())) {
							if(metaData.getColumnTypeName(i).equalsIgnoreCase("clob")){
								field.set(nowUser, rs.getString(field.getName()));
							}else {
								field.set(nowUser, rs.getObject(field.getName()));
							}
						}
					}
				}
				// 在集合中添加nowUser对象。
				arr.add(nowUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return arr;
	}

	/**
	 * 根据sql语句执行update事件
	 * @param sql	要执行的sql语句
	 * @return		返回一个是否成功更新的boolean值
	 */
	public boolean UpdateNothing(String sql) {
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = JDBCUtil.getConnection();
			state = conn.prepareStatement(sql);
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(null, state, conn);
		}
		return true;
	}

	/**
	 * 获取驱动链接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = cs.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭资源文件
	 * @param rs	查询结果集
	 * @param state	state执行结果
	 * @param conn	驱动链接
	 */
	public static void close(ResultSet rs,Statement state,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(state!=null){
					state.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
