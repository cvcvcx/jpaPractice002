package com.example.jpaPractice002.domain.repository;

import com.example.jpaPractice002.domain.dto.BoardDTO;
import com.example.jpaPractice002.domain.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCustomRepository {
    public Page<BoardDTO> findBoardPage(PageRequestDTO pageRequestDTO);
}
