package kh.mclass.demo5.tripant;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaomobilityApi {
//	//kakao.api.key=
    @GetMapping("/map")
    public String getMap(Model model) {
        //model.addAttribute();
        return "kakaomobilityApi";
    }
}
