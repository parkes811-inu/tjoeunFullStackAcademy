import React from 'react'

// const Card = ({title, content}) => {
const Card = (props) => {
  return (
    <div className='card'>
        {/* <h3>{title}</h3>
        <p>{content}</p> */}
        <h3>{props.title}</h3>
        <p>{props.content}</p>
    </div>
  )
}

export default Card