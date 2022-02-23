package com.powernow.usm.common;

public enum PayTypeWithDrawEnum {

    //提现：  <!-- dealType:0 提现元兽 2：药水 3：黄钻 4：紫钻 6：元兽蛋-->
    WITHDRAW_METAMON(0,-6),
    WITHDRAW_Potion(2,-2),
    WITHDRAW_YellowDiamond(3,-3),
    WITHDRAW_PurpleDiamond(4,-4),
    WITHDRAW_MetamonEgg(6,-5);

    private Integer bpType;

    private Integer payType;

    PayTypeWithDrawEnum(Integer bpType, Integer payType){
        this.bpType = bpType;
        this.payType = payType;
    }

    public Integer getBpType() {
        return bpType;
    }

    public Integer getPayType() {
        return payType;
    }

    public static Integer getPayType(Integer bpType) {
        for (PayTypeWithDrawEnum columnNullEnum : PayTypeWithDrawEnum.values()) {
            if (columnNullEnum.getBpType().intValue() == bpType.intValue()) {
                return columnNullEnum.getPayType();
            }
        }
        return null;
    }

    public static Integer getBpType(Integer payType) {
        for (PayTypeWithDrawEnum columnNullEnum : PayTypeWithDrawEnum.values()) {
            if (columnNullEnum.getPayType().intValue() == payType.intValue()) {
                return columnNullEnum.getBpType();
            }
        }
        return null;
    }

}
