package co.edu.javeriana.aes.pica.catalogue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://catalogue-mariadb:3306/PRODUCT_CATALOGUE");
        // dataSource.setUrl("jdbc:mariadb://localhost:3306/PRODUCT_CATALOGUE");
        dataSource.setUsername("root");
        dataSource.setPassword("my-secret-pw");
        return dataSource;
    }
}
