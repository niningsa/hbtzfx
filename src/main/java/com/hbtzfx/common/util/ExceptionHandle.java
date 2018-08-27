package com.hbtzfx.common.util;

import com.hbtzfx.common.model.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 异常捕获类
 * @author NING.LI
 * @date 2017/11/6 13:22
 */
@ControllerAdvice
public class ExceptionHandle {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse handle(Exception e) {
        if (e instanceof InstudioException) {
            InstudioException girlException = (InstudioException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("系统异常", e);
            return ResultUtil.error(ResultEnums.UNKNOW_ERROR.getCode(), e.getMessage());
        }
    }
}
