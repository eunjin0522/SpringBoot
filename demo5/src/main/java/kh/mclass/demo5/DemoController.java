package kh.mclass.demo5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kh.mclass.demo5.domain.BoardEntity;


@Controller
public class DemoController {
	@GetMapping("home")
	public void commonHeader() {
	}
	@GetMapping("board/list")  //templates 파일 아래 생성된 파일명을 쓰고 주소 적기...?
	public void boardlist(Model model, HttpSession session) {
		//DB
		List<BoardEntity> boardlist=new ArrayList<>();
		for(int i = 0 ; i <10 ; i++) {
			BoardEntity dto = new BoardEntity(i+"",i+"TITLE",i+"content");
			boardlist.add(dto);
		}
		
		model.addAttribute("boardlist", boardlist);
	}
	
	@GetMapping("board/{boardId}")  //templates 파일 아래 생성된 파일명을 쓰고 주소 적기...?
	public String boardread(Model model, @PathVariable String boardId) {
		BoardEntity dto = new BoardEntity(boardId,boardId+"title!!!",boardId+"content!!!!!!");
		model.addAttribute("boardread", dto);
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
