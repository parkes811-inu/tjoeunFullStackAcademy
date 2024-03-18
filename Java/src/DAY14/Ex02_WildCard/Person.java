package DAY14.Ex02_WildCard;

//2024-02-21 
//MSA 기반 풀스택 교육 14일차

public class Person {
	private String name;

	// 생성자
	public Person(String name) {
		this.name = name;
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Person [" + name + "]";
	}

	
	
}
