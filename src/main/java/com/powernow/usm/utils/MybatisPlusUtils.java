package com.powernow.usm.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @description: 数据库生成JAVA类
 */
public class MybatisPlusUtils {
    /**
     * mysql自动代码生成类
     *
     * @param includeTables
     * @param excludeTables
     */
    public static void generateMysql(String[] includeTables, String[] excludeTables, Boolean db1) {
        AutoGenerator autoGenerator = new AutoGenerator();
        /**
         * 数据库配置
         */
        buildMysqlDb(autoGenerator);
        StrategyConfig strategyConfig = new StrategyConfig();
        // 驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(includeTables);
        //strategyConfig.setExclude(excludeTables);
        strategyConfig.setTablePrefix("");
        autoGenerator.setStrategy(strategyConfig);
        /**
         * 全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("xxj");
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setActiveRecord(true);
        globalConfig.setIdType(IdType.INPUT);
        globalConfig.setOutputDir("D:/ORM");  //文件生成路径
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setSwagger2(true);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseColumnList(false);
        globalConfig.setBaseResultMap(false);
        globalConfig.setEnableCache(false);
        autoGenerator.setGlobalConfig(globalConfig);

        /**
         * 包名配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("");
        packageConfig.setEntity("com.powernow.usm.entity");
        packageConfig.setMapper("com.powernow.usm.dao");
        packageConfig.setXml("mapper");
        packageConfig.setService("com.powernow.usm.service");
        packageConfig.setServiceImpl("com.powernow.usm.service.impl");
        packageConfig.setController("com.powernow.usm.controller");

        autoGenerator.setPackageInfo(packageConfig);
        // 采用默认模板,自定义模板参考@see com.baomidou.mybatisplus.generator.config.TemplateConfig
//        TemplateConfig templateConfig = new TemplateConfig();
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

    /**
     * oracle自动代码生成类
     * @param includeTables
     * @param excludeTables
     */
    public static void generateOracle(String[] includeTables, String[] excludeTables, Boolean db1) {
        AutoGenerator autoGenerator = new AutoGenerator();
        buildOracleDb(autoGenerator);
        StrategyConfig strategyConfig = new StrategyConfig();
        // 驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(includeTables);
        strategyConfig.setExclude(excludeTables);
        strategyConfig.setTablePrefix("");
        autoGenerator.setStrategy(strategyConfig);
        /**
         * 全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("");
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setActiveRecord(true);
        globalConfig.setIdType(IdType.AUTO);    //这里用oracle的序列和触发器实现主键自增
        //D:\ORM  C:/D/ORM
        globalConfig.setOutputDir("D:/ORM");  //文件生成路径
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setSwagger2(true);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseColumnList(false);
        globalConfig.setBaseResultMap(false);
        globalConfig.setEnableCache(false);
        autoGenerator.setGlobalConfig(globalConfig);
        /**
         * 包名配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("");
        packageConfig.setEntity("com.powernow.usm.entity");
        packageConfig.setMapper("com.powernow.usm.dao");
        packageConfig.setXml("mapper");
        packageConfig.setService("com.powernow.usm.service");
        packageConfig.setServiceImpl("com.powernow.usm.service.impl");
        packageConfig.setController("com.powernow.usm.controller");

        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

    private static void buildOracleDb(AutoGenerator autoGenerator) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbQuery(new MyDbQuery());   //自定义dbquery不然querydb.dbtype找不到
        dataSourceConfig.setDbType(DbType.ORACLE);
        dataSourceConfig.setDriverName("oracle.jdbc.driver.OracleDriver");
        dataSourceConfig.setUsername("multiplecheck");
        dataSourceConfig.setPassword("multiplecheck");
        dataSourceConfig.setUrl("jdbc:oracle:thin:@192.168.100.133/orcl");
        autoGenerator.setDataSource(dataSourceConfig);
    }

    private static void buildMysqlDb(AutoGenerator autoGenerator) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("15090667928Hh_");
        dataSourceConfig.setUrl("jdbc:mysql://182.92.219.202:3306/hldIM?useUnicode=true");
//        dataSourceConfig.setUrl("jdbc:mysql://nftm-dev-recover.cqqgcco1q2hb.us-east-2.rds.amazonaws.com:13206/usm?useUnicode=true");
        autoGenerator.setDataSource(dataSourceConfig);
    }

    public static void main(String[] args) {

//        String[] includeTables = {"contract_event","contract_listener","event_harvest_eggs","event_sync_block_infos","nft_dueout","otc_sale_nft_buy_record"
//                ,"tb_activity","tb_activity_letter","tb_activity_letter_owner_quantity","tb_activity_letter_owner_record","tb_activity_letter_owner_record_detail","tb_activity_letter_ratio","tb_backpack","tb_backpack_others"
//                ,"tb_backpack_record","tb_backpack_record_fragment","tb_backpack_record_lock","tb_backpack_record_others","tb_backpack_record_raca","tb_block_again","tb_challenge","tb_challenge_config"
//                ,"tb_challenge_fee","tb_challenge_record","tb_login_info","tb_monster","tb_monster_record","tb_monster_upgrade","tb_monster_upper","tb_nft_owner"
//        ,"tb_nft_quantity_open","tb_nft_token","tb_nft_token_open","tb_nft_token_recharge","tb_nft_token_sale","tb_notify","tb_notify_read","tb_pay_order","tb_setting"
//        ,"tb_shop_order","tb_test_user","tb_transaction_single","worker_node","tb_farm_config","tb_farm_order"};

        String[] includeTables = {"tb_login_full_info"};
        generateMysql(includeTables,null,false);  //mysql映射文件生成
        //generateOracle(includeTables,null,false);      //oracle映射文件生成
    }
}
