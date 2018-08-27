package com.hbtzfx.common.util;

import com.hbtzfx.common.ResultEnums;
import com.hbtzfx.common.model.CommonResponse;

/**
 * @Description: 通用返回对象工具类
 * @author NING.LI
 * @date 2017/11/6 13:26
 */
public class ResultUtil {

    public static CommonResponse success(Object object) {
        CommonResponse result = new CommonResponse();
        result.setCode(ResultEnums.SUCCESS.getCode());
        result.setObj(object);
        result.setDesc("success");
        result.setSuccess(true);
        return result;
    }

    public static CommonResponse success() {
        return success(null);
    }

    public static CommonResponse error(long code, String msg) {
        CommonResponse result = new CommonResponse();
        result.setCode(code);
        result.setDesc(msg);
        result.setSuccess(false);
        return result;
    }
}
