package com.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * »À¡≥ ˝æ›ø‚≈‰÷√
 * @author wangtingsong
 *
 */
@Configuration
@MapperScan(basePackages = "com.mapper" ,sqlSessionFactoryRef = "dataSourceTest3SqlSessionFactory")
public class DataSourceFaceConfig {
	
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.datasourcetest3")
	@Bean(name = "dataSourceTest3")
	public DataSource dataSourceTest3(){
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name = "dataSourceTest3SqlSessionFactory")
	public SqlSessionFactory dataSourceTest3SqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlBean = new SqlSessionFactoryBean();
		sqlBean.setDataSource(dataSourceTest3());
		return sqlBean.getObject();
	}
	
	@Primary
	@Bean(name ="dataSourceTest3TransactionManager")
	public DataSourceTransactionManager dataSourceTest3TransactionManager(){
		return new DataSourceTransactionManager(dataSourceTest3());
	}
	
	@Primary
	@Bean(name = "dataSouceTest3Template")
	public SqlSessionTemplate dataSouceFaceTemplate() throws Exception{
		return new SqlSessionTemplate(dataSourceTest3SqlSessionFactory());
	}
}
