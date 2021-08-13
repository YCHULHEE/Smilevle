package kr.co.smilevle.jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInitListener implements ServletContextListener {
	
	
	public void contextInitialized(ServletContextEvent sce) {
		String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
		System.out.println("풀컨피그:" + poolConfig);
		Properties prop = new Properties();
		try {
			prop.load(new StringReader(poolConfig));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		loadJDBCDriver(prop);
		initConnetionPool(prop);

	}

	private void loadJDBCDriver(Properties prop) {
		String driverClass = prop.getProperty("jdbcDriver");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnetionPool(Properties prop) {
		try {
			String jdbcUrl = prop.getProperty("jdbcUrl");
			String userName = prop.getProperty("dbUser");
			String pw = prop.getProperty("dbPass");
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, userName, pw);
			
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			String validationQuery = prop.getProperty("validationQuery");
			if (validationQuery != null && !validationQuery.isEmpty()) {
				// 쿼리테스트 쿼리가 유효한지?? 커넥션이 유용한지 검사하는 메서드.
				poolableConnFactory.setValidationQuery(validationQuery);
			}
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

			

			// 커넥션 검사 주기 설정.
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			// 커넥션이 유효한지 검사.
			poolConfig.setTestWhileIdle(true);
			// 기본 커넥션 갯수.
			int minIdle = getIntProperty(prop, "minIdle", 5);
			poolConfig.setMinIdle(minIdle);
			// 최대 커넥션 갯수.
			int maxTotal = getIntProperty(prop, "maxTotal", 50);
			poolConfig.setMaxTotal(maxTotal);

			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,
					poolConfig);
			// 위 객체를 가지고 풀 설정.
			poolableConnFactory.setPool(connectionPool);

			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			// registerPool(풀이름, 설정)
			String poolName = prop.getProperty("poolName");

			driver.registerPool(poolName, connectionPool);
			System.out.println("풀링 드라이버 동작");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	// 데이터베이스 파싱할 때 써먹자.
	private int getIntProperty(Properties prop, String propName, int defautValue) {
		String value = prop.getProperty(propName);
		if(value == null) return defautValue;
		return Integer.parseInt(value);
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
