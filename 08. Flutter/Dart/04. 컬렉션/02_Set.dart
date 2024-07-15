void main() {
  Set<String> sets = {"김슬기", "박은서", "이종식"}; // set은 {}로 초기화
  print("프로 지각러 : $sets");

  sets.add("박은서"); // 요소 추가(증복 불가)
  print("sets : $sets");

  sets.remove("이종식"); // 요소 제거
  print("sets : $sets");
}
