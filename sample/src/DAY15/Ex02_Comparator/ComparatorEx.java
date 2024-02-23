package DAY15.Ex02_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//2024-02-22 
//MSA 기반 풀스택 교육 15일차

class User implements Comparator<User> {

	String id;
	String name;
	int age;
	
	// 생성자
	public User() {
		this("-", "-", 0);
	}
	
	public User(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	// getter, setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// toString()
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	// compare
	@Override
	public int compare(User o1, User o2) {
		// 정렬 기준 1 : 나이순 - 오름차순
		// 정렬 기준 2 : 이름순 - 내림차순
		
		// o1 : 해당 객체
		// o2 : 비교 객체
		
		// 나이순으로 오름차순 조건을 주고,
		// 나이가 같을 때, 이름순으로 내림차순이 되도록 조건을 작성.
		int age1 = o1.getAge();
		int age2 = o2.getAge();
		String name1 = o1.getName();
		String name2 = o2.getName();
		
		// 방법 1
		// 1차 정렬 기준 : 나이순으로 오름차순 정렬
		// if(age1 > age2) {
		// 	return 1;
		// } 
		
		// if(age1 == age2) {
		// 	int gap = name1.compareTo(name2);
		// 	
		// 	// if(gap > 0) {
		// 	//	return 1;
		// 	// }
		// 	// if(gap == 0) {
		// 	//	return 0;
		// 	// }
		// 	// if(gap < 0) {
		// 	//	return -1;
		// 	// }
		// 	// return 0;
		// 	// 2차 정렬 기준 : 이름순으로 내림차순 정렬
		// 	return -gap; 
		// }
		
		// if(age1 < age2) {
		// 	return -1;
		// }
		// return 0;
		
		// 방법 2
		int result1 = age1 - age2;
		int result2 = -name1.compareTo(name2);
		if(result1 == 0) return result2;
		// return result1;
		return result1 == 0 ? result2 : result1;
	}
	
	
}
public class ComparatorEx {
	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		userList.add(new User ("User1004", "홍조은", 34));
		userList.add(new User ("joeun1234", "전조은", 25));
		userList.add(new User ("joeun1234", "김조은", 25));
		userList.add(new User ("joeun1234", "배조은", 25));
		userList.add(new User ("joeun1234", "황조은", 25));
		userList.add(new User ("aloha2024", "박조은", 28));
		userList.add(new User ("tjoeun11", "권조은", 30));
		userList.add(new User ("hana96", "이조은", 22));

		
		// 정렬 전
		System.out.println("정렬 전");
		for (User user : userList) {
			System.out.println(user);
		}
		System.out.println("------------------------------------");
		
		// 정렬 
		System.out.println("정렬 후");

		Collections.sort(userList, new User());
		
		for (User user : userList) {
			System.out.println(user);
		}
	}
}
