package com.bosssoft.mytask.entity;

public class jsonResult {
    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;
    public static jsonResult ok(Object data) {
        return new jsonResult(data);
    }
    //类含参初始化1
    public jsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    //类含参初始化2
    public jsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    //get和set方法
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
