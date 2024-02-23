package DAY15.Ex03_File;

import java.io.FileWriter;
import java.io.IOException;

//2024-02-22 
//MSA 기반 풀스택 교육 15일차

public class Ex03_FileWriter {
	public static void main(String[] args) {
		FileWriter fw = null;
		String str = "텍스트 파일에 출력할 내용";
		
		try {
			// 파일명 test2.txt로 출력 스트림 객체 생성
			fw = new FileWriter("./src/DAY15/test2.txt");
			// 문자열 str을 index 0 ~ 끝가지 출력
			fw.write(str, 0, str.length());
			fw.close();
			System.out.println("텍스트 파일이 저장되었습니다.");
		} catch (IOException e) {
			System.err.println("입출력 시, 에러가 발생하였습니다.");
			e.printStackTrace();
		}
		
		
	}
}
