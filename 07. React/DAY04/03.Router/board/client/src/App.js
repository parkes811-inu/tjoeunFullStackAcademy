import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './component/Home';
import List from './component/board/List';
import Read from './component/board/Read';
import Update from './component/board/Update';
import Insert from './component/board/Insert';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={ <Home/> }></Route>
        <Route path='/board' element={ <List/> }></Route>
        <Route path='/board/:no' element={ <Read/> }></Route>
        <Route path='/board/insert' element={ <Insert/> }></Route>
        <Route path='/board/update/:no' element={ <Update/> }></Route>
      </Routes>
    </BrowserRouter>
  );

}
export default App;
