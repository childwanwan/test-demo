package com.sitech.learn.test.service;

import com.sitech.learn.test.vo.UserVo;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IUserService
 * Author:   Childwanwan
 * Date:     2019/2/28 16:08
 * Description: 用户服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface IUserService {
	public UserVo selectUserByUsernameAndId(String username,String password);
}
