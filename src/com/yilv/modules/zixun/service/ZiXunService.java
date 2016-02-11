package com.yilv.modules.zixun.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.modules.zixun.service.CZiXunService;

@Service
@Transactional(readOnly = true)
public class ZiXunService extends CZiXunService {

}
