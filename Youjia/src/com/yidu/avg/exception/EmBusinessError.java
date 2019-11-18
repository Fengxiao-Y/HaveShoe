package com.yidu.avg.exception;

public enum EmBusinessError implements  CommonError{
	//ͨ�ô�������10000
    PARAMETER_VALIDATION_ERROR(10001, "�������Ϸ�"),
    UNKNOWN_ERROR(10002, "δ֪����"),

    //20000��ͷ��ʾΪ�û���Ϣ��ش�����
    USER_NOT_EXIST(20001, "�û�������"),
    USER_LOGIN_FAIL(20002,"�û��ֻ��Ż��������"),
    USER_EXIST(20003,"�û��Ѿ�����"),
    COMMODITY_NOT_EXIST(30001,"��Ʒ������"),
    SHOOPING_ERRO(30001,"���빺�ﳵʧ��"),
    
    
    SHOPPINGCAR_NULL(30002,"���Ĺ��ﳵΪ���ˣ�ȥ�̳�ѡȡ��Ʒ�ɣ�"),
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