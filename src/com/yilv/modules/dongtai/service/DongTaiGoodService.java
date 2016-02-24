package com.yilv.modules.dongtai.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.utils.AccountUtils;
import com.yilv.base.common.web.Result;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.modules.dongtai.entity.DongTaiGood;
import com.yilv.base.modules.dongtai.service.CDongTaiGoodService;

@Service
@Transactional(readOnly = true)
public class DongTaiGoodService extends CDongTaiGoodService {

	@Transactional
	public void good(DongTaiGood good, Result result) {
		Account account = new Account(AccountUtils.getAccount().getId());
		good.setUser(account);
		List<DongTaiGood> list = hDao.findList(good, false, "user", "dongTai");
		if (list == null || list.size() == 0) {
			save(good);
			result.setMessage("add");
		} else {
			trueDelete(list.get(0));
			result.setMessage("cancel");
		}
		result.setCode(200);
	}

}
