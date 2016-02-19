package com.yilv.modules.dongtai.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.exception.ServiceException;
import com.yilv.base.common.utils.FileUploadUtils;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.service.CDongTaiService;
import com.yilv.base.modules.file.eitity.YFile;
import com.yilv.modules.file.service.YFileService;

@Service
@Transactional(readOnly = true)
public class DongTaiService extends CDongTaiService {

	@Autowired
	private YFileService fileService;

	@Transactional(readOnly = false)
	public void save(DongTai dongTai, HttpServletRequest request) {

		save(dongTai);

		List<File> fileList = null;
		try {
			fileList = FileUploadUtils.upload(request, FileUploadUtils.getDefaultImgLocalUrl());
		} catch (Exception e) {
			throw new ServiceException("文件上传失败");
		}
		if (fileList != null) {
			String entityId = dongTai.getId();
			for (File file : fileList) {
				String url = null, localPath = null;
				url = FileUploadUtils.getDefaultImgUrl(file.getName());// 获得请求路径
				localPath = file.getAbsolutePath();// 文件的绝对路径

				YFile yFile = new YFile();
				yFile.setName(file.getName());
				yFile.setUrl(url);
				yFile.setLocalpath(localPath);
				yFile.setSize((double) file.length());
				yFile.setEntityId(entityId);

				fileService.save(yFile);
			}
		}

	}
}
