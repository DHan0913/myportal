package himedia.myportal.repositories.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.GuestbookDaoException;
import himedia.myportal.repositories.vo.GuestbookVo;

@Repository("guestbookDao")
public class GuestbookDaoImpl implements GuestbookDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<GuestbookVo> selectAll() {
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		try {
			int insertedCount = sqlSession.insert("guestbook.insert", vo);
			return insertedCount;
//		} catch (PersistenceException e) {
		} catch (Exception e) {
			// Dao의 Exception은 구체적인 사용자 정의 예외로 전환하여서 throw 한다
			throw new GuestbookDaoException("방명록 기록 중 예외 발생!", vo);
		}
	}

	@Override
	public int delete(GuestbookVo vo) {
		try {
			return sqlSession.delete("guestbook.delete", vo);
		} catch (Exception e) {
			throw new GuestbookDaoException("방명록 삭제 중 예외 발생!", vo);
		}
	}

}
