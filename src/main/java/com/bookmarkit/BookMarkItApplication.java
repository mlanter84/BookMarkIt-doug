package com.bookmarkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BookMarkItApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMarkItApplication.class, args);
    }
}
