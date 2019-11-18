package com.yidu.avg.exception;

public enum EmBusinessError implements  CommonError{
	//通用错误类型10000
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    UNKNOWN_ERROR(10002, "未知错误"),

    //20000开头表示为用户信息相关错误定义
    USER_NOT_EXIST(20001, "用户不存在"),
    USER_LOGIN_FAIL(20002,"用户手机号或密码错误"),
    USER_EXIST(20003,"用户已经存在"),
    COMMODITY_NOT_EXIST(30001,"商品不存在"),
    SHOOPING_ERRO(30001,"加入购物车失败"),
    
    
    SHOPPINGCAR_NULL(30002,"您的购物车为空了，去商城选取商品吧！"),
    ;

    private int errCode;
    private String errMsg;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}