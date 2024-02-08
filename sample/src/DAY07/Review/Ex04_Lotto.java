package DAY07.Review;

//2024-02-08 
//MSA 기반 풀스택 교육 7일차

public class Ex04_Lotto {

	public static void main(String[] args) {
		// Math.random() : 0.xxxxx ~ 0.9xxxx 사이의 난수를 반환하는 메소드
		double random = Math.random();
		System.out.println(random);
		
		// 1부터 6사이의 정수 : 주사위
		// Math.random()에 6을 곱하면 0 ~ 5 사이의 랜덤한 숫자가 나온다.
		// + 1을 한 이유는 1부터 6까지의 숫자를 구하기 위해
		int dice = (int)(Math.random() * 6) + 1;
		System.out.println(dice);
		
		// 1부터 45 사이의 정수 : 로또
		// (공식) : (int) (Math.random() * [개수]) + [시작숫자]
		int lotto = (int)(Math.random() * 45) + 1;
		System.out.println("로또 랜덤 번호 : " + lotto);
		
		// -20 ~ 20 사이의 랜덤 수
		int random2 = (int)(Math.random() * 41) - 20;
		System.out.println(random2);
		
		// 1부터 45사이의 랜덤수 6개를 배열에 중복 없이 저장
		int arr[] = new int [6];
		for(int i = 0; i < arr.length; i++) {
			int r = (int)(Math.random() * 45) + 1;
			arr[i] = r;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		

	}
}
