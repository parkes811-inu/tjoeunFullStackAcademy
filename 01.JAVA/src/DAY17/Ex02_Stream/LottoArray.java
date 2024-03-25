package DAY17.Ex02_Stream;
//2024-02-26 
//MSA 기반 풀스택 교육 17일차
import java.util.Scanner;

public class LottoArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 게임 ? ");
		int n = sc.nextInt();
		
		// n 번 반복
		for(int i = 0; i < n; i++) {
			System.out.print("[" + (i + 1) + " 게임] : ");
			int[] lotto = new int[6];
			
			// 랜덤 수 6개 생성
			for(int j = 0; j < 6; j++) {
				int rand = (int)(Math.random() * 45 + 1); // 1 부터 45까지 랜덤 수
				lotto[j] = rand;
				
				// 중복 제거
				for(int k = 0; k < j; k++) {
					
					// 현재까지 뽑은 랜덤 수가, 기존의 수들과 똑같으면 다시 뽑는다.
					if(rand == lotto[k]) {
						// j를 1개 줄여, 번호를 다시 생성한다.
						j--;
					}
				}
			} // -- 랜덤 수 6개 대입 끝
			
			// 해당 i 번째 게임의 랜덤 수들을 정렬 - 오름차순
			for(int j = 0; j < 6; j++) {
				for(int k = j + 1; k < 6; k++) {
					// 앞에 요소가 더 크면 교환 - swap
					int temp = lotto[j];
					if(lotto[j] > lotto[k]) {
						lotto[j] = lotto[k];
						lotto[k] = temp;
					}
				}
			}
			
			for(int j = 0; j < 6; j++) {
				System.out.print(lotto[j] + " ");
			}
			System.out.println();
		}
		
		sc.close();

	}
}
