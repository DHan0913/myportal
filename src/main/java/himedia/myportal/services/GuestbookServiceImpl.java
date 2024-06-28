package himedia.myportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.GuestbookDao;
import himedia.myportal.repositories.vo.GuestbookVo;
@Service("guestbookService")
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	GuestbookDao guestbookDao;
	
	@Override
	public List<GuestbookVo> getMessageList() {
		List<GuestbookVo> list = guestbookDao.selectAll();
		return list;
	}

	@Override
	public boolean writeMessage(GuestbookVo vo) {
		int insertedCount = guestbookDao.insert(vo);
		return insertedCount == 1;
	}

	@Override
	public boolean deleteMessage(GuestbookVo vo) {
		return 1 == guestbookDao.delete(vo);
	}

}
