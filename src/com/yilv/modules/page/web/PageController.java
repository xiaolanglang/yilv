package com.yilv.modules.page.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yilv.common.web.BaseController;

@Controller
public class PageController extends BaseController {

	@RequestMapping("12")
	public String index() {
		return "page/dongtai";
	}

}
