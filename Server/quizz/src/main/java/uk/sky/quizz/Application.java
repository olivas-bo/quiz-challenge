package uk.sky.quizz;


import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class Application {
	@Value("${vcap.services.voucher-db.credentials.hostname}")
	private String dbHostname;

	@Value("${vcap.services.voucher-db.credentials.port}")
	private int dbPort;

	@Value("${vcap.services.voucher-db.credentials.username}")
	private String dbUsername;

	@Value("${vcap.services.voucher-db.credentials.password}")
	private String dbPassword;


	private String dbOptions = "zeroDateTimeBehavior=convertToNull&useServerPrepStmts=false&rewriteBatchedStatements=true";

	@Value("${vcap.services.voucher-db.credentials.name}")
	private String dbName;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setPoolProperties(poolProperties());
		ds.setInitialSize(2);
		ds.setMinIdle(2);
		ds.setMaxIdle(20);
		ds.setMaxActive(20);
		ds.setRemoveAbandoned(true);
		ds.setRemoveAbandonedTimeout(120);
		ds.setAbandonWhenPercentageFull(0);
		ds.setJdbcInterceptors(
			"org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
				"org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;" +
				"org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReport(threshold=5000);" +
				"org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");

		// runs before flyway - default encoding and collation is utf8 (case insensitive)
		Connection connection = ds.getConnection();
		Statement statement = connection.createStatement();
		statement.execute(String.format("ALTER DATABASE %s CHARACTER SET utf8 COLLATE utf8_unicode_ci", dbName));
		statement.close();
		connection.close();

		return ds;
	}

	@Bean
	public PoolConfiguration poolProperties() {
		PoolConfiguration pp = new PoolProperties();
		pp.setDriverClassName("com.mysql.jdbc.Driver");
		pp.setUrl(String.format("jdbc:mysql://%s:%s/%s?%s", dbHostname, dbPort, dbName, dbOptions));
		pp.setUsername(dbUsername);
		pp.setPassword(dbPassword);
		pp.setValidationQuery("select 1 from dual");
		pp.setTestOnReturn(false);
		pp.setTestOnBorrow(true);
		pp.setTestWhileIdle(false);
		pp.setLogAbandoned(true);
		return pp;
	}
}
