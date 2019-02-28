package com.sitech.learn.test.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;



/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: FaultForm
 * Author:   Childwanwan
 * Date:     2019/2/28 19:03
 * Description:视图层的类，主要是将Fault转日期类型
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Data                                    //生成相应的get和set、toString
@Accessors(chain = true)                 //链式调用
@NoArgsConstructor                       //无参构造
@AllArgsConstructor                      //所以参数构造
public class FaultForm {

	private Integer pkFaultId;

	private String FName;

	private Long createDate;

	private String FSys;

	private String FDes;

	private Long operateTime;

	private Integer FkBranch;

	private Integer FkUser;
}
