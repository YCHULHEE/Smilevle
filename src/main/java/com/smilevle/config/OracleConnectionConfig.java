package com.smilevle.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
// application.properties 파일 참조를 위해서 PropertySource 어노테이션을 사용한다.
@PropertySource("application.properties")
public class OracleConnectionConfig implements TransactionManagementConfigurer{
    // @Value를 통해 각 설정 정보를 매핑하여 가져온다.
	@Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Value("${spring.datasource.classname}")
    private String dbClassName;
    
    
    // @Lazy는 빈 생성 시점을 늦춰 주는 어노테이션. 우선 순위가 뒤로 밀리게 됨.
    @Lazy
    // 데이터베이스 접속 종료 시에 커넥션 인스턴스도 함께 초기화되도록 Bean
    // 어노테이션에 close를 함께 써준다.
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(dbUsername);
        hikariConfig.setPassword(dbPassword);

        hikariConfig.addDataSourceProperty("url", dbUrl);
        hikariConfig.setDataSourceClassName(dbClassName);
        hikariConfig.setLeakDetectionThreshold(2000);
        hikariConfig.setPoolName("jpubDBpool");
        // 추후의 변경을 막기 위해서 final로 선언.
        final HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }
}