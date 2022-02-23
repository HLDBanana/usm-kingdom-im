package com.powernow.usm.common;

public enum RewardInnerEnum {

    /* 质押结束获得的奖励是否为是否为游戏内资产（1：是、0：否）*/
    GAME_ASSETS(1,"游戏内资产"),
    OTHER_ASSETS(0,"非游戏内资产");

    private Integer code;

    private String msg;

    RewardInnerEnum(Integer code, String msg){
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
