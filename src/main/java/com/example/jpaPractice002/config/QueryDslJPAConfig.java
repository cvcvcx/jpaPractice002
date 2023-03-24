package com.example.jpaPractice002.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDslJPAConfig {

    @PersistenceContext//스프링이 가지고있는 EntityManager 를 주입받기위해 사용
    public EntityManager entityManager;

    @Bean //JPAQueryFactory 를 빈으로 등록해서 어디에서든 쿼리 보낼 수 있음
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }
}
