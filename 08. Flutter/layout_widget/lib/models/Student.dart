class Student {
  // 이미지 경로
  // 학생 이름
  // 나이
  // 졸업 여부
  String? imagePath;
  String? name;
  int? age;
  bool? isGradurated;

  // 생성자
  Student(
      // required : 객체 생성 시, 필수로 전달할 값으로 지정
      {required this.imagePath,
      required this.name,
      required this.age,
      this.isGradurated});
}
