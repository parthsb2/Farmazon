import React from "react"

//! LOGOS OPTIONS
//https://i.ibb.co/2KZdSZq/farmazon-black-text.png 
//https://i.ibb.co/sWJKXGD/farmazon-coloured.png
//https://i.ibb.co/7XG8NMY/farmazon-white-text.png

function confirmationNav() {

  return (
    <nav className="navbar" role="navigation" aria-label="main navigation">
      <div className="container">
        <a className="navbar-item center" id="conf-navbar" href="http://localhost:3000/products">
          <img id="conf-navbar-img"src="https://i.ibb.co/sWJKXGD/farmazon-coloured.png" width="303px" height="72.5px" />
        </a>
      </div>
    </nav>
  )
}

export default confirmationNav