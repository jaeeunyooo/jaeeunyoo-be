package com.jaeeunyoo.apiblog;

import com.jaeeunyoo.domain.DomainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Import;

@Import({ DomainConfiguration.class })
@SpringBootApplication(scanBasePackages = { BlogApiApplication.BASE_PACKAGE })
public class BlogApiApplication {

    public static final String BASE_PACKAGE = "com.jaeeunyoo";

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BlogApiApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
