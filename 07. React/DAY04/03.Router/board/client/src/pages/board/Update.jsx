import React from 'react'
import { useParams } from 'react-router-dom'
import UpdateContainer from '../../containers/UpdateContainer';

const Update = () => {
// 파라미터 가져오기
  const { no } = useParams();
  console.log(`no : ${no}`);
  return (
    <>
        {/* Header */}
        <UpdateContainer no={no} />
        {/* Footer */}  
    </>
  )
}

export default Update