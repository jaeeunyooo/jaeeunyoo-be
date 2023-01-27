package com.jaeeunyoo.infrastructure.configuration;

import com.jaeeunyoo.infrastructure.model.EntityScanAnchor;
import com.jaeeunyoo.infrastructure.repository.RepositoryScanAnchor;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
                       transactionManagerRef = "transactionManager",
                       basePackageClasses = { RepositoryScanAnchor.class })
@EntityScan(basePackageClasses = { EntityScanAnchor.class })
@Configuration
public class JpaConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
