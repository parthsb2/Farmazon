import { Link, Redirect } from "react-router-dom"
import React from "react"

//! LOGOS OPTIONS
//https://i.ibb.co/2KZdSZq/farmazon-black-text.png 
//https://i.ibb.co/sWJKXGD/farmazon-coloured.png
//https://i.ibb.co/7XG8NMY/farmazon-white-text.png

function Nav({ setUserClickedSignOut, userClickedSignOut, passedUser, setPassedUser }) {

  // const [user, setUser] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")))
  // React.useEffect(() => {
  //   console.log(userId, "USER ID BEFORE SET")
  //   setUserId(JSON.parse(localStorage.getItem("farmazonUserId")))
  //   console.log(userId, "USER ID AFTER SET")

  // }, [userId])
  const [user, setUser] = React.useState("")
  const [isActive, setIsActive] = React.useState(false)

  React.useEffect(() => {
    fetch(`http://localhost:8080/users/${passedUser.id}`)
      .then(resp => resp.json())
      .then(data => {
        setUser(data)
      })
  }, [])

  console.log(user, "OUTSIDE REACT EFFECT")

  function handleClick() {
    setPassedUser("")
    setUserClickedSignOut(true)
    window.location.reload()
  }

  console.log(userClickedSignOut, "USER CLICKED SIGN OUT")

  return (user.id === undefined ? <p> loading... </p> :
    <nav className="navbar" role="navigation" aria-label="main navigation">
      <div className="container">
        <div className="navbar-brand">
          <Link className="navbar-item" to="/products">
            <img src="https://i.ibb.co/sWJKXGD/farmazon-coloured.png" width="202px" height="48.33px" />
          </Link>


          <a onClick={() => setIsActive(!isActive)} role="button" className="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>

        <div id="navbarBasicExample" className={`navbar-menu ${isActive ? "is-active" : ""}`}>
          <div className="navbar-start">

            <Link className="navbar-item" onClick={() => setIsActive(!isActive)} to="/earncredit">{user.credit}💰</Link>
            <Link className="navbar-item" onClick={() => setIsActive(!isActive)} to="/products">Products</Link>
            <Link className="navbar-item" onClick={() => setIsActive(!isActive)} to={`/farm/${user.id}`}>{user.farmName}</Link>


          </div>



          <div className="navbar-end">
            <div className="navbar-item">

              <div className="buttons">
                <Link className="button is-success" onClick={() => setIsActive(!isActive)} to={`/cart/${user.id}`}>🛒</Link>
                <a className="button is-dark" onClick={handleClick}><strong>Sign Out</strong></a>
              </div>
            </div>
          </div>

        </div>
      </div>
      {passedUser.id === "" ? <Redirect push to="/" /> : console.log("user not logged in yet")}
    </nav>

  )
}

export default Nav