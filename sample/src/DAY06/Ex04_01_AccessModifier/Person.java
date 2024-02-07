package DAY06.Ex04_01_AccessModifier;

//2024-02-07 
//MSA 기반 풀스택 교육 6일차

public class Person {
	
	// 이름, 나이, 키, 체중
	public String name;
	protected int age;
	int height;
	private int weight;
	
	// 생성자
	public Person() {
		
	}
	
	// 매개변수 생성자
	public Person(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	// getter, setter
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return weight;
	}	
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	// toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
}
