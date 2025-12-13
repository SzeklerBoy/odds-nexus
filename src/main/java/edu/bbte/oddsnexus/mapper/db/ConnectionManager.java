package edu.bbte.oddsnexus.mapper.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static HikariDataSource dataSource;

    public static synchronized HikariDataSource getDataSource() {
        if (dataSource == null) {

            Properties props = new Properties();

            try (InputStream is = ConnectionManager.class.getClassLoader().getResourceAsStream("db.properties")) {
                if (is == null) {
                    throw new IllegalStateException("db.properties not found in classpath");
                }

                props.load(is);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load db.properties", e);
            }

            HikariConfig config = new HikariConfig();

            config.setDriverClassName(props.getProperty("JDBC_DRIVER"));
            config.setJdbcUrl(props.getProperty("JDBC_URL"));
            config.setUsername(props.getProperty("DB_USER"));
            config.setPassword(props.getProperty("DB_PASSWORD"));
            config.setMaximumPoolSize(Integer.parseInt(props.getProperty("POOL_SIZE")));
            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
