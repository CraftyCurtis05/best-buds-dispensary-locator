package com.dao;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Objects;

@Configuration
public class TestingDatabaseConfig {

    // Test database settings
    private static final String DB_HOST =
            Objects.requireNonNullElse(System.getenv("TEST_DB_HOST"), "localhost");

    private static final String DB_PORT =
            Objects.requireNonNullElse(System.getenv("TEST_DB_PORT"), "5432");

    private static final String DB_NAME =
            Objects.requireNonNullElse(System.getenv("TEST_DB_NAME"), "best_buds_test");

    private static final String ADMIN_USERNAME =
            Objects.requireNonNullElse(System.getenv("TEST_DB_ADMIN_USERNAME"), "postgres");

    private static final String ADMIN_PASSWORD =
            Objects.requireNonNull(System.getenv("TEST_DB_ADMIN_PASSWORD"),
                    "TEST_DB_ADMIN_PASSWORD must be set before running database tests.");

    private SingleConnectionDataSource adminDataSource;
    private JdbcTemplate adminJdbcTemplate;
    private SingleConnectionDataSource testDataSource;

    // Create a clean database before the tests run
    @PostConstruct
    public void setup() {

        adminDataSource = new SingleConnectionDataSource();
        adminDataSource.setUrl(
                String.format("jdbc:postgresql://%s:%s/postgres", DB_HOST, DB_PORT)
        );
        adminDataSource.setUsername(ADMIN_USERNAME);
        adminDataSource.setPassword(ADMIN_PASSWORD);

        adminJdbcTemplate = new JdbcTemplate(adminDataSource);

        adminJdbcTemplate.execute(
                "DROP DATABASE IF EXISTS \"" + DB_NAME + "\" WITH (FORCE)"
        );

        adminJdbcTemplate.execute(
                "CREATE DATABASE \"" + DB_NAME + "\""
        );
    }

    // Create the connection used by the DAO tests
    @Bean
    public DataSource dataSource() throws SQLException {

        testDataSource = new SingleConnectionDataSource();
        testDataSource.setUrl(
                String.format(
                        "jdbc:postgresql://%s:%s/%s",
                        DB_HOST,
                        DB_PORT,
                        DB_NAME
                )
        );
        testDataSource.setUsername(ADMIN_USERNAME);
        testDataSource.setPassword(ADMIN_PASSWORD);
        testDataSource.setAutoCommit(false);

        ScriptUtils.executeSqlScript(
                testDataSource.getConnection(),
                new FileSystemResource("database/schema.sql")
        );

        ScriptUtils.executeSqlScript(
                testDataSource.getConnection(),
                new ClassPathResource("test-data.sql")
        );

        return testDataSource;
    }

    // Remove the temporary database after the tests finish
    @PreDestroy
    public void cleanup() {

        if (testDataSource != null) {
            testDataSource.destroy();
        }

        if (adminJdbcTemplate != null) {
            adminJdbcTemplate.execute(
                    "DROP DATABASE IF EXISTS \"" + DB_NAME + "\" WITH (FORCE)"
            );
        }

        if (adminDataSource != null) {
            adminDataSource.destroy();
        }
    }
}
