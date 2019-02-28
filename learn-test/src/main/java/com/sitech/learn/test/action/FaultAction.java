package com.sitech.learn.test.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sitech.learn.test.service.IFaultService;
import com.sitech.learn.test.vo.FaultVo;
import com.sitech.learn.test.form.FaultForm;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: FaultAction
 * Author:   Childwanwan
 * Date:     2019/2/28 13:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
public class FaultAction {

	@Autowired
	private IFaultService iFaultService;

	/*
	 * @Author:Childwanwan
	 * @Description:action的接口函数,处理数据整理
	 * @Para:* @param jsonObject
	 * @data:2019/2/28  10:29
	 */
	@RequestMapping(value = "/fault/post_fault", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> postError(@RequestBody JSONObject jsonObject) {
		System.out.println(jsonObject);
		//获取到数据，第一层的json
		//故障系统数组
		JSONArray jsonArrayParam = jsonObject.getJSONArray("fSys");
		//初始化数据
		FaultVo faultVo = new FaultVo();
		faultVo.setFName(jsonObject.get("fName").toString());
		faultVo.setCreateDate(new Date(Long.valueOf(jsonObject.get("createDate").toString())));
		faultVo.setFkBranch((int) jsonObject.get("branch"));
		faultVo.setFDes(jsonObject.get("fDes").toString());
		faultVo.setFSys(jsonObject.get("fSys").toString());
		faultVo.setFkUser((int) jsonObject.get("FKUser"));

		//自己给的日期数据
		faultVo.setOperateTime(new Date());

		//返回的数据
		JSONObject returnJson = new JSONObject();
		try {
			if (iFaultService.insertFault(faultVo) > 0) {
				returnJson.put("code", 1);
				returnJson.put("message", "插入数据成功");
			} else {
				returnJson.put("code", 0);
				returnJson.put("message", "插入数据失败");
			}
		} catch (Exception e) {
			returnJson.put("code", -1);
			returnJson.put("message", "系统内部异常");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}

	/*
	 * @Author:Childwanwan
	 * @Description:根据FKUser获取所以得错误单
	 * @Para:* @param FKUser
	 * @data:2019/2/28  20:11
	 */
	@RequestMapping(value = "/fault/get_fault", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getAllFault(@RequestParam("FKUser") Integer FKUser,@RequestParam("currentPage") Integer currentPage) {

		//需要返回的json数据
		JSONObject returnJson = new JSONObject();

			//调用服务层，获取到相应的List集合
			List<FaultVo> list = iFaultService.getAllFault(FKUser,currentPage);
			System.out.println(list);
			int count = iFaultService.getCountFault(FKUser);
			System.out.println(count);
			if (list != null && list.size() > 0) {
				//需要返回的data,form层的数据集合
				List<FaultForm> listForm = new ArrayList<>();
				FaultForm faultForm = new FaultForm();
				//把数据库的数据转换成form层的数据,List<FaultVo>转换成List<FaultForm>
				for (int i = 0, j = list.size(); i < j; i++) {
					faultForm.setFName(list.get(i).getFName());
					faultForm.setFDes(list.get(i).getFDes());
					faultForm.setFkBranch(list.get(i).getFkBranch());
					faultForm.setFkUser(list.get(i).getFkUser());
					faultForm.setFSys(list.get(i).getFSys());
					faultForm.setCreateDate(list.get(i).getCreateDate().getTime());
					faultForm.setOperateTime(list.get(i).getOperateTime().getTime());
					faultForm.setPkFaultId(list.get(i).getPkFaultId());
					listForm.add(faultForm);
				}
				//返回json数据添加数据
				returnJson.put("code", 1);
				returnJson.put("message", "数据获取成功");
				returnJson.put("data", listForm);
				returnJson.put("count",count);
			} else {
				returnJson.put("code", 0);
				returnJson.put("message", "数据获取失败");
			}try {
		} catch (Exception e) {
			returnJson.put("code", -1);
			returnJson.put("message", "系统内部异常");
		}
		return new ResponseEntity<>(returnJson, HttpStatus.ACCEPTED);
	}
}
