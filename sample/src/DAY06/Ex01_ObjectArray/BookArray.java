package DAY06.Ex01_ObjectArray;

//2024-02-07 
//MSA 기반 풀스택 교육 6일차

import java.util.Scanner;

/*
 * 책제목, 저자명을 갖는 Book 클래스를 정의하고,  
 * Book 클래스타입의 객체 배열을 생성하여, 
 * 사용자로부터 책 3권을 일력받아 출력하는 프로그램
 *
 */

// 하나의 클래스 파일에서 여러 개의 클래스를 정의할 수 있다.
class Book {
	// 책제목, 저자명
	String title;
	String author;
	
	// 생성자 
	// alt + shift + S, O
	public Book() {
		this.title = "제목없음";
		this.author = "작자미상";
		// this("제목없음", "작자미상");
	}
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	// toString()
	// : 객체를 출력문에 출력 시, 출력할 템플릿을 지정하는 메소드
	// - Object(최상위클래스)에 정의된 toString() 메소드를 오버라이딩 하면,
	// 반환값을 출력문에서 출력하는 객체를 대신하여 출력한다.
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}
	
}

// 메인 클래스 : 클래스 파일 이름과 클래스 이름은 같아야 한다.
public class BookArray {
	public static void main(String[] args) {
		// 객체 배열
		// Book 타입의 객체 배열 선언 및 생성
		Book[] bookArray = new Book[3];
		
		Scanner sc = new Scanner(System.in);
		
		// 사용자 입력
		for(int i = 0; i < bookArray.length; i++) {
			System.out.println("제목 : ");
			String title = sc.nextLine();
			
			System.out.println("저자 : ");
			String author = sc.nextLine();
			
			// Book 객체를 생성하여 객체배열 bookArray에 대입
			bookArray[i] = new Book(title, author);
		} 
		
		// 출력
		for (Book book : bookArray) {
			System.out.println(book);
		}
		
		sc.close();
	}
}
