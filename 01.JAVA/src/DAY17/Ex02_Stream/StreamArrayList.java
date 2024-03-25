package DAY17.Ex02_Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//2024-02-26 
//MSA 기반 풀스택 교육 17일차

class Person {
	String name;
	int age;
	
	// constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// getter, setter
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class StreamArrayList {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add( new Person("김조은", 20) );
		list.add( new Person("이조은", 30) );
		list.add( new Person("박조은", 25) );
		list.add( new Person("최조은", 35) );
		list.add( new Person("조은", 28) );
		list.add( new Person("김조", 22) );
		
		// 매핑 - map
		// : 스트림 요소를 사용하려는 형태로 변환하는 연산
		// * 이름만 추출(매핑)하여 반복
		list.stream().map(p -> p.getName()) 
					 .forEach(n -> System.out.print(n + " "));
		System.out.println();
		list.stream().map(p-> p.getAge())
					 .forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		// filter
		// : 스트림 요소에서 조건에 맞는 요소만 선택하는 연산
		// * length()를 사용하여 이름이 3글자 이상인 사람들만 필터링하여 반복
		list.stream().filter(p -> p.getName().length() >= 3)
					 .forEach(p -> System.out.println(p));
		System.out.println();
		
		// 나이가 25살 초과인 사람들만 필터링하여 반복
		list.stream().filter(p -> p.getAge() > 25)
					 .forEach(p -> System.out.print(p + " "));
		
		// Method Reference (::)
		// - 사용 방법 : 클래스명::메소드명
		// : 메소드 레퍼런스(참조정보)를 지정하는 문법
		// - 메소드 호출 시 전달 인자로 메소드 레퍼런스를 지정하여 넘겨줄 수 있다.
		// - 메소드를 통해 메소드를 전달하는 람다식을 대체하는 문법
		
		// 정렬 - sorted
		// list.stream().sorted( Comparator.comparing( 정렬 기준 ) );
		// * 이름 순으로 오름 차순 정렬
		// list.stream().sorted( Comparator.comparing( p -> p.getName()) )
		list.stream().sorted( Comparator.comparing( Person::getName) )
					 .forEach(p -> System.out.println(p));
		System.out.println();
		
		// * 나이 순으로 오름차순 정렬
		list.stream().sorted( Comparator.comparing( Person:: getAge ))
					 .forEach(p -> System.out.println(p + " "));
		
		
		// * 이름 순으로 내림 차순 정렬
		list.stream().sorted( Comparator.comparing( Person::getName).reversed())
					 .forEach(p -> System.out.print(p));
		System.out.println();
		
		// * 나이 순으로 내림차순 정렬
		list.stream().sorted( Comparator.comparing( Person:: getAge ).reversed())
					 .forEach(p -> System.out.print(p + " "));
		System.out.println();
		
		
		// 이름이 3글자인 사람들의 수
		long count = list.stream().filter(p -> p.getName().length() >= 3).count();
		System.out.println("이름이 3글자 이상인 사람들의 수 : " + count);
		
		// 이름이 2글자인 사람들의 나이의 합계
		long sum = list.stream().filter(p -> p.getName().length() == 2)
								.mapToInt(p -> p.getAge())
								.sum();
		System.out.println("이름이 2글자인 사람들의 나이 합계 " + sum);
				
	}
}
