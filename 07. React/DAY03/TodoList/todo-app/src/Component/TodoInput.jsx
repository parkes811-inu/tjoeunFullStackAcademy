import React from 'react'

const TodoInput = ( {onSubmit, input, onChange } ) => {
  return (
    <div>
        <form action="" className='form' onSubmit={onSubmit}>
            <input type="text" value={input} placeholder='할 일을 입력해주세요.' 
                    className='input' onChange={onChange} />
            <button type="submit" className='btn'>추가</button>
        </form>
    </div>
  )
}

export default TodoInput