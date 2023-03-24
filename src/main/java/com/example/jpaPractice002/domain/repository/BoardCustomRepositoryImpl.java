package com.example.jpaPractice002.domain.repository;


import com.example.jpaPractice002.domain.dto.BoardDTO;
import com.example.jpaPractice002.domain.dto.BoardSearchSort;
import com.example.jpaPractice002.domain.dto.PageRequestDTO;
import com.example.jpaPractice002.domain.dto.QBoardDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.jpaPractice002.domain.entity.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository {
    //Page<BoardDTO>를 반환해서, Service에서 PageResultDto로 변환시킬예정

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<BoardDTO> findBoardPage(PageRequestDTO pageRequestDTO) {

        PageRequest pageable = PageRequest.of(pageRequestDTO.getPage()-1, pageRequestDTO.getSize());//페이지와 게시글 수를 정하는 pageable 객체생성

        List<BoardDTO> fetch = queryFactory.select(new QBoardDTO(board.id, board.title, board.content, board.writer, board.regDate, board.modDate))
                                           .from(board)
                                           .where(createBoardSearchOption(pageRequestDTO))
                                           .limit(pageable.getPageSize())
                                           .offset(pageable.getPageNumber())
                                           .orderBy(createBoardOrderBy(pageRequestDTO))
                                           .fetch();


        JPAQuery<Long> countQuery = queryFactory.select(board.count())
                                                .from(board)
                                                .where(createBoardSearchOption(pageRequestDTO));


        return PageableExecutionUtils.getPage(fetch, pageable, () -> countQuery.fetchOne());
    }

    private OrderSpecifier[] createBoardOrderBy(PageRequestDTO pageRequestDTO) {
        List<OrderSpecifier> orderSpecifiers = new ArrayList<>();
        BoardSearchSort sort = pageRequestDTO.getSort();
        if(sort==null){
            orderSpecifiers.add(new OrderSpecifier<>(Order.DESC,board.regDate));
        }else
        //이넘 리스트를 넘기면 여러 정렬조건이 들어갈 수 있는걸까? -- 생각해볼 문제
        if (sort.equals(BoardSearchSort.TITLE_ASC)) {
            orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, board.title));
        } else if (sort.equals(BoardSearchSort.TITLE_DESC)) {
            orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, board.title));
        } else if (sort.equals(BoardSearchSort.CONTENT_ASC)) {
            orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, board.content));
        } else if (sort.equals(BoardSearchSort.CONTENT_DESC)) {
            orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, board.content));
        } else if (sort.equals(BoardSearchSort.WRITER_ASC)) {
            orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, board.writer));
        } else if (sort.equals(BoardSearchSort.WRITER_DESC)) {
            orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, board.writer));
        }
        return orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]);
    }

    //where문에는 Predicate 타입이 와야하는데, 그 구현체중 하나인 BooleanBuilder 를 통해 검색조건을 생성한다.
    private BooleanBuilder createBoardSearchOption(PageRequestDTO pageRequestDTO) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (Objects.isNull(pageRequestDTO.getType()) || Objects.isNull(pageRequestDTO.getKeyword())) {
            return null; //null이 들어가면 자동으로 조건이 없어짐
        } else {
            String type = pageRequestDTO.getType();
            String keyword = pageRequestDTO.getKeyword();
            if (type.contains("t")) {
                booleanBuilder.or(board.title.contains(keyword));
            }
            if (type.contains("c")) {
                booleanBuilder.or(board.content.contains(keyword));
            }
            if (type.contains("w")) {
                booleanBuilder.or(board.writer.contains(keyword));
            }
            return booleanBuilder;
        }
    }
}
