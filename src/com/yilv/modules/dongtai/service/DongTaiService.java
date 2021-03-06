package com.yilv.modules.dongtai.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.exception.ServiceException;
import com.yilv.base.common.utils.DictDataUtil;
import com.yilv.base.common.utils.FileUploadUtils;
import com.yilv.base.common.utils.page.mbatis.MPage;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.response.DongtaiMsg;
import com.yilv.base.modules.dongtai.service.CDongTaiService;
import com.yilv.base.modules.file.eitity.YFile;
import com.yilv.base.modules.file.response.YFileMin;
import com.yilv.common.util.QiNiuUtils;
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
			fileList = FileUploadUtils.upload(request,
					FileUploadUtils.getDefaultImgLocalUrl());
			if (fileList != null && fileList.size() > 0) {
				for (File file : fileList) {
					String url = FileUploadUtils.getDefaultImgUrl(file
							.getName());
					boolean f = QiNiuUtils.put(file,
							QiNiuUtils.getFileName(url));
					if (!f) {
						throw new ServiceException("文件上传失败");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("文件上传失败");
		}
		if (fileList != null && fileList.size() > 0) {
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
				yFile.setType(DictDataUtil.FILE_TYPE_DONGTAI);

				fileService.save(yFile);
			}
		}

	}

	public void findMsgPageList(MPage<DongtaiMsg> page) {
		List<DongtaiMsg> list = mDao.findMsgPageList(page);
		if (list == null || list.size() == 0) {
			return;
		}
		List<String> ids = new ArrayList<String>();
		for (DongtaiMsg dongtai : list) {
			ids.add(dongtai.getId());
		}
		List<YFileMin> files = fileService.findFilesByEntityIds(ids);
		for (DongtaiMsg dongtai : list) {
			String entityId = dongtai.getId();
			List<String> imageUrls = new ArrayList<String>(9);
			for (YFileMin fileMin : files) {
				if (entityId.equals(fileMin.getEntityId())) {
					imageUrls.add(fileMin.getUrl());
				}
			}
			dongtai.setImageUrls(imageUrls);
		}
		page.setList(list);
	}

}
