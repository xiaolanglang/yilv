package com.yilv.modules.friend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yilv.base.common.utils.AccountUtils;
import com.yilv.base.common.web.Result;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.modules.friend.entity.Friend;
import com.yilv.base.modules.friend.service.CFriendService;

@Service
public class FriendService extends CFriendService {

	public Result saveFriend(String friendId) {
		String id = AccountUtils.getAccount().getId();
		Account owner = new Account(id);
		Account user = new Account(friendId);
		Friend friend = new Friend();
		friend.setOwner(owner);
		friend.setFriend(user);
		friend.setMark("");
		if (checkFriend(friend)) {
			return new Result(500, "该用户已经是你的好友了");
		}
		save(friend);
		return new Result(200, "添加好友成功");
	}

	/**
	 * 检查好友是否已经添加了，添加了返回true，没有添加返回false
	 * 
	 * @param friend
	 * @return
	 */
	private boolean checkFriend(Friend friend) {
		List<Friend> list = findList(friend, false, "owner", "friend");
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}
}
