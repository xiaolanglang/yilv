package com.yilv.modules.file.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.modules.file.service.CYFileService;

@Service
@Transactional(readOnly = true)
public class YFileService extends CYFileService {

}
