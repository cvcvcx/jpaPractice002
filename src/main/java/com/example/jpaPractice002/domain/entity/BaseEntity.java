package com.example.jpaPractice002.domain.entity;


import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modDate;
}
