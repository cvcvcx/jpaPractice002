package com.example.jpaPrectice002.domain.repository;


import com.example.jpaPrectice002.domain.dto.BoardDTO;
import com.example.jpaPrectice002.domain.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository{
    //Page<BoardDTO>를 반환해서, Service에서 PageResultDto로 변환시킬예정
    @Override
    public Page<BoardDTO> findBoardPage(PageRequestDTO pageRequestDTO) {

        PageRequest pageable = PageRequest.of(pageRequestDTO.getPage(), pageRequestDTO.getSize());//페이지와 게시글 수를 정하는 pageable 객체생성



        return null;
    }
}
