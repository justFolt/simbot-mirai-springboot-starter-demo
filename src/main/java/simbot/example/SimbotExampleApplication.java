package simbot.example;

import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类。
 * 其中，{@link SpringBootApplication} 为springboot的启动注解，
 * {@link EnableSimbot} 为simbot在springboot-starter下的启动注解。
 *
 * @author ForteScarlet
 */
@EnableAsync
@EnableSimbot
@EnableScheduling
@SpringBootApplication
public class SimbotExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimbotExampleApplication.class, args);
    }

}
