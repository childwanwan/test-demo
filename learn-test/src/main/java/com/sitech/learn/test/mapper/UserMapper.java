package com.sitech.learn.test.mapper;

import com.sitech.learn.test.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserMapper
 * Author:   Childwanwan
 * Date:     2019/2/28 16:06
 * Description: 用户的mapper
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Mapper
public interface UserMapper
		extends tk.mybatis.mapper.common.Mapper<UserVo>{
}
