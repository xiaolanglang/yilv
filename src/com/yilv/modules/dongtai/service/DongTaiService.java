package com.yilv.modules.dongtai.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.utils.FileUploadUtils;
import com.yilv.base.common.utils.IdUtils;
import com.yilv.base.modules.dongtai.service.CDongTaiService;
import com.yilv.modules.dongtai.request.Write;

@Service
@Transactional(readOnly = true)
public class DongTaiService extends CDongTaiService {

	public void save(Write write, HttpServletRequest request) {
		File file = FileUploadUtils.upload(request, FileUploadUtils.getDefaultImgLocalUrl(), IdUtils.uuid());
		String url = FileUploadUtils.getDefaultImgUrl(file.getName());// 获得请求路径
		String localPath = file.getAbsolutePath();// 文件的绝对路径
	}

}
