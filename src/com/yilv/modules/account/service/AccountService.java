package com.yilv.modules.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.utils.StringUtils;
import com.yilv.base.common.utils.page.hibernate.HPage;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.modules.account.service.CAccountService;

@Service
@Transactional(readOnly = true)
public class AccountService extends CAccountService {

	public boolean checkRegister(Account account) {
		if (StringUtils.isEmpty(account.getUsername()) || StringUtils.isEmpty(account.getPassword())) {
			return false;
		}
		List<Account> list = findList(new Account(account.getUsername(), null), false);
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}

	public void findPageListByNickname(Account account, boolean cache, HPage<Account> page) {
		hDao.findPageListByNickname(account, cache, page);
	}
}
