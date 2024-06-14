import logo from './logo.svg';
import './App.css';
import React, { createElement } from 'react';

// class App extends React.Component {

//   render() { 
//     const link = React.createElement('a', {
//       href: 'http://www.google.com',
//       target: '_blank',
//       style: { color: 'blue' }
//     }, '구글 사이트');

//     // JSX 로 엘리먼트 생성
//     const element2 = (
//       <div>
//         <h1>JSX 엘리먼트</h1>
//         <a href="https://www.google.com"
//            target='_blank'
//            style={{color: 'red'}}
//            >구글 사이트</a>
//       </div>
//     );
//     // const box = createElement('div', null, 
//     //   [link, box]
//     // )
//     return element2;
//   }
// }

function App() {
  return (
    // 프래그먼트
    <>
      <div>
        <h1>JSX 엘리먼트</h1>
        <a href='https://www.google.com'
           target='_blank'
           style={{color: 'red'}}>
          구글 사이트
        </a>
      </div>
    </>
  );
}

export default App;
