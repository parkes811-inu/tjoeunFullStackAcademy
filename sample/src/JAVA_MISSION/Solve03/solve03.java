package JAVA_MISSION.Solve03;

public class solve03 {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {
			// 십의 자리 숫자 분리
			int first = i / 10;
			// 일의 자리 숫자 분리
			int second = i % 10;
			
			// 십의 자리, 일의 자리가 3, 6, 9인지 확인하여 * 출력
			if(first - 3 == 0 || first - 6 == 0 || first - 9 == 0) {
				System.out.print("*");
			}
			
			if(second - 3 == 0 || second - 6 == 0 || second - 9 == 0) {
				System.out.print("*");
			}
			
			// 3, 6, 9가 포함되지 않는 숫자들 출력 
			if(!(first - 3 == 0 || first - 6 == 0 || first - 9 == 0) &&
				!(second - 3 == 0 || second - 6 == 0 || second - 9 == 0)) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
