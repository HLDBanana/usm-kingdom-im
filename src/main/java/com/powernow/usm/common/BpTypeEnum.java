package com.powernow.usm.common;

public enum BpTypeEnum {

    /*背包类型（1：碎片、2：药水、3：黄钻、4：紫钻、5：UU(游戏内拥有RACA数量)、6：元兽蛋） */

    MetamonFragment(1,"Fragment"),
    Potion(2,"Potion"),
    YellowDiamond(3,"YDiamond"),
    PurpleDiamond(4,"PDiamond"),
    URACA(5,"UU"),
    MetamonEgg(6,"Egg");

    private Integer code;

    private String msg;

    BpTypeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static Integer getByMsg(String msg) {
        BpTypeEnum[] values = BpTypeEnum.values();
        for (BpTypeEnum recordType : values) {
            if(recordType.msg.equals(msg)){
                return recordType.code;
            }
        }
        return null;
    }
}
