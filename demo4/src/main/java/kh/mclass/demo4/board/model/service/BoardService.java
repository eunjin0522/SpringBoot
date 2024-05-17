package kh.mclass.demo4.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.mclass.demo4.board.domain.BoardEntity;
import kh.mclass.demo4.board.model.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public List<BoardEntity> selectAll() {
		return boardRepository.selectAllList();
	}
}
