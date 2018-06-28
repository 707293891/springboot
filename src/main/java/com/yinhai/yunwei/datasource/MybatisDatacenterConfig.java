package com.yinhai.yunwei.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 范超
 * @version V1.0
 * @Title MybatisDbAConfig
 * @Package com.yinhai.yunwei.datasource
 * @Descript :TODO()
 * @date : 2018/6/22  上午10:26
 */
@Configuration
@MapperScan(basePackages = {"com.yinhai.yunwei.center.mapper"}, sqlSessionFactoryRef = "sqlSessionFactoryCenter")
public class MybatisDatacenterConfig {
    @Autowired
    @Qualifier("datacenter")
    private DataSource datacenter;


    @Bean
    public SqlSessionFactory sqlSessionFactoryCenter() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datacenter); // 使用titan数据源, 连接titan库

        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryCenter()); // 使用上面配置的Factory
        return template;
    }
}
