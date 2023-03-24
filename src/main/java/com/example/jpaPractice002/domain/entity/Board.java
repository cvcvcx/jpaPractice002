package com.example.jpaPractice002.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;//기본적인 JPA가 익숙해지면, 이후 ManyToOne 어노테이션을 통해 관계설정할 예정
}
