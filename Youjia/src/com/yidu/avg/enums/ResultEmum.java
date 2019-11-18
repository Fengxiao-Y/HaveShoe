package com.yidu.avg.enums;

public enum ResultEmum {
    SUCCESS(0,"�ɹ�"),
    USER_NOT_NULL(1,"�û�Ϊ��"),
    USER_EXIST(2,"�û��Ѿ�����,�����������û���"),
    ;
	
	private Integer code;
	
	private String message;
	
	private ResultEmum(Integer code,String messages) {
		this.code=code;
		this.message=messages;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
