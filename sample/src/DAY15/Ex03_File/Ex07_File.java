package DAY15.Ex03_File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//2024-02-22 
//MSA 기반 풀스택 교육 15일차

public class Ex07_File {

	/** 디렉토리 생성
	 * @param filePath
	 */
	private static void makeDirectory(String filePath) {
		// 파일 객체 생성 방법
		// 1. File 객체명 = new File(파일경로);
		// 2. File 객체명 = new File(폴더경로, 파일명);
		File file = new File(filePath);
	
		// 폴더 생성
		// mkdir()	: make dircetory, 생성할 경로의 상위 경로까지 기존 디렉토리가 존재해야한다.
		// mkdirs() : 생성할 경로의 상위 경로까지 디렉토리를 생성해준다.
		if(file.mkdirs()) {
			System.out.println("디렉토리 생성 성공!");
		}
		else {
			System.err.println("디렉토리 생성 실패!");
		}
	}
	
	/** 디렉토리 파일 목록 출력 메소드
	 * @param filePath
	 */
	private static void listDirectory(String filePath) {
		System.out.println(filePath);
		System.out.println("-------------------------------------------");
		
		File file = new File(filePath);
		File[] fileList = file.listFiles();
		
		for (File subFile : fileList) {
			long update = subFile.lastModified();
			Date date = new Date(update);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String updateDate = sdf.format(date);
			
			System.out.print(subFile.getName() + "\t\t");	// 파일명
			System.out.print(subFile.length() + "\t\t");	// 파일 크기
			System.out.print(updateDate + "\t\t"); 		// 수정일자
			System.out.println();
		}
		System.out.println("-------------------------------------------");
	}
	
	
	/**
	 * 파일 정보를 조회하는 메소드
	 * @param filePath
	 */
	private static void fileInfo(String filePath) {
		File file = new  File(filePath);
		System.out.print("파일 종류 : ");
		if(file.isDirectory()) System.out.println("디렉토리");
		if(file.isFile()) System.out.println("일반파일");
		
		long update = file.lastModified();
		Date date = new Date(update);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String updateDate = sdf.format(date);
		
		System.out.print(file.getName() + "\t\t");	// 파일명
		System.out.print(file.length() + "\t\t");	// 파일 크기
		System.out.print(updateDate + "\t\t"); 		// 수정일자
		System.out.println();
	}


	/**
	 * 파일을 삭제하는 메소드
	 * @param filePath
	 */
	private static void deleteFile(String filePath) {
		File file = new File(filePath);
		
		// 파일 존재 여부 확인
		if(file.exists()) {
			// delete()
			// - 파일 삭제 성공 --> true
			// - 파일 삭제 실패 --> false
			// * 하위 경로에 파일이 존재하면 삭제가 되지 않는다.
			if(file.delete()) {
				System.out.println("파일 삭제 성공!");
			}
			else {
				System.err.println("파일 삭제 실패!");
			}
		}
		else {
			System.err.println("파일이 존재하지 않습니다.");
		}
	}
	
	/** 
	 * 폴더를 삭제하는 메소드
	 * @param filePath
	 */
	private static void deleteDirectory(String filePath) {
		File file = new File(filePath);
		File[] fileList = file.listFiles();		// 하위 파일 목록
		
		// 하위 경로에 파일이 있으면, 하위 파일들을 먼저 삭제
		if(fileList != null) {
			// 하위 경로의 파일들을 삭제
			for (File subFile : fileList) {
				// 재귀 호출
				deleteDirectory(subFile.getPath());	// 하위 파일 경로 전달
			}
		}
		
		// 폴더 (파일) 삭제
		if(file.delete()) {
			System.out.println("폴더 (파일) 삭제 성공!");
		}
		else {
			System.err.println("폴더 (파일) 삭제 실패!");
		}
	}
	
	/**
	 * 메뉴 출력 메소드
	 */
	public static void menu() {
		System.out.println("########## 파일 관리 ############");
		System.out.println("1. 디렉토리 생성");
		System.out.println("2. 디렉토리 파일 목록");
		System.out.println("3. 파일정보 조회");
		System.out.println("4. 파일 삭제");
		System.out.println("5. 폴더 삭제");
		System.out.println("0. 종료");
		System.out.print("######## 번호 : ");
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 메뉴 번호
		int menuNo;
		
		do {
			// 메뉴판 출력
			menu();
			// 메뉴번호 입력
			menuNo = sc.nextInt();
			// 엔터 제거
			sc.nextLine();	
					
			if(menuNo == 0) break;
			
			// 파일 경로 입력
			System.out.println("파일 경로 : ");
			String filePath = sc.nextLine();
			
			// 메뉴 선택
			switch(menuNo) {
				case 1:
					// 디렉토리 생성
					makeDirectory(filePath);
					break;
				case 2:
					// 디렉토리 파일 목록
					listDirectory(filePath);
					break;
				case 3:
					// 파일 정보 조회
					fileInfo(filePath);
					break;
				case 4:
					// 파일 삭제
					deleteFile(filePath);
					break;
				case 5:
					// 폴더 삭제
					deleteDirectory(filePath);
					break;
				default:
					break;
			}
			
		} while (true);
	}
}
