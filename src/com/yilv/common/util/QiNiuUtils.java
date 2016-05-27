package com.yilv.common.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.yilv.common.conf.Global;

/**
 * @author Administrator
 * 
 */
public class QiNiuUtils {
	private static final String ACCESS_KEY = Global
			.getConfig("qiniu.access_key");
	private static final String SECRET_KEY = Global
			.getConfig("qiniu.secret_key");
	private static final String BUCKET = "itravel";

	private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	private static UploadManager uploadManager = new UploadManager();
	private static BucketManager bucketManager = new BucketManager(auth);

	private static Logger logger = LoggerFactory.getLogger(QiNiuUtils.class);

	/**
	 * 上传文件
	 * 
	 * @param bs
	 * @param fileName
	 *            文件名称,例如:img/2013/123.png
	 * @return
	 */
	public static boolean put(byte[] bs, String fileName) {
		boolean flag = true;
		try {
			Response res = uploadManager.put(bs, fileName, getUpToken());
			logger.info(res.bodyString());
			logger.info("七牛上传文件" + fileName + "成功");
		} catch (QiniuException e) {
			flag = false;
			try {
				logger.info(e.response.bodyString());
				logger.info("七牛上传文件" + fileName + "失败");
			} catch (QiniuException e1) {
			}
		}
		return flag;
	}

	/**
	 * 上传
	 * 
	 * @param file
	 * @return
	 */
	public static boolean put(File file, String fileName) {
		boolean flag = true;
		try {
			Response res = uploadManager.put(file, fileName, getUpToken());
			logger.info(res.bodyString());
			logger.info("七牛上传文件" + fileName + "成功");
		} catch (QiniuException e) {
			flag = false;
			try {
				logger.info(e.response.bodyString());
				logger.info("七牛上传文件" + fileName + "失败");
			} catch (QiniuException e1) {
			}
		}
		return flag;
	}

	/**
	 * 删除
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean del(String fileName) {
		boolean flag = true;
		try {
			bucketManager.delete(BUCKET, fileName);
			logger.info("七牛删除文件" + fileName + "成功");
		} catch (QiniuException e) {
			flag = false;
			try {
				logger.info(e.response.bodyString());
				logger.info("七牛删除文件" + fileName + "失败");
			} catch (QiniuException e1) {
			}
		}
		return flag;
	}

	private static String getUpToken() {
		return auth
				.uploadToken(
						BUCKET,
						null,
						3600,
						new StringMap()
								.putNotEmpty(
										"returnBody",
										"{\"key\": $(key), \"hash\": $(etag), \"width\": $(imageInfo.width), \"height\": $(imageInfo.height)}"));
	}

	/**
	 * 要求请求的路径是：http://m.static.cgotravel.com/img/20160105/E4D5633DE.png
	 * 
	 * @param url
	 * @return 例如：img/20160105/E4D5633DE7BC4CE19C114679E620EB79.png
	 */
	public static String getFileName(String url) {
		String[] content = url.split("/");
		StringBuilder builder = new StringBuilder();
		builder.append(content[3]);
		builder.append("/");
		builder.append(content[4]);
		builder.append("/");
		builder.append(content[5]);
		return builder.toString();
	}

}
