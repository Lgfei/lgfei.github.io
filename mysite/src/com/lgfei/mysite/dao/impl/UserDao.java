package com.lgfei.mysite.dao.impl;

import com.lgfei.mysite.dao.IUserDao;
import com.lgfei.mysite.vo.UserInfoVO;

public class UserDao implements IUserDao {

	@Override
	public UserInfoVO findOneUser(UserInfoVO user) {
		UserInfoVO userInfoVO = new UserInfoVO();
		userInfoVO.setUserAccount("test1");
		userInfoVO.setUserName("test1_name");
		userInfoVO.setPassword("111111");
		return userInfoVO;
	}

}
