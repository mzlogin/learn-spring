package org.mazhuang.base64test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Encoder;

@SpringBootApplication
public class Base64testApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        byte[] content = "It takes a strong man to save himself, and a great man to save another.".getBytes();
//        String encrypted = new BASE64Encoder().encode(content);
//        byte[] decrypted = Base64Utils.decodeFromString(encrypted);
//        System.out.println(new String(decrypted));

        System.out.println(new BASE64Encoder().encode(content));
        System.out.println("--- 华丽的分隔线 ---");
        System.out.println(Base64Utils.encodeToString(content));
    }

    public static void main(String[] args) {
        SpringApplication.run(Base64testApplication.class, args);
    }

}
