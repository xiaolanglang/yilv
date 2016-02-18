package com.yilv.modules.dongtai.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilv.base.common.web.Result;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.common.web.BaseController;
import com.yilv.modules.dongtai.service.DongTaiService;

@Controller
@RequestMapping("${travelPath}/dongtai")
public class DongTaiController extends BaseController {

	@Autowired
	private DongTaiService dtService;

	@RequestMapping("local/page/dongtai/write")
	public String writePage() {
		return "dongtai/write";
	}

	@RequestMapping("save")
	@ResponseBody
	public Object save(DongTai dongTai, HttpServletRequest request) {
		dtService.save(dongTai, request);
		return new Result(200, "发送成功");
	}
}
