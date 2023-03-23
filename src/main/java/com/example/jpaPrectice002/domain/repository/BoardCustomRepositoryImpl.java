package com.example.jpaPrectice002.domain.repository;


import com.example.jpaPrectice002.domain.dto.BoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository{
    @Override
    public Page<BoardDTO> findBoardPage() {
        return null;
    }
}
