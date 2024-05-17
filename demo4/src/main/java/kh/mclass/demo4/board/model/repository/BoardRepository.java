package kh.mclass.demo4.board.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kh.mclass.demo4.board.domain.BoardEntity;

//어노테이션을 repository로 설정하면 해당 interface가 객체를 생성하지 못한다
@Mapper
public interface BoardRepository {
//	mapper에서 id가 inerface에서 method명이 되어야한다
	
	public List<BoardEntity> selectAllList();
}
