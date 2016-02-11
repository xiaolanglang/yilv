package com.yilv.common.conf;

import java.util.Map;

import com.ckfinder.connector.ServletContextFactory;
import com.google.common.collect.Maps;
import com.yilv.base.common.utils.PropertiesLoader;

/**
 * 全局配置类
 * 
 * @author ThinkGem
 * @version 2014-06-25
 */
public class Global extends com.yilv.base.common.conf.Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();

	public static final String PROPERTIES_PATH = "classpath:config/privates/message.properties";

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader(PROPERTIES_PATH);

	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}

	/**
	 * 获取配置
	 * 
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = propertiesLoader.getProperty(key);
			map.put(key, value != null ? value : "");
		}
		return value;
	}

	/**
	 * 获取管理端根路径
	 */
	public static String getPath() {
		return getConfig("travelPath");
	}

	// ///////////////////////////////////////////////////////

	/**
	 * 获取分页大小
	 */
	public static int getPageSize() {
		return Integer.parseInt(getConfig("page.pageSize"));
	}

	/**
	 * 获取管理端根路径
	 */
	public static String getTravelPath() {
		return getConfig("travelPath");
	}

	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}

	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}

	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
	 */
	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		return "true".equals(dm) || "1".equals(dm);
	}

	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}

	// ///////////////////////////////////////////////////////

	// 显示/隐藏
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	// 是/否
	public static final String YES = "1";
	public static final String NO = "0";

	// 对/错
	public static final String TRUE = "true";
	public static final String FALSE = "false";

	public static final String USERFILES_BASE_URL = "/userfiles/";

	/**
	 * 页面获取常量
	 * 
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

	// 获取字典字节空间值
	public static int getDictSize() {
		return Integer.parseInt(getConfig("dictSize"));
	}

	/**
	 * 获取纯真数据库根目录
	 * 
	 * @return
	 * @author SA
	 */
	public static String getVisitBaseDir() {
		String dir = getConfig("qqwryPath");
		try {
			dir = ServletContextFactory.getServletContext().getRealPath("/") + dir;
		} catch (Exception e) {
			return "";
		}
		if (!dir.endsWith("/")) {
			dir += "/";
		}
		System.out.println("qqwryPath:" + dir);
		return dir;
	}
}
