package com.yilv.modules.dongtai.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.modules.dongtai.service.CDongTaiService;

@Service
@Transactional(readOnly = true)
public class DongTaiService extends CDongTaiService {

}
