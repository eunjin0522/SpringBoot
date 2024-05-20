package kh.mclass.demo5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.mclass.demo5.domain.BoardEntity;


@Controller
public class DemoController {
	@GetMapping("home")
	public String home() {
		return "home"; //home은 tempates에 css는 static에 넣어준
	}
	
	
//	@GetMapping("board/list")  //templates 파일 아래 생성된 파일명을 쓰고 주소 적기...?
//	public void boardlist(Model model, HttpSession session) {
//		BoardEntity dto = new BoardEntity("aaa","1212","121212");
//		model.addAttribute("board", dto);
//		BoardEntity sessiondto = new BoardEntity("00","00TITLE","00CONTENT");
//		session.setAttribute("demosession", sessiondto);
//	}
	@GetMapping("board/{boardId}")  //templates 파일 아래 생성된 파일명을 쓰고 주소 적기...?
	public String boardlist(Model model, @PathVariable String boardId) {
		BoardEntity dto = new BoardEntity(boardId,boardId+"title!!!",boardId+"content!!!!!!");
		model.addAttribute("board", dto);
		return "board/read";
	}
	
	@GetMapping("board/list/ajax")  //templates 파일 아래 생성된 파일명을 쓰고 주소 적기...?
	@ResponseBody
	public BoardEntity boardlistajax(Model model) {
		BoardEntity dto = new BoardEntity("aaa","1212","121212");
		model.addAttribute("board", dto);
		return dto;
	}
}
