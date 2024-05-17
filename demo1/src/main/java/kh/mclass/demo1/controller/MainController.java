package kh.mclass.demo1.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
//@RequiredArgsConstructor //autowired, qualifier 을 대신하는 어노테이션
public class MainController {
	@GetMapping("main/{abc}")
	public String main(
			//@RequestParam(name="b") String a,
			@PathVariable(required = false,name="abc") String def
			) {
		System.out.println("@PathVariable : "+def);
		return "main";
	}

	@GetMapping("mainapi")
	public @ResponseBody String mainapi() {
		return "mainapi";
	}
}
