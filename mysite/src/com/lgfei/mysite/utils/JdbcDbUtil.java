package com.lgfei.mysite.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lgfei.mysite.vo.UserInfoVO;

public class JdbcDbUtil {

	private static JdbcDbUtil instance = null;

	private JdbcDbUtil() {
	}

	public static JdbcDbUtil createJdbcInstance() {
		if (instance == null) {
			instance = new JdbcDbUtil();
		}
		return instance;
	}

	private static final String url = "jdbc:mysql://localhost:3306/mysite";
	private static final String username = "root";
	private static final String password = "";

	public Connection openConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("数据库连接失败...");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("没有驱动jar...");
			e.printStackTrace();
		}

		return conn;
	}

	public void closeConn(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
				System.out.println("结果集rs已关闭...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
				System.out.println("声明stmt已关闭...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				System.out.println("数据库连接conn已关闭...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<UserInfoVO> findAllUsers(Connection conn, String sql) {
		ResultSet rs = null;
		Statement stmt = null;
		// PreparedStatement pstmt = null;

		List<UserInfoVO> users = null;
		try {
			stmt = conn.createStatement();
			// pstmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			users = new ArrayList<UserInfoVO>();
			while (rs.next()) {
				UserInfoVO user = new UserInfoVO();
				user.setUserId(rs.getLong("user_id"));
				user.setUserAccount(rs.getString("user_account"));
				user.setUserName(rs.getString("user_name"));

				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, stmt, conn);
		}

		return users;
	}

	public List<?> queryList(Connection conn, Object voClass, String sql,
			List params) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<Object> listVo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			int _index = 0;
			for (Object param : params) {
				_index++;
				if (param != null) {
					if ("java.lang.String".equals(param.getClass().getName())) {
						pstmt.setString(_index, param.toString());
					} else if ("java.lang.Integer".equals(param.getClass()
							.getName())) {
						pstmt.setInt(_index, Integer.valueOf(param.toString()));
					} else {
						pstmt.setObject(_index, param);
					}
				}
			}

			rs = pstmt.executeQuery();

			Class voc = voClass.getClass();
			listVo = new ArrayList<Object>();
			while (rs.next()) {
				voClass = voc.newInstance();

				Field[] fields = voc.getDeclaredFields();
				List<String> fieldNames = new ArrayList<String>();
				for (Field field : fields) {
					fieldNames.add(field.getName());
				}

				Method  method = null;
				for (String fieldName : fieldNames) {
					String typeName = voc.getDeclaredField(fieldName).getType()
							.getName();
					StringBuffer methodName = new StringBuffer("set");
					methodName.append(StringUtil.upperFirstWord(fieldName));
					
					if("java.lang.Long".equals(typeName)){
						method = voc.getMethod(methodName.toString(), Class.forName("java.lang.Long"));
						method.invoke(voClass, rs.getLong(fieldName));
					}else if("java.lang.String".equals(typeName)){
						method = voc.getMethod(methodName.toString(), Class.forName("java.lang.String"));
						method.invoke(voClass, rs.getString(fieldName));
					}else if("java.util.Date".equals(typeName)){
						method = voc.getMethod(methodName.toString(), Class.forName("java.util.Date"));
						method.invoke(voClass, rs.getDate(fieldName));
					}else{
						method = voc.getMethod(methodName.toString(), Class.forName("java.lang.Object"));
						method.invoke(voClass, rs.getObject(fieldName));
					}
				}
				listVo.add(voClass);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, conn);
		}

		return (List<?>)listVo;
	}
}
