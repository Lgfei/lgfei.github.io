package com.lgfei.mysite.dao;

import com.lgfei.mysite.vo.UserInfoVO;

public interface IUserDao {

	public UserInfoVO findOneUser(UserInfoVO user);
}
