package himedia.myportal.repositories.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.UserDaoException;
import himedia.myportal.repositories.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(UserVo vo) {
		try {
			return sqlSession.insert("users.insert", vo);
		} catch (Exception e) {
			throw new UserDaoException("회원 가입 중 에러!", vo);
		}
	}

	@Override
	public UserVo selectUser(String email) {
		UserVo userVo = sqlSession.selectOne("users.selectUserByEmail", email);
		System.out.println("DAO UserVo: " + userVo);
		return userVo;
	}

	//	로그인
	@Override
	public UserVo selectUser(String email, String password) {
		// mybatis parameterType="map"으로 전달하기
		Map<String, String> userMap = new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password);
		
		UserVo userVo = 
			sqlSession.selectOne("users.selectUserByEmailAndPassword", userMap);
		return userVo;
	}

}
