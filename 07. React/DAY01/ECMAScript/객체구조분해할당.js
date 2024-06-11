const person = {
    name    : 'parkeunseo',
    age     :  28,
    gender  : 'man'    
};

// 객체의 구조 분해 할당
const { name, age, ... rest } = person;

console.log(name);
console.log(age);
console.log(rest);
