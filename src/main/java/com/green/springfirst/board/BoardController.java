package com.green.springfirst.board;

import com.green.springfirst.ResVo;
import com.green.springfirst.board.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// 컨트롤러는 요청이 들어왔을 때 응답해주는 기능
@RestController // 빈등록 하면서 컨트롤러역할까지 한다. // RestController은 디폴트가JSON, Controller 디폴트가 HTML응답
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;
    //같은 주소값이더라도 날리는방식에 따라 분기가 될 수 있다.
    @PostMapping("/board")
    // @RequestBody JSON으로 들어오는것을 @RequestBody로 받는다)
    // insBoard() 메소드를 호출하는게 서블릿이고 서블릿이 BoardInsDto를 dto로 객체화까지 한다.
    public ResVo insBoard(@RequestBody BoardInsDto dto) {
        System.out.println(dto);
        int result = service.insBoard(dto);
        System.out.println(result);
        return new ResVo(result);
    }
    @DeleteMapping("/board/{iboard}")
    public ResVo boardDelVo(@PathVariable int iboard){
        System.out.println(iboard);
        int result = service.delBoard(iboard);
        System.out.println(result);
        return new ResVo(result);
    }

    @GetMapping("/board") // ()안에는 주소값 "/board"
    public List<BoardVo> getBoard() { // getBoard가 요청받고 응답해줌
        return service.getBoard();
    }



    @GetMapping("/board/{iboard}") // ()안에는 주소값
    public BoardDetailVo getBoardDetail(@PathVariable int iboard) {
        return service.getBoardDetail(iboard);
    }

    @PutMapping("/board")
    public ResVo putBoard(@RequestBody BoardUpdVo upt) {
        System.out.println(upt);
        int result = service.putBoard(upt);
        return new ResVo(result);


    }
}

/*
< http - method 통신 메소드 4가지 >
    C - Insert - post : Query String 사용(선택) body에 데이터를 담아서 요청
    R - Select - get : Query String 사용(필수)
    U - Update - put/patch : Query String 사용(선택)
    D - Delete - delete : Query String 사용(?)
*/