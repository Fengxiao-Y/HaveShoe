package com.yidu.avg.controller.response;

public class CommonReturnType {
	 //杩斿洖success鎴杅ail
    private String status;

    //success:杩斿洖鍓嶇闇�瑕佺殑鏁版嵁
    //fail:杩斿洖鑷畾涔夌殑閿欒鐮�
    private Object data;

    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data)  {
        this.data = data;
    }
}
