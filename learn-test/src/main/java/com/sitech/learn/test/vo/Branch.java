package com.sitech.learn.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Branch
 * Author:   Childwanwan
 * Date:     2019/2/28 17:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data                                    //生成相应的get和set、toString
@Accessors(chain = true)                 //链式调用
@NoArgsConstructor                       //无参构造
@AllArgsConstructor                      //所以参数构造
@Table(name = "td_branch")        		 //绑定数据库表格
public class Branch {
	private Integer pkBranchId;
	private String BranchName;
}
