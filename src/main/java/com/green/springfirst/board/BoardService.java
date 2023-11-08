package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardInsDto;
import com.green.springfirst.board.model.BoardUpdVo;
import com.green.springfirst.board.model.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    // @RequiredArgsConstructor 및 BoardSerivce 클래스 구현부에
     private final BoardMapper mapper;// 이 아래내용처럼 구현됨

//    @Autowired
//    public BoardService(BoardMapper mapper) {
//        this.mapper = mapper;
//    }

    public List<BoardVo> getBoard() {
        return mapper.selBoardList();
    }

    public BoardDetailVo getBoardDetail(int iboard) {
        return mapper.selBoardById(iboard);
    }

    public int insBoard (BoardInsDto dto) {
        return mapper.insBoard(dto);
    }

    public int delBoard (int del) {
        return mapper.delBoard(del);
    }

    public int putBoard(BoardUpdVo upd) {

        return mapper.updBoard(upd);
    }
}
