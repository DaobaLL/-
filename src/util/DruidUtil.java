package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.work.hander.IResultSetHandler;

public class DruidUtil {

	// 贾琏欲执事
	// 创建资源文件对象
	private static DataSource dataSource = null;
	// 加载注册驱动
	static {
		try {
			Properties properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	// DML操作
	public static void update(String sql, Object... params) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = DruidUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			for (int index = 0; index < params.length; index++) {
				pStatement.setObject(index + 1, params[index]);
			}
			int exeUpdate = pStatement.executeUpdate();
			System.out.println(exeUpdate);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DruidUtil.closeAll(connection, pStatement, null);
		}
	}

	// DQL操作
	public static <T> T query(String sql, IResultSetHandler<T> rsh, Object... params) {
		// 贾琏欲执事
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		// 返回一个结果集
		try {
			// 3.创建语句对象
			connection = DruidUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			//设置占位符参数
			for (int index = 0; index < params.length; index++) {
				pStatement.setObject(index + 1, params[index]);
			}
			// 执行sql语句
				// 4.执行SQL语句
			if (pStatement != null) {
				resultSet = pStatement.executeQuery();
			}
			T handle_1 = rsh.handle(resultSet);
			return handle_1;// 将结果集传递给传入类的结果集处理器
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DruidUtil.closeAll(connection, pStatement, resultSet);

		}
		return null;

	}

	// 关闭所有资源
	public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (null != connection) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (null != statement) {
				statement.close();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (null != resultSet) {
				resultSet.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
