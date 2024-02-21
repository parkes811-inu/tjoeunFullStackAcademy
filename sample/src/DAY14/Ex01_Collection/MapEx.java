package DAY14.Ex01_Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//2024-02-21 
//MSA 기반 풀스택 교육 14일차

/*
	Map
	: 키(key), 값(value)를 쌍으로 구성한 요소를 다루는 컬렉션
	* key는 중복되지 않는다
	 
	요소 추가
	- put(key, value)			: 키와 값을 추가
						 		- 중복된 키가 추가되면, 마지막에 추가된 값이 저장된다
	
	요소 검색
	- get(key)					: 키에 해당하는 값 반환
	- contains(key)				: 키 존재 여부
	- containsValue(value)		: 값 존재 여부
	- isEmpty()					: 비어 있는지 여부
	- size()					: 요소의 개수
	- keySet()					: 모든 키를 Set 객체로 반환
	- values()					: 모든 값을 Collection 객체로 반환
	
	요소 삭제
	- remove(key)				: 키에 해당하는 값 삭제
	- clear()					: 모든 요소 삭제
*/

public class MapEx {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 요소 추가
		map.put("제니", 100);
		map.put("리사", 90);
		map.put("지수", 80);
		map.put("로제", 70);
		
		// 기존에 있는 키 이름 ("제니")에 다시 추가 하게 되면
		// 마지막에 추가한 키의 값을 갖게 된다.
		// * 중복된 키를 추가하면, 마지막에 추가한 값으로 지정된다.
		
		// 제니는 값은 100이 아닌 80을 갖게 된다.
		map.put("제니", 80);
		
		System.out.println("총 개수 : " + map.size());
		System.out.println();
		System.out.println("제니의 코딩 성적 : " + map.get("제니"));
		
		// Map 반복하기 1
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Integer value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		// Map 반복하기 2 - Iterator 사용
		// map.entrySet()			: iterator() 메소드를 갖는 Set 객체를 반환
		// entrySet.iterator()		: Map 컬렉션을 순차검색할 수 있는 iterator 객체를 가져옴
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while( entryIterator.hasNext() ) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String  key = entry.getKey();			// 키
			Integer value = entry.getValue();		// 값
			
			System.out.println(key + " : " + value);
		}
		System.out.println();
		map.clear();		// 모든 요소 삭제
		
		System.out.println("총 개수 : " + map.size());
		System.out.println("empty 여부 : " + map.isEmpty());
	}
}
