package com.powernow.usm.common;

public enum DealStatusEnum {

    /* 交易状态（1：完成、0：待确认、-1：退回） */
    COMPLETE(1,"完成"),
    UNCONFIRM(0,"待确认"),
    CANCE(-1,"退回");

    private Integer code;

    private String msg;

    DealStatusEnum(Integer code, String msg){
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
