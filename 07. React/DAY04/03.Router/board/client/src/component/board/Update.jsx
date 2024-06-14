import React from 'react'
import { Link, useParams } from 'react-router-dom'

const Update = () => {
  const { no } = useParams()

  return (
    <>
      <h1>게시글 수정</h1>
      <h3>번호 : {no}</h3>

      <Link to="/board">목록</Link>
    </>
  )
}

export default Update