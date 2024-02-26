package DAY17.Ex02_Stream;

//2024-02-26 
//MSA 기반 풀스택 교육 17일차

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LottoStream {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 게임 ? ");
		int n = sc.nextInt();
		
		// n 번 반복
		for(int i = 0; i < n; i++) {
			System.out.print("[" + (i + 1) + " 게임] : ");
			// int[] lotto = new int[6];
			List<Integer> lottoList = new ArrayList<Integer> ();
			
			// 랜덤 수 6개 생성
			HashSet<Integer> set = new HashSet<Integer>();
			for(int j = 0; j < 6; j++) {
				int rand = (int)(Math.random() * 45 + 1); // 1 부터 45까지 랜덤 수
				
				// 중복 제거
				// - set.add()		: 중복이 아니면 true, 중복이면 false를 반환
				if(!(set.add(rand))) {
					j--;
				}
				
			} // -- 랜덤 수 6개 대입 끝
			
			// 스트림을 사용하여, set를 ArrayList로 변환하여 대입
			lottoList = set.stream().collect(Collectors.toList());
			
			// 스트림을 사용하여, 정렬 + 출력
			lottoList.stream()			// 스트림 객체 생성
					 .sorted()			// 정렬
					 .forEach(lotto -> System.out.print(lotto + " "));	// 전체 반복 (람다 표현식)
			System.out.println();
		}
		
		sc.close();

	}
}
