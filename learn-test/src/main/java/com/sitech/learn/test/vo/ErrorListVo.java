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
 * FileName: ErrorList
 * Author:   Childwanwan
 * Date:     2019/2/27 20:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data                                    //生成相应的get和set、toString
@Accessors(chain = true)                //链式调用
@NoArgsConstructor                        //无参构造
@AllArgsConstructor                        //所以参数构造
@Table(name = "error_list_wanpp")        //绑定数据库表格
public class ErrorListVo {

	@NotNull(message = "昵称不能为空")    //非空限制
	private String name;

	//主键和主键生成策略
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@NotNull(message = "日期不能为空")
	private Date date;
	private String errorBranch;
	private String type;
	private Date updateTime;
	private String updateUser;
	private String description;
}
