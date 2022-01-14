package com.core.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * * @Title: DataSourceConfig
 *
 * @author wjq
 * @version 1.0
 * @Package com.inmeijia.config
 * @Description: DataSourceConfig
 * @date 2020-01-09 16:57:07
 */
@Configuration
public class DataSourceConfig {

    //
    //@Value("${datasource.username}")
    //private String username;
    //
    //@Value("${datasource.password}")
    //private String password;
    //
    //@Value("${datasource.url}")
    //private String url;
    //
    //@Value("${datasource.driver-class-name}")
    //private String databaseDriver;
    //
    //@Bean
    //public DataSource dataSource() throws SQLException {
    //
    //    HikariConfig config = new HikariConfig();
    //    config.setJdbcUrl(url);
    //    config.setUsername(username);
    //    config.setPassword(password);
    //    config.setDriverClassName(databaseDriver);
    //
    //    config.addDataSourceProperty("cachePrepStmts", "true");
    //    config.addDataSourceProperty("prepStmtCacheSize", "250");
    //    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    //
    //    return new HikariDataSource(config);
    //}

}
