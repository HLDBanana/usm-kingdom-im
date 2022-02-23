package com.powernow.usm.common;


public enum AnalysisTypeEnum {

    SEVEN_DAYS(0,"最近七天"),
    MORE(1,"数据开始日期");

    private Integer code;

    private String msg;

    AnalysisTypeEnum(Integer code, String msg){
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
