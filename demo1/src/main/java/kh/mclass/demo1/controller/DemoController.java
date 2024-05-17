package kh.mclass.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/demo")
	public String mainMethod(Model model) {
		System.out.println(">>>>>>> controller 접속 성공 <<<<<<<");
		model.addAttribute("m1", "전달하는 값");
		return "aaa";
	}
}