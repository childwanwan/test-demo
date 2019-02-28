package com.sitech.learn.test.mapper;

import com.sitech.learn.test.vo.ErrorListVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestMapper
 * Author:   Childwanwan
 * Date:     2019/2/28 10:14
 * Description: mapper in mybatis
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@Mapper
public interface TestMapper
		extends tk.mybatis.mapper.common.Mapper<ErrorListVo> {
}
