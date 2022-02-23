package com.powernow.usm.common;

public enum NftTokenStatusEnum {

    NORMAL(0,"正常"),
    FROZEN(1,"冻结"),
    SENDED(2,"发放成功"),
    STAKELOCK(-1,"质押锁死"),
    STAKEUNLOCK(-2,"质押未锁死");

    private Integer code;

    private String msg;

    NftTokenStatusEnum(Integer code, String msg){
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
