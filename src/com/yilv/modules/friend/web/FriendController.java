package com.yilv.modules.friend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilv.base.common.utils.AccountUtils;
import com.yilv.base.common.utils.StringUtils;
import com.yilv.base.common.web.Result;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.modules.friend.entity.Friend;
import com.yilv.common.web.BaseController;
import com.yilv.modules.friend.service.FriendService;

@Controller
@RequestMapping("${travelPath}/friend")
public class FriendController extends BaseController {

	@Autowired
	private FriendService friendService;

	@RequestMapping("save")
	@ResponseBody
	public Object save(String friendId) {
		if (StringUtils.isEmpty(friendId)) {
			return new Result(500);
		}
		return friendService.saveFriend(friendId);
	}

	@ResponseBody
	@RequestMapping("list")
	public Object listAll() {
		Friend friend = new Friend();
		Account account = new Account(AccountUtils.getAccount().getId());
		friend.setOwner(account);
		List<Friend> list = friendService.findList(friend, false, "owner");
		return list;
	}

}
