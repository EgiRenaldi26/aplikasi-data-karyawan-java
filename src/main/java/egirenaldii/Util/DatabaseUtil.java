package egirenaldii.Util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class DatabaseUtil {
    
    //data source
    private static HikariDataSource hikariDataSource;

    static {
        //config
        HikariConfig config = new HikariConfig();

        //set config
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("");
        //jdbc:mysql:(ip/hostname):(port)/(database)/(option)
        config.setJdbcUrl("jdbc:mysql://localhost:3306/data_karyawan?serverTimezone=Asia/Jakarta");

        //pool
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(60 * 60 * 1000);

        //set datasoruce
        hikariDataSource = new HikariDataSource(config);

    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }   

}
