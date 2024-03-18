package DAY17.Ex02_Stream;
//2024-02-26 
//MSA 기반 풀스택 교육 17일차
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LottoArrayList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 게임 ? ");
		int n = sc.nextInt();
		
		// n 번 반복
		for(int i = 0; i < n; i++) {
			System.out.print("[" + (i + 1) + " 게임] : ");
			// int[] lotto = new int[6];
			ArrayList<Integer> lottoList = new ArrayList<Integer> ();
			
			// 랜덤 수 6개 생성
			for(int j = 0; j < 6; j++) {
				int rand = (int)(Math.random() * 45 + 1); // 1 부터 45까지 랜덤 수
				
				// 중복 제거
				// ArrayList의 contains 메소드를 활용하면
				// 중복된 수가 있는지 쉽게 확인이 가능하다.
				if(lottoList.contains(rand)) {
					j--;
				} 
				
				else {
					// lotto[j] = rand;
					lottoList.add(rand);
				}
				
			} // -- 랜덤 수 6개 대입 끝
			
			// 해당 i 번째 게임의 랜덤 수들을 정렬 - 오름차순
			Collections.sort(lottoList);
			
			// 출력
			for(int j = 0; j < 6; j++) {
				System.out.print(lottoList.get(j) + " ");
			}
			System.out.println();
		}
		
		sc.close();

	}
}
