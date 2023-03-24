package com.example.jpaPractice002.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {
    //페이지에서 리스트를 보여줄 때 필요한 정보들을 요구
    //한 번에 보여줄 데이터의 사이즈-- 몇개의 게시글을 보여줄 것인가
    private Integer size;
    //몇 페이지를 보여줄 것인가
    private Integer page;
    //검색 조건중 어떤 항목으로 검색을 했는가
    private String type;
    //검색 단어는 무엇인가
    private String keyword;
    //정렬 방법은 어떤 것인가
    private BoardSearchSort sort;
}
