package com.yilv.modules.dongtai.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilv.base.common.utils.hibernatepage.HPage;
import com.yilv.base.common.web.Result;
import com.yilv.base.modules.account.entity.Account;
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

	@RequestMapping("list")
	@ResponseBody
	public Object list(Integer pageNum) {
		HPage<DongtaiMsg> page = new HPage<DongtaiMsg>(pageNum);

		dtService.findPageList(new DongtaiMsg(new Account()), false, page, "account");

		return page;
	}
}
