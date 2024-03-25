package DAY14.Ex02_WildCard;

//2024-02-21 
//MSA 기반 풀스택 교육 14일차

public class WildCardEx {
	
	// ? : 와일드 카드
	//   : 알 수 없는 타입을 대체하기 위해 사용하는 기호이다.
	public static void checkCourse(Course<?> course) {
		System.out.println("과정명 : " + course.getName());
		Object[] studentList = course.getStudents();
		for (Object student : studentList) {
			System.out.println(student + " ");
		}
	}
	
	public static void checkWorkerCourse(Course<? super Worker> course) {
		System.out.println("과정명 : " + course.getName());
		Object[] studentList = course.getStudents();
		for (Object student : studentList) {
			System.out.println(student + " ");
		}
	}
	
	public static void checkStudentCourse(Course<? super Student> course) {
		System.out.println("과정명 : " + course.getName());
		Object[] studentList = course.getStudents();
		for (Object student : studentList) {
			System.out.println(student + " ");
		}
	}
	
	public static void main(String[] args) {
		// 일반 과정, 정원 5명
		Course<Person> personCoures = new Course<>("일반 과정", 5);
		personCoures.add(new Person("일반인"));
		personCoures.add(new Worker("직장인"));
		personCoures.add(new Student("학생"));
		personCoures.add(new HighStudent("고등학생"));
		personCoures.add(new MiddleStudent("중학생"));
		checkCourse(personCoures);
		
		// 직장인 과정, 정원 5명
		Course<Worker> workerCoures = new Course<>("직장인 과정", 5);
		// workerCoures.add(new Person("일반인"));
		workerCoures.add(new Worker("직장인"));
		// workerCoures.add(new Student("학생"));
		// workerCoures.add(new HighStudent("고등학생"));
		// workerCoures.add(new MiddleStudent("중학생"));
		checkCourse(workerCoures);
		checkWorkerCourse(workerCoures);
		checkWorkerCourse(personCoures);
		
		// 학생 과정, 정원 5명
		Course<Student> studentCoures = new Course<>("학생 과정", 5);
		// studentCoures.add(new Person("일반인"));
		// studentCoures.add(new Worker("직장인"));
		studentCoures.add(new Student("학생"));
		studentCoures.add(new HighStudent("고등학생"));
		studentCoures.add(new MiddleStudent("중학생"));
		checkCourse(studentCoures);
		checkStudentCourse(studentCoures);
		
		// 중학생 과정
		Course<MiddleStudent> middleStudentCourse = new Course<>("중학생 과정", 5);
		// 고등학생 과정
		Course<HighStudent> highStudentCourse = new Course<>("고등학생 과정", 5);
		
		// checkStudentCourse(personCourse);
		// checkStudentCourse(workerCourse);
		// checkStudentCourse(middleStudentCourse);
		// checkStudentCourse(highStudentCourse);
		checkStudentCourse(studentCoures);
		
	}
}
