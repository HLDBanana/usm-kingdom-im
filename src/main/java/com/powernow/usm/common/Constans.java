package com.powernow.usm.common;


public class Constans {
    public static final int battleWinExp = 5;//挑战成功经验
    public static final int battleLostExp = 3;//挑战失败经验
    public static final int defaultMaxLevel = 60;//最大等级
    public static final int composeMonsterEggFragmentNum = 1000;//合成元兽蛋所需碎片个数
    public static final String attenuation_coe_key = "attenuation_coe";
    public static final int attenuation_coe_battle_num = 200;//衰减场次
    public static final String ADDRESS = "address";
    public static final String ACCESS_TOKEN = "assetsToken";
    public static final String ACCESS_TOKEN_KEY = "assets:token:";
    public static final long ACCESS_TOKEN_EXPIRE = 300;
    public static final int openEggPotionQuantity = 3;//开蛋默认药水数量
    public static final int openEggNftQuantity = 1;//开蛋默认nft数量
    public static final String is_test_key = "is_test";
    public static final String u_raca_rate_key = "u_raca_rate";
//    public static final String battle_fee_1_key = "battle_fee_1";
//    public static final String battle_fee_2_key = "battle_fee_2";
//    public static final String battle_fee_3_key = "battle_fee_3";
    public static final String potion_ratio_key = "potion_ratio";
    public static final String potion_each_num = "potion_each_num";
    public static final String monster_sale_n = "monster_sale_n";//游戏购买元兽价格
    public static final int battleRartityAttackValue = 10;//稀有度增加对战攻击和防御值
    public static final String exp_max = "exp_max";
    public static final double mpbOpenEggValue = 1.5;//拥有母盒用户开蛋R/SR/SSR元兽/RACA Punk增加几率
    public static final double mmlOpenEggValue = 1.1;//拥有mml用户开蛋R/SR/SSR元兽/RACA Punk增加几率
    public static final double bmmOpenEggValue = 1.05;//拥有bmm用户开蛋R/SR/SSR元兽/RACA Punk增加几率
    public static final String open_zero_ratio = "open_zero_ratio";//开蛋为空的概率
    public static final String update_nft_lock_days = "update_nft_lock_days";//升级元兽使用药水、钻石锁定天数

    public static final String LOGIN_USER_INFO = "LOGIN_USER_INFO"; //登录用户信息


    public static final String TB_BACK_RECORD_OTHER = "tb_backpack_record_others"; // 背包交易记录（开蛋开出 游戏外资产）
    public static final String TB_NFT_TOKEN = "tb_nft_token"; // 所有元兽记录

    public static final String RELEASE = "release"; // 预发布环境
    public static final String PROD = "prod"; // 生产环境
    public static final String DEV = "dev"; // 生产环境

    public static final String TRANS_ASSETS = "transAssets"; // 交易资产锁
    /**redis分布式锁 时间*/
    public static final long EXPRIE_TIME=2000;

    public static final String REG_TYPE = "default";


}
