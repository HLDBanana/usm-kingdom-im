package com.powernow.usm.common;

public enum WalletAssetsEnum {

    Metamon("Metamon","元兽"),
    MetamonEgg("Metamon Egg","元兽蛋"),
    Potion("Potion","药水"),
    YellowDiamond("Yellow Diamond","黄钻"),
    PurpleDiamond("Purple Diamond","紫钻");

    private String code;

    private String msg;

    WalletAssetsEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
