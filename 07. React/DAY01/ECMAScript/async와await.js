async function fetchData() {

    const response = await fetch('https://httpbin.org/get');
    // await를 쓰면 비동기 응답을 기다린다.

    // console.log(response);
    
    // json 객체로 변환
    const data = await response.json();
    
    // async, await를 쓰지 않는 경우 코드의 길이가 길어질 수 있다.
    // response.then((result) => {
    //     console.log(result);
    // })

    return data;
}


fetchData()
    .then((data) => {
        console.log(data);
    })

console.log(`async await 비동기 요청 처리`);