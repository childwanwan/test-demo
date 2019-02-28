package com.sitech.learn.test.service;

import com.sitech.learn.test.vo.ErrorListVo;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestService
 * Author:   Childwanwan
 * Date:     2019/2/27 19:40
 * Description: 服务层接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface TestService {
	/*
	 * @Author:Childwanwan
	 * @Description:业务流程接口
	 * @Para:* @param null
	 * @data:2019/2/28  10:52
	 */
	public int insertErrorList(ErrorListVo errorList);
}
