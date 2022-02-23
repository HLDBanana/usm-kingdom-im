package com.powernow.usm.common;

public enum UseStatusEnum {
    /* 使用状态（0：待使用、1：已使用） */
    USED(0,"待使用"),
    UNUSE(1,"已使用");

    private Integer code;

    private String msg;

    UseStatusEnum(Integer code, String msg){
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
