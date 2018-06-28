package com.yinhai.yunwei.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
/**
 * @author 范超
 * @version V1.0
 * @Title DataBaseConfiguration
 * @Package com.yinhai.yunwei.datasource
 * @Descript :TODO()
 * @date : 2018/6/22  上午9:56
 */
@Configuration
public class DataBaseConfiguration {
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    @Bean(name="hbzgh")
    @Primary
    @ConfigurationProperties(prefix = "hbzgh")
    public DataSource hbzghDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
    /**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "datacenter")
    @ConfigurationProperties(prefix = "datacenter")
    public DataSource centerDataSourceOne(){
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "yunwei")
    @ConfigurationProperties(prefix = "yunwei")
    public DataSource yunweiDataSource(){
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "zhmysql")
    @ConfigurationProperties(prefix = "zhmysql")
    public DataSource zhDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
}
