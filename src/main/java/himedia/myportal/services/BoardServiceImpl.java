package himedia.myportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.BoardDao;
import himedia.myportal.repositories.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVo> getList() {
		List<BoardVo> list = boardDao.selectAll();
		return list;
	}

	@Override
	public BoardVo getContent(Long no) {
		boardDao.increaseHitCount(no);
		BoardVo boardVo = boardDao.getContent(no);
		return boardVo;
	}

	@Override
	public boolean write(BoardVo boardVo) {
		int insertedCount = boardDao.insert(boardVo);
		return insertedCount == 1;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		int updatedCount = boardDao.update(boardVo);
		return updatedCount == 1;
	}

	@Override
	public boolean delete(Long no, Long userNo) {
		int deletedCount = boardDao.delete(no, userNo);
		return deletedCount == 1;
	}

}
