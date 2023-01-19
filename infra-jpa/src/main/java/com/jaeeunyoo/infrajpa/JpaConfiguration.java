package com.jaeeunyoo.infrajpa;

import com.jaeeunyoo.infrajpa.model.EntityScanAnchor;
import com.jaeeunyoo.infrajpa.repository.RepositoryScanAnchor;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
                       transactionManagerRef = "transactionManager",
                       basePackageClasses = { RepositoryScanAnchor.class })
@EntityScan(basePackageClasses = { EntityScanAnchor.class })
public class JpaConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
