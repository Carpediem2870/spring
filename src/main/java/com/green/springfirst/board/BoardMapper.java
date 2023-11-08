package com.green.springfirst.board;

import com.green.springfirst.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int updBoard(BoardUpdVo upd);
    int delBoard(int del);
    int insBoard(BoardInsDto dto);
    List<BoardVo> selBoardList();
    BoardDetailVo selBoardById(int iboard);// iboard말고 아무거나 넣어주면됨

}


