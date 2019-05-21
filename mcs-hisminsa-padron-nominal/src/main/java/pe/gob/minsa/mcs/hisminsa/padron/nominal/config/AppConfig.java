package pe.gob.minsa.mcs.hisminsa.padron.nominal.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"pe.gob.minsa.mcs.hisminsa.padron.nominal.*"})
@EnableTransactionManagement
@PropertySources({
    @PropertySource("mcs-hisminsa-padron-nominal.properties"),
    @PropertySource(value = "file:/opt/data/mcs-minsa/properties/mcs-hisminsa-padron-nominal.properties", ignoreResourceNotFound = true)
})
public class AppConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
    	return new DriverManagerDataSource();
    }
    
}
