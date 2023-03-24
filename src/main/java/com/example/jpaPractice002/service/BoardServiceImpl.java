package com.example.jpaPractice002.service;


import com.example.jpaPractice002.domain.dto.BoardDTO;
import com.example.jpaPractice002.domain.dto.PageListResponseDTO;
import com.example.jpaPractice002.domain.dto.PageRequestDTO;
import com.example.jpaPractice002.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;


    @Override
    public PageListResponseDTO<BoardDTO> getPageList(PageRequestDTO pageRequestDTO) {
        Page<BoardDTO> boardPage = boardRepository.findBoardPage(pageRequestDTO);
        PageListResponseDTO<BoardDTO> boardList = new PageListResponseDTO<>(boardPage);
        return boardList;
    }
}
