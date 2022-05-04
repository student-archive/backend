package ru.zgz.star.backend.util;

import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;

public class EbeanConfigurator {
  public static DatabaseConfig getConfig() {
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig
        .setUsername(System.getenv("DATABASE_USER"))
        .setPassword(System.getenv("DATABASE_PASSWORD"))
        .setUrl(System.getenv("DATABASE_URL"))
        .setDriver("org.postgresql.Driver");

    DatabaseConfig config = new DatabaseConfig();
    config.setDataSourceConfig(dataSourceConfig);

    return config;
  }
}
