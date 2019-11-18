package com.yidu.avg.enums;

public enum ResultEmum {
    SUCCESS(0,"成功"),
    USER_NOT_NULL(1,"用户为空"),
    USER_EXIST(2,"用户已经存在,请重新输入用户名"),
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
