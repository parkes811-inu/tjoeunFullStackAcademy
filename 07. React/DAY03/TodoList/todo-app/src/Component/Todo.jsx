import React from 'react'

const Todo = ({todo}) => {
  return (
    <div className='card'>
        <h1>{todo.name}</h1>
        <p>{todo.status}</p>
    </div>
  )
}

export default Todo