package com.powernow.usm.common;

public enum DealTypeEnum {

    /* 记录类型    1：对战    2：升级    3：充值    4：提取    6：合成   7:开蛋  8：游戏内购买nft  9：游戏出售nft  10：锁仓 */
    FIGHT(1,"对战"),
    LEVELUP(2,"升级"),
    DEPOIST(3,"充值"),
    WITHDRAW(4,"提取"),
    MINT(6,"合成"),
    OPENEGG(7,"开蛋"),
    GAME_BUY_NFT(8,"游戏内购买nft"),
    GAME_SALE_NFT(9,"游戏出售nft"),
    LOCK(10,"锁仓"),
    FARM(11,"质押"),
    TRANS_ASSETS(12,"资产转移"),
    EXP_ADD(13,"增加经验"),
    ATTR_UPPER(14,"属性增强"),;

    private Integer code;

    private String msg;

    DealTypeEnum(Integer code, String msg){
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
