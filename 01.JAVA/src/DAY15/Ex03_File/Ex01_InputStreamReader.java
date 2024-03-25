package DAY15.Ex03_File;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//2024-02-22 
//MSA 기반 풀스택 교육 15일차

public class Ex01_InputStreamReader {
	public static void main(String[] args) {
		// 문자 스트림 클래스
		// new InputStreamReader( 입력스트림 객체 )
		// 입력스트림 객체 : System.in -> 키보드로부터 문자를 입력하는 스트림 객체

		InputStreamReader is = new InputStreamReader(System.in);
		
		while(true) {
			char ch = 0;
			
			try {
				// 입력스트림으로부터 한 글자씩 읽어옴
				ch = (char) is.read();	
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// read() 로 더 이상 읽어올 문자가 없으면 -1을 반환 (ctrl + z 입력)
			if(ch == -1) {
				break;
			}
			System.out.print(ch);
		}
	}
}
