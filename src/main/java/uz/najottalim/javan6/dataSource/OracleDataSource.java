package uz.najottalim.javan6.dataSource;

import lombok.Data;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Data
@Configuration
public class OracleDataSource {
    @Bean
    DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
        dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1521:xe");
        dataSourceBuilder.username("C##BOBUR");
        dataSourceBuilder.password("root");
        DataSource build = dataSourceBuilder.build();
        return build;
    }
}
