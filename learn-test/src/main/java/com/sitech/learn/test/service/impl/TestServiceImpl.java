package com.sitech.learn.test.service.impl;

import com.sitech.learn.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitech.learn.test.service.TestService;
import com.sitech.learn.test.vo.ErrorListVo;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: TestServiceImpl
 * Author:   Childwanwan
 * Date:     2019/2/27 20:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class TestServiceImpl
		implements TestService {

	@Autowired
	private TestMapper testMapper;


	/*
	 * @Author:Childwanwan
	 * @Description:插入数据业务
	 * @Para:* @param errorList
	 * @data:2019/2/28  10:51
	 */
	@Override
	@Transactional
	public int insertErrorList(ErrorListVo errorList) {
		//请求和返回
		return testMapper.insert(errorList);
	}
}
