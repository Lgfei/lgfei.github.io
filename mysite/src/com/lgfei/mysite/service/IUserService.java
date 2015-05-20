package com.lgfei.mysite.service;

import com.lgfei.mysite.message.ResultMessageVO;
import com.lgfei.mysite.vo.UserInfoVO;

public interface IUserService {

	public ResultMessageVO login(UserInfoVO user);
}
