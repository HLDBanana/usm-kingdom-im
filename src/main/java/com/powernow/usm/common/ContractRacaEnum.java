package com.powernow.usm.common;

public enum ContractRacaEnum {

    //缓存数据code编码以及对应数据名称
    BSC("BSC","u-RACA"),
    ETH("ETH","o-RACA");


    private String code;

    private String name;

    ContractRacaEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getCode(String name) {
        for (ContractRacaEnum columnNullEnum : ContractRacaEnum.values()) {
            if (columnNullEnum.getName().equals(name)) {
                return columnNullEnum.getCode();
            }
        }
        return null;
    }

    public static String getName(String code) {
        for (ContractRacaEnum columnNullEnum : ContractRacaEnum.values()) {
            if (columnNullEnum.getCode().equals(code)) {
                return columnNullEnum.getName();
            }
        }
        return null;
    }

}
