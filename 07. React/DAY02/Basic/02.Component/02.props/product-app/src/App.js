import logo from './logo.svg';
import './App.css';
import ProductDetail from './component/ProductDetail';

function App() {
  const product = {
    productId : 'P000001',
    name : '360도 회전 선풍기',
    price : 5000,
    quantity : 1,
    img : 'https://i.imgur.com/1vpSkbW.png'
  };

  return (
    <>
      <ProductDetail product={product} />
    </>
  );
}

export default App;
