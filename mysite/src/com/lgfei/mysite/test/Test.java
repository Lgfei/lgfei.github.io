package com.lgfei.mysite.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lgfei.mysite.utils.JdbcDbUtil;
import com.lgfei.mysite.utils.StringUtil;
import com.lgfei.mysite.vo.UserInfoVO;
import com.lgfei.mysite.vo.VO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		test.testJdbcDbUtil();
	}
	
	public void testJdbcDbUtil(){
		JdbcDbUtil jdbcDbUtil = JdbcDbUtil.createJdbcInstance();
		Connection conn = jdbcDbUtil.openConn();
		/*String sql = "select * from user_info_t";
		List<UserInfoVO> users = jdbcDbUtil.findAllUsers(conn, sql);
		for (UserInfoVO user : users) {
			System.out.println("user["+user.getUserId()+","+user.getUserName()+","+user.getUserName()+"]");
		}*/
		
		String sql = "select t.user_id userId,t.user_account userAccount,t.user_name userName,t.addr addr,t.birthday birthday,t.`password` `password`,t.email email,t.phone phone from user_info_t t where t.user_account = ?";
		List params = new ArrayList();
		params.add("test2");
		List<?> users = jdbcDbUtil.queryList(conn, new UserInfoVO(), sql, params);
		for (Object user : users) {
			System.out.println("user["+((UserInfoVO)user).getUserId()+","+((UserInfoVO)user).getUserName()+","+((UserInfoVO)user).getUserName()+"]");
		}
	}

}
