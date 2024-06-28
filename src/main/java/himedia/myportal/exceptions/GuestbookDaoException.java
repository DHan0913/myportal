package himedia.myportal.exceptions;

import himedia.myportal.repositories.vo.GuestbookVo;

public class GuestbookDaoException extends RuntimeException {
	private GuestbookVo guestbookVo = null;
	
	//	생성자 
	public GuestbookDaoException() {
		
	}
	
	public GuestbookDaoException(String message) {
		super(message);
	}
	
	public GuestbookDaoException(String message, GuestbookVo vo) {
		super(message);
		this.guestbookVo = vo;
	}

	//	Getter 
	public GuestbookVo getGuestbookVo() {
		return guestbookVo;
	}

}
