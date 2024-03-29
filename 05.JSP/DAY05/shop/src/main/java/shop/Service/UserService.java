package shop.Service;

import shop.DTO.Users;

public interface UserService {

	// 회원가입
	public int join(Users user);
	
	// 로그인
	public Users login(Users user);
}
