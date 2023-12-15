package in.softserv.aspire;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AspireAssistApiApplication implements CommandLineRunner {

    @Value("${user.api.readTimeout}")
    private long apiReadTimeOut;
    @Value("${user.api.connectTimeout}")
    private long apiConnectTimeout;


    public static void main(String[] args) {
        SpringApplication.run(AspireAssistApiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(apiConnectTimeout))
                .setReadTimeout(Duration.ofMillis(apiReadTimeOut))
                .build();
    }

    public void run(String... args) throws Exception {
    }
}