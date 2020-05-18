package com.hbtzfx.common.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 */
public class AppConstants {

	public static Map<Long, String> statusMap = new HashMap<Long, String>();
	/**
	 * 系统编码----------------------------------------------------------------
	 */
	public static final long STATUS_SUCCESS = 200;
	public static final String STATUS_SUCCESS_MSG = "成功";
	public static final long SYSTEM_ERROR = 500;
	public static final String SYSTEM_ERROR_MSG = "系统错误,请稍后重试或者联系管理员";
	/**
	 * 数据同步编码 300 = 已无待同步的数据
	 */
	public static final long SYSN_ERROR = 300;
	public static final String SYSN_ERROR_MSG = "已无待同步的数据";

	/**
	 * 用户错误码----------------------------------------------------------------
	 */
	public static final long USER_ERROR_NOT_EXISTS = 101;
	public static final String USER_ERROR_NOT_EXISTS_MSG = "用户名不存在";
	public static final long USER_ERROR_ACCOUNT_PWD = 102;
	public static final String USER_ERROR_ACCOUNT_PWD_MSG = "用户名或密码错误";
	public static final long USER_ERROR_DUPLICATEDACCOUNT = 103;
	public static final String USER_ERROR_DUPLICATEDACCOUNT_MSG = "用户名已存在";
	public static final long USER_ERROR_OLD_PWD = 104;
	public static final String USER_ERROR_OLD_PWD_MSG = "旧密码错误";
	public static final long USER_ERROR_NOPERMISSION = 109;
	public static final String USER_ERROR_NOPERMISSION_MSG = "没有权限";

	public static final long USER_ERROR_NOLOGIN = 601;
	public static final String USER_ERROR_NOLOGIN_MSG = "没有登录";

	static {
		statusMap.put(SYSTEM_ERROR, SYSTEM_ERROR_MSG);
		statusMap.put(STATUS_SUCCESS, STATUS_SUCCESS_MSG);
		statusMap.put(SYSN_ERROR, SYSN_ERROR_MSG);
		statusMap.put(USER_ERROR_NOT_EXISTS, USER_ERROR_NOT_EXISTS_MSG);
		statusMap.put(USER_ERROR_ACCOUNT_PWD, USER_ERROR_ACCOUNT_PWD_MSG);
		statusMap.put(USER_ERROR_DUPLICATEDACCOUNT, USER_ERROR_DUPLICATEDACCOUNT_MSG);
		statusMap.put(USER_ERROR_OLD_PWD, USER_ERROR_OLD_PWD_MSG);
		statusMap.put(USER_ERROR_NOPERMISSION, USER_ERROR_NOPERMISSION_MSG);
	}
}
