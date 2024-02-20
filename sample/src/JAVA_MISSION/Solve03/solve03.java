package JAVA_MISSION.Solve03;

public class solve03 {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {
			int first = i / 10;
			int second = i % 10;
			
			if(first - 3 == 0 || first - 6 == 0 || first - 9 == 0) {
				System.out.print("*");
			}
			
			if(second - 3 == 0 || second - 6 == 0 || second - 9 == 0) {
				System.out.print("*");
			}
			
			if(!(first - 3 == 0 || first - 6 == 0 || first - 9 == 0) &&
				!(second - 3 == 0 || second - 6 == 0 || second - 9 == 0)) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
