package org.mazhuang.jacksontest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.mazhuang.jacksontest.entity.ClassAndFieldAnnotationData;
import org.mazhuang.jacksontest.entity.ClassAnnotationData;
import org.mazhuang.jacksontest.entity.FieldAnnotationData;
import org.mazhuang.jacksontest.entity.NoAnnotationData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JacksonTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JacksonTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        NoAnnotationData noAnnotationData = new NoAnnotationData();
        noAnnotationData.setId(10);

        log.info("NoAnnotationData: {}", objectMapper.writeValueAsString(noAnnotationData));

        FieldAnnotationData fieldAnnotationData = new FieldAnnotationData();
        fieldAnnotationData.setId(10);

        log.info("FieldAnnotationData: {}", objectMapper.writeValueAsString(fieldAnnotationData));

        ClassAnnotationData classAnnotationData = new ClassAnnotationData();
        classAnnotationData.setId(10);

        log.info("ClassAnnotationData: {}", objectMapper.writeValueAsString(classAnnotationData));

        ClassAndFieldAnnotationData classAndFieldAnnotationData = new ClassAndFieldAnnotationData();
        classAndFieldAnnotationData.setId(10);

        log.info("ClassAndFieldAnnotationData: {}", objectMapper.writeValueAsString(classAndFieldAnnotationData));
    }
}
