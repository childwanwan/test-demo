package com.sitech.learn.test.service;

import com.sitech.learn.test.vo.FaultVo;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IFaultService
 * Author:   Childwanwan
 * Date:     2019/2/28 13:34
 * Description: 服务层接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface IFaultService {
	/*
	 * @Author:Childwanwan
	 * @Description:插入逻辑接口
	 * @Para:* @param null
	 * @data:2019/2/28  15:56
	 */
	public int insertFault(FaultVo faultVo);

	public List<FaultVo> getAllFault(int FKUser,int currentPage);

	public int getCountFault(int FKUser);

}
