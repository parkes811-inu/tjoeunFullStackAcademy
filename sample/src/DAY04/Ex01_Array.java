package DAY04;

//2024-02-05 
//MSA 기반 풀스택 교육 4일차

public class Ex01_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 선언
		// - 자료형 변수명[]; 의 형태로 선언한다.
		int arr[];
		
		// 배열 생성
		// - 변수명 = new 자로형[개수];
		arr = new int[5];
		
		// 배열 요소에 접근
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		// 배열의 길이 : 배열 요소의 개수 = 배열.length
		int n = arr.length;
		System.out.println("배열의 길이 : " + n);
		
		// for : ctr + space 2번째 옵션
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}

}
