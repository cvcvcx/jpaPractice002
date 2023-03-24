package com.example.jpaPrectice002.service;

import com.example.jpaPrectice002.domain.dto.BoardDTO;
import com.example.jpaPrectice002.domain.dto.PageListResponseDTO;
import com.example.jpaPrectice002.domain.dto.PageRequestDTO;
import com.example.jpaPrectice002.domain.entity.Board;

public interface BoardService {

    public PageListResponseDTO<BoardDTO> getPageList(PageRequestDTO pageRequestDTO);


    default public Board dtoToEntity(BoardDTO dto){
        Board build = Board.builder()
                           .id(dto.getId()) //수정시에 id가 존재할 것이므로 존재하지 않을때에는 null 이 들어감
                           .title(dto.getTitle())
                           .content(dto.getContent())
                           .writer(dto.getWriter())
                           .build();
        return build;
    }
}
