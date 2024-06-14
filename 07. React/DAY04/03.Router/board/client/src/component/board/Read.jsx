import React from 'react'
import { Link, useParams } from 'react-router-dom'

const Read = () => {
  //  useParams(); 경로의 파라미터를 가져오는 Hook
  // <Route path="/경로:param" elements={ <component/> }> </Route>
  // const { param } = useParams()
  const { no } = useParams();

  return (
    <>
      <h1>게시글 조회</h1>
      <h3>번호 : {no}</h3>
      <Link to="/board">게시글 목록</Link>
      <hr />
      <Link to={`/board/update/${no}`}>게시글 수정</Link>
    </>
  )
}

export default Read