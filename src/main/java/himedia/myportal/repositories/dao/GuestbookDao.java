package himedia.myportal.repositories.dao;

import java.util.List;

import himedia.myportal.repositories.vo.GuestbookVo;

public interface GuestbookDao {
	public List<GuestbookVo> selectAll();	//	게시물 목록
	public int insert(GuestbookVo vo);	//	게시물 작성
	public int delete(GuestbookVo vo);	//	게시물 삭제

}
