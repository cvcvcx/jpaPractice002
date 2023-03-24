package com.example.jpaPractice002.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate,modDate;
    @Builder
    @QueryProjection// 이 태그가 있으면 빌드시에 이 DTO타입의 Q모델이 생성된다.
    public BoardDTO(Long id, String title, String content, String writer, LocalDateTime regDate, LocalDateTime modDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
