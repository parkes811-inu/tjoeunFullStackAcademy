package DAY11.Ex04_AutoClose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("test.txt");
			
			int read = 0;
			
			// fis.read() : .txt 파일의 데이터를 한 글자씩 읽어오는 메소드
			//				* 더 이상 읽어온 데이터가 없으면 -1을 반환한다.
			
			// 가져올 글자가 없을 때 까지 반복한다.
			while((read = fis.read()) != -1) {
				System.out.print((char) read);
			}
		} catch (FileNotFoundException e) {
			// FileNotFoundException : 파일이 존재하지 않을 때 발생하는 예외
			e.printStackTrace();
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			// IOException : 입력 및 출력 과정에서 발생하는 예외
			System.err.println("입출력 관련 예외가 발생하였습니다.");
			
			// 예외가 발생하는 원인을 찾아 단계별로 출력해준다.
			e.printStackTrace();
		}
		finally {
			if(fis != null) {
				try {
					fis.close();		// close() : 메모리 해제
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
