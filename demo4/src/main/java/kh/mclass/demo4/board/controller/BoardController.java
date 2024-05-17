package kh.mclass.demo4.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.mclass.demo4.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@GetMapping("") //board까지만 치면 해달 controller 실행
	public String list(Model md) {
		md.addAttribute("boardlist", boardService.selectAll());
		return "aaa";
	}
	@DeleteMapping("/{boardId}")
	public String delete(@PathVariable String boardId) {
		
		return "aaa";
	}
}
