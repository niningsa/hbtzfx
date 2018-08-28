package com.hbtzfx.common.util;

/**
 * @Description: 自定义异常 ，继承runtimeException 利于事务回滚
 * @author NING.LI
 * @date 2017/11/6 13:23
 */
public class InstudioException extends RuntimeException {
    private long code;

    public InstudioException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

}
