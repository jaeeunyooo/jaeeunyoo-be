package com.jaeeunyoo.apiblog;

import com.jaeeunyoo.infradatasource.DataSourceConfiguration;
import com.jaeeunyoo.infrajpa.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Import;

@Import({ DataSourceConfiguration.class, JpaConfiguration.class })
@SpringBootApplication(scanBasePackages = { "com.jaeeunyoo" })
public class BlogApiApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BlogApiApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
