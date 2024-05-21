package kh.mclass.demo5.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor //전체생성자 , 기본생성자 못 씀
@Component 

public class BoardEntity {
	//@NonNull //null인 상태에선 절대 안 만들어짐
	private String boardId;
	private String boardTitle;
	private String boardContent;
}
