package com.example.jpaPrectice002.domain.repository;

import com.example.jpaPrectice002.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long>,BoardCustomRepository {
}
