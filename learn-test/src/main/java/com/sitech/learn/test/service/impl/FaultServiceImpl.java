package com.sitech.learn.test.service.impl;

import com.sitech.learn.test.mapper.FaultMapper;
import com.sitech.learn.test.service.IFaultService;
import com.sitech.learn.test.vo.FaultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: FaultServiceImpl
 * Author:   Childwanwan
 * Date:     2019/2/28 13:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class FaultServiceImpl
		implements IFaultService {
	@Autowired
	private FaultMapper faultMapper;

	/*
	 * @Author:Childwanwan
	 * @Description:处理逻辑,插入数据
	 * @Para:* @param faultVo
	 * @data:2019/2/28  15:55
	 */
	@Override
	@Transactional
	public int insertFault(FaultVo faultVo) {
		return faultMapper.insert(faultVo);    //返回的是影响行数
	}

	@Override
	public List<FaultVo> getAllFault(int FKUser,int currentPage) {
		FaultVo fault = new FaultVo();
		fault.setFkUser(FKUser);
		//int count = faultMapper.getCountFault(FKUser);
		List<FaultVo> list = faultMapper.getFaultByPage((currentPage-1)*10,FKUser);
		//System.out.println(count);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getCountFault(int FKUser) {
		FaultVo fault = new FaultVo();
		return faultMapper.selectCount(fault);
	}
}
