package com.yidu.avg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yidu.avg.controller.response.CommonReturnType;
import com.yidu.avg.exception.BusinessException;
import com.yidu.avg.exception.EmBusinessError;
@Controller
public class BaseController {
	
	 //定义exceptionHandel解决未被controller层吸收额exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handelException(HttpServletRequest request, Exception ex){
        Map<String, Object> responseData = new HashMap<>();
        if( ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errCode", businessException.getErrCode());
            responseData.put("errMsg", businessException.getErrMsg());
            return CommonReturnType.create(responseData,"fail");
        }else{
            responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
            return CommonReturnType.create(responseData,"fail");
        }

    }

}
