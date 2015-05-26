package com.lgfei.mysite.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lgfei.mysite.dao.IUserDao;
import com.lgfei.mysite.utils.JdbcDbUtil;
import com.lgfei.mysite.vo.UserInfoVO;

public class UserDao implements IUserDao {

	private JdbcDbUtil jdbcDbUtil = JdbcDbUtil.createJdbcInstance();
	private Connection conn = jdbcDbUtil.openConn();
	
	@Override
	public UserInfoVO findOneUser(UserInfoVO user) {
		String sql = "select t.user_id userId,"
				+ "t.user_account userAccount,"
				+ "t.user_name userName,"
				+ "t.addr addr,t.birthday birthday,"
				+ "t.`password` `password`,"
				+ "t.email email,"
				+ "t.phone phone "
				+ "from user_info_t t "
				+ "where t.user_account = ?";
		List<String> params = new ArrayList<String>();
		params.add(user.getUserAccount());
		List<?> users = jdbcDbUtil.queryList(conn, new UserInfoVO(), sql, params);
		return (UserInfoVO)users.get(0);
	}

}
