package com.example.jpaPrectice002.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryDslJPAConfig {

    @PersistenceContext//스프링이 가지고있는 EntityManager 를 주입받기위해 사용
    public EntityManager entityManager;

    @Bean //JPAQueryFactory 를 빈으로 등록해서 어디에서든 쿼리 보낼 수 있음
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }
}
