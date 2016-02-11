package com.yilv.modules.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.modules.account.service.CAccountService;

@Service
@Transactional(readOnly = true)
public class AccountService extends CAccountService {

}
