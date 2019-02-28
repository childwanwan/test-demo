package com.sitech.learn.test.service.impl;

import com.sitech.learn.test.mapper.UserMapper;
import com.sitech.learn.test.service.IUserService;
import com.sitech.learn.test.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Childwanwan
 * Date:     2019/2/28 16:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class UserServiceImpl
		implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserVo selectUserByUsernameAndId(String username, String password) {
		UserVo user = new UserVo();
		user.setUserName(username);
		user.setPassword(password);
		List<UserVo> list = userMapper.select(user);
		if (list.size()>0){
		return list.get(0);
		}else {
			return null;
		}
	}
}
