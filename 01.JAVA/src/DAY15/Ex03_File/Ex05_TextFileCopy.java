package DAY15.Ex03_File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//2024-02-22 
//MSA 기반 풀스택 교육 15일차

public class Ex05_TextFileCopy {
	public static void main(String[] args) {
		// test.txt 파일을 test4.txt 파일로 복사
		// 1. test.txt 파일 입력
		// 2. test4.txt 파일로 출력
		FileReader fr = null;
		FileWriter fw = null;
		
		int data = 0;
		
		try {
			fr = new FileReader("./src/DAY15/test.txt");
			fw = new FileWriter("./src/DAY15/test4.txt");
			
			// 파일 입력
			while((data = fr.read()) != -1) {
				// 파일 출력
				fw.write(data);
			}
			fr.close();
			fw.close();
			System.out.println("파일이 복사되었습니다.");
			System.out.println("test.txt ---> test4.txt");
		} catch (IOException e) {
			System.err.println("입출력 시, 예외가 발생하였습니다.");
			e.printStackTrace();
		}
	}
}
