package com.yilv.modules.file.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.modules.file.response.YFileMin;
import com.yilv.base.modules.file.service.CYFileService;

@Service
@Transactional(readOnly = true)
public class YFileService extends CYFileService {

	public List<YFileMin> findFilesByEntityIds(List<String> ids) {
		return dao.findFilesByEntityIds(ids);
	}

}
