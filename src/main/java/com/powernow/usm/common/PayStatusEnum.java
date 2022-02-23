package com.powernow.usm.common;

public enum PayStatusEnum {

    /* 支付状态（0：待支付、1：已支付、-1：已取消  -2：异常状态（充值金额与实际不符）） */
    UNPAY(0,"待支付"),
    PAY(1,"已支付"),
    CANCE(-1,"已取消"),
    EXCEPTION(-2,"异常状态");

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg){
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
