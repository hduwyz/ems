package com.xx.ems;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenerateCodeBuilder {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    //作者
    private String author = "wangyz";

    //输出路径(设定为项目文件目录，二次生成会覆盖目标文件)
    private String outputdir = "D:/generator/";

    //包名称
    private String packageName = "com.xx.ems";

    @Test
    public void generateCodeBuilder() {
        boolean serviceNameStartWithI = true;
        generateByTables(serviceNameStartWithI, packageName, "department","period","registration","user","work_content", "manager", "permission", "permission_api", "role");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(this.url)
                .setUsername(this.username)
                .setPassword(this.password)
                .setDriverName(this.driver);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(false)
//                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);

        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setEnableCache(false)
                .setAuthor(author)
                .setOutputDir(outputdir)
                .setFileOverride(true)
                .setDateType(DateType.ONLY_DATE);

        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName)
                .setController("controller")
                .setEntity("entity");

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .execute();
    }

}

