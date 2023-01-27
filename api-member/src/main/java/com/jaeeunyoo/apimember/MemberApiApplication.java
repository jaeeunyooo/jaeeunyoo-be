package com.jaeeunyoo.apimember;

import com.jaeeunyoo.domain.DomainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Import;

@Import({ DomainConfiguration.class })
@SpringBootApplication(scanBasePackages = { MemberApiApplication.BASE_PACKAGE })
public class MemberApiApplication {

    public static final String BASE_PACKAGE = "com.jaeeunyoo";

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MemberApiApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
