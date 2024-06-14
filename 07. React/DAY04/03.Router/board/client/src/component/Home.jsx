import React from 'react'
import { Link } from 'react-router-dom'

const Home = () => {
  return (
    <>
      <h1>HOME</h1>
      <Link to="/board">게시판</Link>
    </>
  )
}

export default Home