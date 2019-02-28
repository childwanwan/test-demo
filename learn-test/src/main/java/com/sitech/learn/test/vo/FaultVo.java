package com.sitech.learn.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Fault
 * Author:   Childwanwan
 * Date:     2019/2/28 13:22
 * Description:实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data                                    //生成相应的get和set、toString
@Accessors(chain = true)                 //链式调用
@NoArgsConstructor                       //无参构造
@AllArgsConstructor                      //所以参数构造
@Table(name = "td_fault")        		 //绑定数据库表格
public class FaultVo {

	//主键和主键生成策略
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkFaultId;

	private String FName;

	private Date createDate;

	private String FSys;

	private String FDes;

	private Date operateTime;

	private Integer FkBranch;

	private Integer FkUser;


}
