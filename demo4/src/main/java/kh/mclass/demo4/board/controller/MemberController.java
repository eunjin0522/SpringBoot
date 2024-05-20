package kh.mclass.demo4.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kh.mclass.demo4.board.domain.BoardEntity;
import kh.mclass.demo4.board.model.service.BoardService;

@RestController
//restcontroller를 적게되면 responsebody를 적지 않아도 된다
@RequestMapping("/board")
public class MemberController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("") //board까지만 치면 해당 controller 실행
	public @ResponseBody String list() {
		List<BoardEntity> boardlist=boardService.selectAll();
		return "전송될 데이터가 들어감";
	}
	@DeleteMapping("/{boardId}")
	public ResponseEntity<List<BoardEntity>>  delete(@PathVariable String boardId) {
		List<BoardEntity> boardlist=boardService.selectAll();
		//return ResponseEntity.internalServerError().build();//500
		//return ResponseEntity.notFound().build(); //오류 코드 번호 보내주는 return ex)404
		//return ResponseEntity.ok().body(boardlist);
		return ResponseEntity.ok(boardlist);
	}
}
