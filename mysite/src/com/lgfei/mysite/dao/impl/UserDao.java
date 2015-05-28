package com.lgfei.mysite.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.lgfei.mysite.common.HibernateSessionFactory;
import com.lgfei.mysite.dao.IUserDao;
import com.lgfei.mysite.utils.JdbcDbUtil;
import com.lgfei.mysite.vo.UserInfoVO;

public class UserDao extends HibernateDaoSupport implements IUserDao {

	private JdbcDbUtil jdbcDbUtil = JdbcDbUtil.createJdbcInstance();
	private Connection conn = jdbcDbUtil.openConn();
	
	private Session session;
	
	@Override
	public UserInfoVO findOneUserByJDBC(UserInfoVO user) {
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

	@Override
	public UserInfoVO findOneUserByHibe(UserInfoVO user) {
		session = HibernateSessionFactory.currentSession();
		Query query = session.createQuery("from UserInfoVO where userAccount = '"+user.getUserAccount()+"'");
		List<UserInfoVO> list = query.list();
		//System.out.println(list.size());
		return list.get(0);
	}

	@Override
	public UserInfoVO findOneUser(UserInfoVO user) {
		String sql = "from UserInfoVO where userAccount = '"+user.getUserAccount()+"'";
		//Query query = getHibernateTemplate().getSessionFactory().openSession().createQuery(sql);
		List<Object> list = getHibernateTemplate().find(sql, null);//query.list();
		return (UserInfoVO)list.get(0);
	}
	
}
