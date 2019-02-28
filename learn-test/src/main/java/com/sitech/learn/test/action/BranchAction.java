package com.sitech.learn.test.action;

import com.sitech.learn.test.service.IBranchService;
import com.sitech.learn.test.vo.Branch;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: BranchAction
 * Author:   Childwanwan
 * Date:     2019/2/28 17:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
public class BranchAction {
	@Autowired
	private IBranchService branchService;

	/*
	 * @Author:Childwanwan
	 * @Description:获取所以分支信息
	 * @Para:* @param userName
	 * @data:2019/2/28  20:16
	 */
	@RequestMapping(value = "/branch/get_branch", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getAllBranch(@RequestParam("userName") String userName) {

		//需要返回的json对象
		JSONObject returnJson = new JSONObject();
		try {
			List<Branch> list = branchService.selectAllBranch();
			if (list != null && list.size() > 0) {    //查到数据了
				returnJson.put("code", 1);
				returnJson.put("message", "数据获取成功");
				returnJson.put("data", list);
			} else {    //没查到数据
				returnJson.put("code", -1);
				returnJson.put("message", "数据获取失败");
			}
		} catch (Exception e) {        //异常了
			returnJson.put("code", 0);
			returnJson.put("message", "系统内部异常");
		}

		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}
}
