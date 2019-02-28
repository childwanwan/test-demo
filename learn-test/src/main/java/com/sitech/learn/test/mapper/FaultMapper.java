package com.sitech.learn.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sitech.learn.test.vo.FaultVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: FaultMapper
 * Author:   Childwanwan
 * Date:     2019/2/28 13:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Mapper		//mapper扫描器
public interface FaultMapper
		extends tk.mybatis.mapper.common.Mapper<FaultVo>{

	@Select("select * from td_fault where fk_user =${FKUser} LIMIT ${first},10")
	public List<FaultVo> getFaultByPage(int first,int FKUser);

}
