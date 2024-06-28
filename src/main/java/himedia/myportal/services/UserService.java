package himedia.myportal.services;

import himedia.myportal.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	public boolean join(UserVo vo);	//	회원 가입
	public UserVo getUser(String email);	//	중복 가입 체크
	public UserVo getUser(String email, String password);	//	로그인
	
	public boolean isAuthenticated(HttpServletRequest request);	//	인증 체크 메서드
}
