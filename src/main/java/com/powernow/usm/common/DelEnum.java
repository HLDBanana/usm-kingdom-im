package com.powernow.usm.common;

/**
 * @description:
 * @create: 2021/7/20 16:48
 * @update: 2021/7/20 16:48
 */
public enum DelEnum {

    DEL(1,"删除"),
    UNDEL(0,"未删除");

    private Integer code;

    private String msg;

    DelEnum(Integer code, String msg){
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
