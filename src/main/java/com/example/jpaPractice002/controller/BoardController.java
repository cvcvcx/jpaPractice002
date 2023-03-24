package com.example.jpaPractice002.controller;

import com.example.jpaPractice002.domain.dto.BoardDTO;
import com.example.jpaPractice002.domain.dto.BoardSearchSort;
import com.example.jpaPractice002.domain.dto.PageListResponseDTO;
import com.example.jpaPractice002.domain.dto.PageRequestDTO;
import com.example.jpaPractice002.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public PageListResponseDTO<BoardDTO> getPage(String type, String keyword, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15")Integer size, BoardSearchSort sort){
        PageRequestDTO build = PageRequestDTO.builder()
                                             .type(type)
                                             .keyword(keyword)
                                             .page(page)
                                             .size(size)
                                             .sort(sort)
                                             .build();
        PageListResponseDTO<BoardDTO> pageList = boardService.getPageList(build);
        return pageList;
    }
}
