package kh.mclass.demo5.tripant;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaomobilityApi {
//	//kakao.api.key=
	private String RESTAPIKEY="ba137b1073eb0e694126fe015e9003af";
    @GetMapping("/map")
    public String getMap(Model model) {
        // JavaScript 키를 뷰로 전달
        model.addAttribute("kakaoApiKey", RESTAPIKEY);
        return "kakaomobilityApi";
    }
}
