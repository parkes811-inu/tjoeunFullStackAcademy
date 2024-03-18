package DAY15.Ex03_File;

import java.io.FileInputStream;
import java.io.IOException;


//2024-02-22 
//MSA 기반 풀스택 교육 15일차

public class Ex06_FileInputStream {
	public static void main(String[] args) {
		// 바이트 스크림 클래스
		// FileInputStream 객체로 바이트 코드 (이진 데이터) 그대로 입력
		// * 문자 스트림 클래스와 다르게 문자로 변환하는 작업을 직접 해주지 않는다.
		byte[] data = new byte[100];
		
		try {
			FileInputStream fis = new FileInputStream("./src/DAY15/test.out");
			
			int i = 0, b;
			
			while((b = fis.read()) != -1) {
				// 읽어온 바이트 b를 바이트 배열에 형변환하여 대입
				data[i] = (byte) b;
				i++;
			}
			
			for (byte a : data) {
				System.out.print((char) a);
			}
			fis.close();
		} catch (IOException e) {
			System.err.println("입출력 시, 예외가 발생하였습니다.");
			e.printStackTrace();
		}
	}
}
