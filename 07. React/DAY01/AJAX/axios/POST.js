// axios 모듈이 설치되어 있어야한다.
// npm install axios
// axios 는 라이브러리로, 포함시켜야한다.
const axios = require('axios');

const url = 'https://httpbin.org/post';
const data = {
    name : '박은서',
    age  :  28
};
const headers = {
    'ContentType' : 'application/json'
}

// axios POST 요청
axios.post(url, data, headers)
    .then(response => {
        console.log(`data : ${response.data}`);
        // console.dir(객체) 
        // : 객체를 펼쳐서 로그를 출력해준다.
        console.dir(response.data);
    })
    .catch(error => {
        console.error(`error : ${error}`);
    });