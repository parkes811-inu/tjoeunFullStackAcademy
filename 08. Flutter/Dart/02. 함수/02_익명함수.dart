// 익명 함수 (콜백 함수) => 함수를 함수에 전달

// 함수
void test(String msg, Function(int) callback) {
  print("메세지 : $msg");
  callback(100);
}

void main() {
  // 익명 함수
  var callback = (int data) {
    print("콜백 함수 - data : $data");
  };

  test("안녕하세요", callback);

  // 익명함수
  test("반갑습니다.", (int data) {
    print("콜백 함수 2 - data : $data");
  });
}
