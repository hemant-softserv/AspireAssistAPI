package in.softserv.aspire;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import in.softserv.aspire.thread.WorkerThread;
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
    @Value("${thread.data.membershipNoStart}")
    private String membershipNoStart;
    @Value("${thread.data.apiKey}")
    private String apiKey;


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

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i,membershipNoStart+i,apiKey);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}