package com.sitech.learn.test.service;

import com.sitech.learn.test.vo.Branch;

import java.util.List;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IBranchService
 * Author:   Childwanwan
 * Date:     2019/2/28 17:35
 * Description: 分支服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface IBranchService {
	public List<Branch> selectAllBranch();
}
