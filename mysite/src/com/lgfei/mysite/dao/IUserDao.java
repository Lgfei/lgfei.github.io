package com.lgfei.mysite.dao;

import com.lgfei.mysite.vo.UserInfoVO;

public interface IUserDao {

	public UserInfoVO findOneUserByJDBC(UserInfoVO user);
	
	public UserInfoVO findOneUserByHibe(UserInfoVO user);
	
	public UserInfoVO findOneUser(UserInfoVO user);
}
