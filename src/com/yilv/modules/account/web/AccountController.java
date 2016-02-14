package com.yilv.modules.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilv.base.common.web.Result;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.common.web.BaseController;
import com.yilv.modules.account.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController extends BaseController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("info")
	@ResponseBody
	public Object saveinfo(Account account) {
		accountService.save(account);
		return new Result(200, "完善个人信息成功");
	}
}
