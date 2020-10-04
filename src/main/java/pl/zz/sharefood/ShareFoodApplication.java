package pl.zz.sharefood;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ShareFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareFoodApplication.class, args);
    }

    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    @Value("${spring.datasource.username}")
    private String datasourceUser;
    @Value("${spring.datasource.password}")
    private String datasourcePass;

    @Bean
    public CommandLineRunner extraStartUpRunner() {
        return args -> {
            Flyway flyway = Flyway.configure().dataSource(
                    datasourceUrl,
                    datasourceUser,
                    datasourcePass
            ).load();
            flyway.migrate();
        };
    }
}
