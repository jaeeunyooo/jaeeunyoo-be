package com.jaeeunyoo.domain;

import com.jaeeunyoo.infrastructure.configuration.DependencyConfiguration;
import com.jaeeunyoo.infrastructure.configuration.JpaConfiguration;
import com.jaeeunyoo.infrastructure.configuration.WebMvcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ JpaConfiguration.class, WebMvcConfiguration.class, DependencyConfiguration.class })
@Configuration
public class DomainConfiguration {
}
