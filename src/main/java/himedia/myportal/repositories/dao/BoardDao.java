package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> selectAll();
	public int insert(BoardVo boardVo);
	public BoardVo getContent(Long no);
	public int update(BoardVo boardVo);
	public int increaseHitCount(Long no);
	public int delete(Long no, Long userNo);
}
