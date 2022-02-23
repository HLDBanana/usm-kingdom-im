package com.powernow.usm.common;

public enum FarmStatusEnum {

    UNSTART(1,"未开始"),INPROGRESS(2,"进行中"),FULLFARM(3,"矿池已满"),END(4,"已过期");


    private Integer code;

    private String msg;

    FarmStatusEnum(Integer code, String msg){
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
