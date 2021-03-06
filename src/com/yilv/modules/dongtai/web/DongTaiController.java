package com.yilv.modules.dongtai.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilv.base.common.utils.page.mbatis.MPage;
import com.yilv.base.common.web.Result;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.response.DongtaiMsg;
import com.yilv.common.web.BaseController;
import com.yilv.modules.dongtai.service.DongTaiService;
import com.yilv.modules.file.service.YFileService;

@Controller
@RequestMapping("${travelPath}/dongtai")
public class DongTaiController extends BaseController {

	@Autowired
	private DongTaiService dtService;

	@Autowired
	private YFileService fileService;

	@RequestMapping("save")
	@ResponseBody
	public Object save(DongTai dongTai, HttpServletRequest request) {
		dtService.save(dongTai, request);
		return new Result(200, "发送成功");
	}

	@RequestMapping("list")
	@ResponseBody
	public Object list(Integer pageNum) {
		MPage<DongtaiMsg> page = new MPage<DongtaiMsg>(pageNum);

		dtService.findMsgPageList(page);

		return page;
	}
}
