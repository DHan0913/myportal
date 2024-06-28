package himedia.myportal.repositories.dao;

import himedia.myportal.repositories.vo.UserVo;

public interface UserDao {
	public int insert(UserVo vo);	//	회원 가입
	public UserVo selectUser(String email);	//	중복 이메일 체크
	public UserVo selectUser(String email, String password);	//	로그인용
}
