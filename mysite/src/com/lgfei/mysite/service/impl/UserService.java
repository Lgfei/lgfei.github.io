package com.lgfei.mysite.service.impl;

import com.lgfei.mysite.dao.IUserDao;
import com.lgfei.mysite.dao.impl.UserDao;
import com.lgfei.mysite.message.ResultMessageVO;
import com.lgfei.mysite.service.IUserService;
import com.lgfei.mysite.utils.StringUtil;
import com.lgfei.mysite.vo.UserInfoVO;

public class UserService implements IUserService {

	private IUserDao userDao = new UserDao();
	
	@Override
	public ResultMessageVO login(UserInfoVO user) {
		ResultMessageVO resultMessageVO = new ResultMessageVO();
		resultMessageVO.setClassName(Thread.currentThread().getStackTrace()[1].getClassName());
		resultMessageVO.setMethodName(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		UserInfoVO loginUser = userDao.findOneUser(user);
		if(loginUser == null){
			resultMessageVO.setError(true);
			resultMessageVO.setMessage("用户名不存在");
		}else if(!this.passwordIscorrect(loginUser, user)){
			resultMessageVO.setError(true);
			resultMessageVO.setMessage("密码错误");
		}else{
			resultMessageVO.setError(false);
			resultMessageVO.setVoObj(loginUser);
		}
		
		return resultMessageVO;
	}

	private boolean passwordIscorrect(UserInfoVO auser,UserInfoVO anotherUser){
		if(auser == null || anotherUser == null){
			return false;
		}else{
			if(StringUtil.isNullOrEmpty(auser.getPassword())){
				return false;
			}else{
				return auser.getPassword().equals(anotherUser.getPassword()) ? true : false;
			}
		}
	}
}
