import React from 'react'
import { Link, useParams } from 'react-router-dom'

const Insert = () => {
  return (
    <>
      <h1>게시글 쓰기</h1>
      
      <Link to="/board">목록</Link>
    </>
  )
}

export default Insert 