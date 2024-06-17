import React, { useState } from 'react'
import Read from '../component/board/Read'
import * as boards from '../apis/boards'
import { useEffect } from 'react'

const ReadContainer = ({ no }) => {

  // state
  const [board, setBoard] = useState({})
  const [isLoading, setLoading] = useState(false);

  // 함수
  const getBoard = async () => {
    // 🕕 로딩 시작
    setLoading(true);
    const response = await boards.select(no); 
    const data = await response.data; // board
    console.log(data);
    setBoard(data);
    // 🕕 로딩 끝
    setLoading(false);
  }

  // hook
  useEffect(() => {
    getBoard()
  }, []);

  return (
    <>
      {/* 게시글 조회 */}
      <Read no={no} board={board} isLoading={isLoading}/>
    </>
  )
}

export default ReadContainer