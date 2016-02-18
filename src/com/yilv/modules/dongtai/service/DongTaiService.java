package com.yilv.modules.dongtai.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.utils.FileUploadUtils;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.service.CDongTaiService;

@Service
@Transactional(readOnly = true)
public class DongTaiService extends CDongTaiService {

	public void save(DongTai dongTai, HttpServletRequest request) {
		List<File> fileList = FileUploadUtils.upload(request, FileUploadUtils.getDefaultImgLocalUrl());
		String url = null, localPath = null;
		if (fileList != null) {
			for (File file : fileList) {
				url = FileUploadUtils.getDefaultImgUrl(file.getName());// 获得请求路径
				localPath = file.getAbsolutePath();// 文件的绝对路径
				// TODO 这里要修改表结构，一张单独的表存放图片信息，表名叫做文件表
			}
		}
	}
}
