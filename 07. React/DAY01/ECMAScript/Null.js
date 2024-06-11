let input;
const nickname = input ?? '박은서' // NULL 병합
// const nickname = input; 

console.log(`이름 : ${nickname}`);

if(nickname) {
    console.log('이름이 있습니다');
}

if(!nickname) {
    console.log('이름이 없습니다');
}