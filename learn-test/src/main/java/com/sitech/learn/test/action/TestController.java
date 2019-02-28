package com.sitech.learn.test.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import com.sitech.learn.test.vo.ErrorListVo;
import com.sitech.learn.test.service.TestService;
import com.sitech.learn.test.utils.CommonUtils;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: TestController
 * Author:   Childwanwan
 * Date:     2019/2/27 19:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
//@Controller
//@RequestMapping
@RestController                    //类似上面两个的功能
public class TestController {

	/*//TestService对象
	@Autowired
	private TestService testService;

	//工具类
	@Autowired
	private CommonUtils commonUtils;

	//测试函数，无用
	@GetMapping("hello")
	public String hello() {
		return "hello, spring boot!";
	}


	*//*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 *//*
	@RequestMapping(value = "/error_list_wanpp/post_error", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> postError(@RequestBody JSONObject jsonObject) {
		//System.out.println(jsonObject);
		//获取到数据，第一层的json
		JSONObject jsonObjectFirstFloor = (JSONObject) jsonObject.get("param");
		//System.out.println(jsonObjectFirstFloor);
		//System.out.println(jsonObjectFirstFloor.get("insertData"));
		//获取第一层json中的数组
		JSONArray jsonArrayParam = jsonObjectFirstFloor.getJSONArray("insertData");
		//System.out.println(jsonArray);
		//处理数组,改变成我们想要的json数组,jsonArray1直接存数据库的字段。
		JSONArray jsonArray = new JSONArray();
		//System.out.println(jsonArray.size());
		for (int i = 0, j = jsonArrayParam.size(); i < j; i++) {
			jsonArray.add(jsonArrayParam.getJSONObject(i).get("data"));
			//jsonArray1.set(i,jsonArray);
		}
		//System.out.println(jsonArray1);

		//JSONArray jsonArray = jsonObject.getJSONArray("type");
		//System.out.println(jsonArray);
		//插入的对象，初始化
		ErrorListVo errorList = new ErrorListVo();
		errorList.setId(commonUtils.getUUID());
		errorList.setUpdateTime(new Date());
		errorList.setUpdateUser("Childwanwan");
		errorList.setName(jsonObjectFirstFloor.get("failureName").toString());
		errorList.setDate(new Date(Long.valueOf(jsonObjectFirstFloor.get("date").toString())));
		errorList.setErrorBranch(jsonObjectFirstFloor.get("area").toString());
		errorList.setDescription(jsonObjectFirstFloor.get("desc").toString());
		errorList.setType(jsonArray.toString());

		//判定数据插入成功与否，并准备返回数据
		JSONObject jsonObject2 = new JSONObject();
		if (testService.insertErrorList(errorList) > 0) {
			jsonObject2.put("code", 1);
			jsonObject2.put("message", "OK");
		} else {
			jsonObject2.put("code", -1);
			jsonObject2.put("message", "系统内部异常");
		}
		return new ResponseEntity<>(jsonObject, HttpStatus.ACCEPTED);

	}*/
}
