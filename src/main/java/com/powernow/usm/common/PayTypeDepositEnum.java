package com.powernow.usm.common;

public enum PayTypeDepositEnum {

    // 充值: <!-- bpType:0 充值元兽 2：药水 3：黄钻 4：紫钻 5：UU 6：元兽蛋-->
    Deposit_METAMON(0,6),
    Deposit_Potion(2,2),
    Deposit_YellowDiamond(3,3),
    Deposit_PurpleDiamond(4,4),
    Deposit_URACA(5,1),
    Deposit_MetamonEgg(6,5);

    private Integer bpType;

    private Integer payType;

    PayTypeDepositEnum(Integer bpType, Integer payType){
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
        for (PayTypeDepositEnum columnNullEnum : PayTypeDepositEnum.values()) {
            if (columnNullEnum.getBpType().intValue() == bpType.intValue()) {
                return columnNullEnum.getPayType();
            }
        }
        return null;
    }

    public static Integer getBpType(Integer payType) {
        for (PayTypeDepositEnum columnNullEnum : PayTypeDepositEnum.values()) {
            if (columnNullEnum.getPayType().intValue() == payType.intValue()) {
                return columnNullEnum.getBpType();
            }
        }
        return null;
    }

}
