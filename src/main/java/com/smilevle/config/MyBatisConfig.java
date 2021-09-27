package com.smilevle.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


//@MapperScan(basePackages = {"info.thecodinglive.repository"})
@Configuration
@Import(OracleConnectionConfig.class)
@ComponentScan(basePackages = {"info.thecodinglive.repository"})
public class MyBatisConfig {
	@Autowired
	private OracleConnectionConfig mariaDBConfig;
	// SqlSessionTemplate 빈 객체로 등록함으로써 쓸 쑤 있게한다.
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(mariaDBConfig.dataSource());
		sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver()
				.getResource("classpath:mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath:smilevle/mapper/*.xml"));

		
		return sqlSessionFactoryBean.getObject();
	}
//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedDatabaseBuilder().setName("jpubtestdb").setType(EmbeddedDatabaseType.HSQL)
//				.addScript("schema-hsqldb.sql").addScript("data-hsqldb.sql").build();
//	}
}
