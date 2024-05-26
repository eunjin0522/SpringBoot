package kh.mclass.demo6;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/demo6/test")
	public String test1() {
		return "test1";
	}
}
