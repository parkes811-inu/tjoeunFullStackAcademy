import React from 'react'
import * as boards from '../apis/boards'
import { useNavigate } from 'react-router-dom';
import InsertForm from '../component/board/InsertForm';

const InsertContainer = () => {
  const navigate = useNavigate();
  // 🧊 state
  // 🌞 이벤트 함수
  // const onInsert = async (title, writer, content) => {
  const onInsert = async (formData, headers) => {
    try {
      // const response = await boards.insert(title, writer, content);
      const response = await boards.insert(formData, headers)
      const status = await response.status;
      console.log(`게시글 등록 요청 결과 : ${status}`);
      alert("게시글 등록 완료");

      // 게시글 목록으로 이동
      navigate("/boards")
    } catch (error) {
      console.log(error);
    }  
  }
  return (
    <>
        <InsertForm onInsert={onInsert}/>
    </>  
  )
}

export default InsertContainer