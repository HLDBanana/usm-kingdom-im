package com.powernow.usm.common;

public enum CodeTransNameEnum {

    //缓存数据code编码以及对应数据名称
    activeUserNum("activeUserNum","活跃用户"),
    activeUserMonthNum("activeUserMonthNum","活跃用户(按月统计)"),
    fighttingMetamonNum("fighttingMetamonNum","参与战斗元兽"),
    fighttingCount("fighttingCount","战斗次数"),
    racaCost("racaCost","每日RACA消耗"),
    racaDeposit("racaDeposit","充值RACA"),
    fragmentNum("fragmentNum","每日掉落碎片"),

    totalMetamon("totalMetamon","开蛋元兽"),
    nMetamon("nMetamon","开蛋元兽N"),
    rMetamon("rMetamon","开蛋元兽R"),
    srMetamon("srMetamon","开蛋元兽SR"),
    ssrMetamon("ssrMetamon","开蛋元兽SSR"),
    openEgg("openEgg","开蛋数量"),
    mintEgg("mintEgg","合成蛋数量"),

    mpbNum("mpbNum","MPB"),
    racaPunkNum("racaPunkNum","RACAPunk"),
    uUsmNum("uUsmNum","USM"),
    vConcertNum("vConcertNum","Ticket"),
    donuts("donuts","Donuts"),
    snoopBoard("snoopBoard","Snoop Board"),
    grimesBoard("grimesBoard","Grimes Board"),

    potionProduce("potionProduce","开蛋药水"),
    potionCost("potionCost","药水消耗"),
    potionIncrease("potionIncrease","药水增量"),

    yDiamonProduce("yDiamondProduce","开蛋黄钻"),
    yDiamonCost("yDiamonCost","黄钻消耗"),
    yDiamonIncrease("yDiamonIncrease","黄钻增量"),

    pDiamonProduce("pDiamonProduce","开蛋紫钻"),
    pDiamonCost("pDiamonCost","紫钻消耗"),
    pDiamonIncrease("pDiamonIncrease","紫钻增量");



    private String code;

    private String name;

    CodeTransNameEnum(String code, String name){
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
        for (CodeTransNameEnum columnNullEnum : CodeTransNameEnum.values()) {
            if (columnNullEnum.getName().equals(name)) {
                return columnNullEnum.getCode();
            }
        }
        return null;
    }

    public static String getName(String code) {
        for (CodeTransNameEnum columnNullEnum : CodeTransNameEnum.values()) {
            if (columnNullEnum.getCode().equals(code)) {
                return columnNullEnum.getName();
            }
        }
        return null;
    }

}
