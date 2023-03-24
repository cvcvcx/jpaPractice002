package com.example.jpaPractice002.domain.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageListResponseDTO<DTO> {
    private int page;
    private int totalPage;
    private int size;
    private int start;
    private int end;
    private boolean prev,next;
    private List<DTO> dtoList;
    private List<Integer> pageList;

    //Page객체를 기반으로 이 클래스의 인스턴스를 생성하는 생성자
    public PageListResponseDTO(Page<DTO> result){
        dtoList = result.stream().toList();
        totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    public void makePageList(Pageable pageable){
        this.page = pageable.getPageNumber()+1;
        this.size = pageable.getPageSize();
        //임시 끝페이지
        int tempEnd = (int)(Math.ceil((page)/10.0))*10;
        start = tempEnd-9;
        end = totalPage>tempEnd ? tempEnd : totalPage;
        prev = start>1;
        next = totalPage>end;
        pageList = IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());
    }

}
