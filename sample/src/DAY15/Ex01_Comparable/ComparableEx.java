package DAY15.Ex01_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//2024-02-22 
//MSA 기반 풀스택 교육 15일차

class Book implements Comparable<Book> {
	String  title;
	String author;
	int price;
	
	// 생성자
	public Book() {
		this("제목없음", "작자미상", 0);
	}
	
	public Book(String title, String author, int price) { 
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	// getter, setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// toString
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	// compareTo()
	// - 책 객체의 가격순으로 오름차순이 되도록 기준을 정의
	@Override
	public int compareTo(Book o) {
		// this 	: 해당 객체
		// o		: 비교 객체
		// * 가격순으로 오름 차순
		int thisPrice = this.getPrice();
		int comPrice = o.getPrice();
		
		// 양수(1)  : 해당 객체가 크다 
		// 0	   : 같다
		// 음수(-1) : 해당 객체가 작다
		
		// 방법 1
		// if(thisPrice > comPrice) {
		// 	return 1;
		// }
		// if(thisPrice == comPrice) {
		// 	return 0;
		// }
		// if(thisPrice < comPrice) {
		// 	return -1;
		// }
		// return 0;
		
		// 방법2
		int gap = this.price - comPrice;	// 오름차순
		int gap2 = comPrice - this.price;	// 내림차순
		return gap2;
	}
}

public class ComparableEx {
	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book ("책5,", "작성자5", 50000));
		bookList.add(new Book ("책2,", "작성자2", 20000));
		bookList.add(new Book ("책3,", "작성자3", 30000));
		bookList.add(new Book ("책4,", "작성자4", 40000));
		bookList.add(new Book ("책1,", "작성자1", 10000));
		
		// 정렬 전
		System.out.println("정렬 전");
		for (Book book : bookList) {
			System.out.println(book);
		}
		System.out.println("------------------------------------");
		
		// 정렬 
		// * Book 객체에 구현된 compareTo() 메소드의 비교기준으로 정렬
		System.out.println("정렬 후");

		Collections.sort(bookList);
		
		for (Book book : bookList) {
			System.out.println(book);
		}
		
	}
}
