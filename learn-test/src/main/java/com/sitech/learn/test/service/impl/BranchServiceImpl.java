package com.sitech.learn.test.service.impl;

import com.sitech.learn.test.mapper.BranchMapper;
import com.sitech.learn.test.service.IBranchService;
import com.sitech.learn.test.vo.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: BranchServiceImpl
 * Author:   Childwanwan
 * Date:     2019/2/28 17:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class BranchServiceImpl
		implements IBranchService {
	@Autowired
	private BranchMapper branchMapper;

	@Override
	public List<Branch> selectAllBranch() {

		List<Branch> list = branchMapper.selectAll();
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
}
