package com.yilv.modules.page.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yilv.base.common.utils.AccountUtils;
import com.yilv.base.sys.security.SystemAuthorizingRealm.Principal;
import com.yilv.common.web.BaseController;

@Controller
public class PageController extends BaseController {

	// ------------动态以及评论部分

	@RequestMapping("")
	public String index() {
		return "index/index";
	}

	@RequestMapping("${travelPath}/dongtai/detail")
	public String dongTaiDetail() {
		return "index/detail";
	}

	// ------------资讯以及详细内容

	@RequestMapping("${travelPath}/zixun")
	public String zixun() {
		return "zixun/index";
	}

	@RequestMapping("${travelPath}/zixun/detail")
	public String zixunDetail() {
		return "zixun/detail";
	}

	// ------------消息部分

	@RequestMapping("${travelPath}/news")
	public String news() {
		return "news/index";
	}

	// ------------个人中心

	@RequestMapping("${travelPath}/mine")
	public String mine(Model model) {
		Principal principal = AccountUtils.getPrincipal();
		if (principal != null) {
			model.addAttribute("user", AccountUtils.getAccount());
		}
		return "mine/index";
	}

	@RequestMapping("${travelPath}/mine/login")
	public String mineLogin() {
		return "mine/login";
	}

	@RequestMapping("${travelPath}/mine/register")
	public String mineRegister() {
		return "mine/register";
	}
}
