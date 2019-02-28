package com.sitech.learn.test.action;

import com.sitech.learn.test.service.IUserService;
import com.sitech.learn.test.vo.FaultVo;
import com.sitech.learn.test.vo.UserVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: UserAction
 * Author:   Childwanwan
 * Date:     2019/2/28 16:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
public class UserAction {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> login(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject);
		JSONObject returnJson = new JSONObject();
		try {
			//调用服务层代码，返回的用户对象
			UserVo user = userService.selectUserByUsernameAndId(jsonObject.get("userName").toString(), jsonObject.get("password").toString());
			if (user != null) {
				returnJson.put("code", 1);
				returnJson.put("message", "登入成功");
				JSONObject jsonData = new JSONObject();
				jsonData.put("userName", user.getUserName());
				jsonData.put("FKUser", user.getPkUserId().toString());
				returnJson.put("data", jsonData);
			} else {    //没找到user的情况
				returnJson.put("code", -1);
				returnJson.put("message", "登入失败，确定账号密码");
			}
		} catch (Exception e) {		//异常了
			returnJson.put("code", 0);
			returnJson.put("message", "系统内部异常");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}
}
