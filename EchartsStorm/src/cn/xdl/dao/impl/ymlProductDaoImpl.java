package cn.yml.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yml.dao.ymlProductDao;
import cn.yml.utils.DBUtils;
import cn.yml.web.bean.ymlProduct;

public class ymlProductDaoImpl implements ymlProductDao {

	public List<ymlProduct> queryErrorAccount() {
		// 0. 定义一个集合将获取到的数据对象放入集合中
		List<ymlProduct> ymlProducts = new ArrayList<ymlProduct>();
		ymlProduct product = null;
		// 1. 获取连接对象
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			String sql = "select count from test3";
			//String sql2 = "select timeStamp,count from wordcount8";
			// 2. 执行sql语句
			// 2.1 使用数据库连接池，连接数据库
			conn = DBUtils.getConnection();
			// 2.2 准备执行SQL语句
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			// 3. 处理结果数据
			while (rs.next()) {
				product = new ymlProduct();
				product.setCount(rs.getInt("count"));
				ymlProducts.add(product);
			}
			// 4. 返回集合对象
			return ymlProducts;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭连接池
			DBUtils.close(conn, pst, rs);
		}
		return null;
	}
}
