package JAVA_MISSION.Solve09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/* <조건>
 * (1) 화폐는고액권을우선으로지급, 나머지금액은그다음단위의화폐순서로지급한다.
 * (2) 화폐 단위는50000원, 10000원5000원, 1000원, 500원, 100원, 50원, 10원, 5원, 1원의10가지종류가있다.
 * (3) 입력데이터는성명, 간식비지급액이며, 성명의입력이"QUIT" 이면입력의끝으로간주한다.
 * (4) 출력은성명, 간식비지급액, 개인별각화폐매수, 마지막에전체화폐매수를출력한다
 * 
 */
public class solve09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> customer = new HashMap<String, Integer>();
		
		do {
			String name = sc.next();
			if(name.equals("QUIT")) break;
			int money = sc.nextInt();
			customer.put(name, money);
			
		} while (true);
		
		System.out.println("성명	출장비	오만원	만원"
				+ "	오천원	천원	오백원	백원	십원	오원	일원");
		Set<String> keySet = customer.keySet();
		for (String key : keySet) {
			Integer value = customer.get(key);
			System.out.println(key + "	" + value);
		}
		
		
		sc.close();
	}
}
