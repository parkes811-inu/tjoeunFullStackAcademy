import React from 'react'
import Header from '../components/Header/Header'
import LoginContextConsumer from '../contexts/LoginContextConsumer'
import LoginForm from '../components/Login/LoginForm'

const Login = () => {
  return (
    <>
        <Header />
        <div className='container'>
            <h1>Login</h1>
            <hr/>
            <h2>로그인 페이지</h2>
            <LoginForm />
        </div>
    </>
  )
}

export default Login