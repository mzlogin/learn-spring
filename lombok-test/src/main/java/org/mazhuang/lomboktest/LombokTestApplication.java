package org.mazhuang.lomboktest;

import lombok.CustomLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mazhuang
 */
@SpringBootApplication
@CustomLog(topic = "MONITOR_LOGGER_NAME")
public class LombokTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LombokTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Go, go, go!");
    }
}
