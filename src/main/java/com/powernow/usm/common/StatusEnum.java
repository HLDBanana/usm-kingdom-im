package com.powernow.usm.common;

/**
 * @description:
 * @create: 2021/7/20 16:48
 * @update: 2021/7/20 16:48
 */
public enum StatusEnum {

    ENABLE(1,"启用"),
    DISABLE(0,"弃用");

    private Integer code;

    private String msg;

    StatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
