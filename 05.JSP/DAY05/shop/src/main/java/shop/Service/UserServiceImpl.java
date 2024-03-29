package shop.Service;

import shop.DAO.UserDAO;
import shop.DTO.Users;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAO();
	
	@Override
	public int join(Users user) {
		int result = userDAO.join(user);
		
		if( result > 0 ) {
			System.out.println("회원 가입 처리 성공!");
		} else {
			System.out.println("회원 가입 실패!");
		}
		// 기본 회원 권한을 추가...
		
		return result;
	}

	@Override
	public Users login(Users user) {
		
		Users loginUser = userDAO.login(user);
		
		// 로그인 성공
		if( loginUser != null ) {
			System.out.println("로그인 성공!");
			return loginUser;
		}
		
		// 로그인 실패
		System.out.println("로그인 실패!");
		return null;
	}

}







