package com.example.jpaPrectice002.domain.repository;

import com.example.jpaPrectice002.domain.dto.BoardDTO;
import com.example.jpaPrectice002.domain.dto.BoardSearchSort;
import com.example.jpaPrectice002.domain.dto.PageRequestDTO;
import com.example.jpaPrectice002.domain.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardCustomRepositoryImplTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void register(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Board entity = Board.builder()
                               .title("제목입니다" + String.format("%03d",i))
                               .content("내용입니다" + String.format("%03d",100 - i))
                               .writer("작성자" + String.format("%03d",(3 * i)))
                               .build();
            boardRepository.save(entity);
        });
    }


    @Test
    public void boardListGet(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                                          .page(1)
                                          .size(15)
                                          .type("wt")
                                          .keyword("2")
                                          .build();
        
        Page<BoardDTO> boardPage = boardRepository.findBoardPage(pageRequestDTO);
        System.out.println("boardPage = " + boardPage);
        boardPage.forEach(item-> System.out.println("item = " + item));
    }

}