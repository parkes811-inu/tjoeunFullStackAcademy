package DAY14.Ex02_WildCard;

//2024-02-21 
//MSA 기반 풀스택 교육 14일차

public class Student extends Person {

	public Student(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Student ["+ this.getName() +"]";
	}
	
	
}
