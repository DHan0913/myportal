package himedia.myportal.services;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.UserDao;
import himedia.myportal.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean join(UserVo vo) {
		int insertedCount = 0;
		insertedCount = userDao.insert(vo);
		return insertedCount == 1;
	}

	@Override
	public UserVo getUser(String email) {
		UserVo userVo = userDao.selectUser(email);
		System.out.println("Service UserVo: " + userVo);
		return userVo;
	}

	@Override
	public UserVo getUser(String email, String password) {
		UserVo userVo = userDao.selectUser(email, password);
		return userVo;
	}

	@Override
	public boolean isAuthenticated(HttpServletRequest request) {
		// 세션을 통해서 사용자 인증 상태 체크
		HttpSession session = request.getSession(false);
		
		if (session != null) {	//	인증했을 가능성이 있다
			UserVo authUser = (UserVo)session.getAttribute("authUser");
			return authUser != null;
		}
		return false;
	}

}
