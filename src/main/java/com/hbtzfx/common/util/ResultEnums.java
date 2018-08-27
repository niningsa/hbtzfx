package com.hbtzfx.common.util;

import com.hbtzfx.common.model.AppConstants;

/**
 * @Description: 定义返回消息枚举
 * @author NING.LI
 * @date 2017/11/6 13:22
 */
public enum ResultEnums {
    SUCCESS(AppConstants.STATUS_SUCCESS, "成功"),
    UNKNOW_ERROR(AppConstants.SYSTEM_ERROR, "未知错误"),
    ADD_ERROR(AppConstants.SYSTEM_ERROR, "添加失败"),
    SKU_NOT_FOUND(AppConstants.SYSTEM_ERROR, "SKU不存在"),
    PUYER_NOT_FOUND(AppConstants.SYSTEM_ERROR, "采购员不存在"),
    SUPPLY_NOT_FOUND(AppConstants.SYSTEM_ERROR, "该SKU没有供应商"),
    USER_NOT_Login(AppConstants.USER_ERROR_NOLOGIN, AppConstants.USER_ERROR_NOLOGIN_MSG),
    ;
    private long code;
    private String msg;

    ResultEnums(long code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
