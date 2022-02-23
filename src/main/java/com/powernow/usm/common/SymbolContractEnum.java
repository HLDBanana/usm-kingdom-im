package com.powernow.usm.common;

public enum SymbolContractEnum {

    //缓存数据code编码以及对应数据名称
    Donuts("Donuts","1155"),
    GrimesBoard("Grimes Board","721"),
    Metamon("Metamon","721"),
    MPB("MPB","721"),
    PDiamond("PDiamond","1155"),
    SnoopBoard("Snoop Board","721"),
    U_USM("U-USM","1155"),
    V_CONCERT("V-CONCERT","1155"),
    Potion("Potion","1155"),
    RACAPunk("RACAPunk","721"),
    Egg("Egg","1155");


    private String code;

    private String name;

    SymbolContractEnum(String code, String name){
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
        for (SymbolContractEnum columnNullEnum : SymbolContractEnum.values()) {
            if (columnNullEnum.getName().equals(name)) {
                return columnNullEnum.getCode();
            }
        }
        return null;
    }

    public static String getName(String code) {
        for (SymbolContractEnum columnNullEnum : SymbolContractEnum.values()) {
            if (columnNullEnum.getCode().equals(code)) {
                return columnNullEnum.getName();
            }
        }
        return null;
    }

}
