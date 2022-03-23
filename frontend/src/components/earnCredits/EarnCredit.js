import React from "react"
import { Redirect } from "react-router-dom"
import "./earnCredits.scss"




function EarnCredit() {

  const [user, setUser] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")))
  const [newCredits, setNewCredits] = React.useState(0)
  const [creditAdded, setCreditAdded] = React.useState(false)
  console.log(user)


  React.useEffect(() => {
    fetch(`http://localhost:8080/users/${user.id}`)
      .then(resp => resp.json())
      .then(data => {
        setUser(data)
      })
  }, [])


  React.useEffect(() => {
    const requestOptions = {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: newCredits,
    }
    fetch(`http://localhost:8080/users/${user.id}/changecredit`, requestOptions)
      .then(response => response.json())
      .then(data => {
        console.log("fetch is working")
        localStorage.setItem("farmazonUser", JSON.stringify(data))
        setUser(data)
      })
  }, [newCredits])

  function handleCredits(e) {
    
    setNewCredits(parseInt(e.target.value))
    setCreditAdded(true)
  }




  return <>
    <div className="earnCredits-body">
      <h1 className="earn-credits-heading">Earn Credits 👩‍🌾</h1>
      <div className="box-credits">
        <div className="box-info">
          <h3>Sell Milk 🥛</h3>
          <h3>Earn: 10💰</h3>
        </div>
        <button value="10" className="button-earn-credits" onClick={handleCredits}>Collect</button>
      </div>
      <div className="box-credits">
        <div className="box-info">
          <h3>Harvest Crops 🌽</h3>
          <h3>Earn: 50💰</h3>
        </div>
        <button value="50" className="button-earn-credits" onClick={handleCredits}>Collect</button>
      </div>
      <div className="box-credits">
        <div className="box-info">
          <h3>Sell at farmers market 🛍️</h3>
          <h3>Earn: 100💰</h3>
        </div>
        <button value="100" className="button-earn-credits" onClick={handleCredits}>Collect</button> 
      </div>
      <div className="box-credits">
        <div className="box-info">
          <h3>Seedy dealings... 🤝💼👀</h3>
          <h3>Earn: 10000💰</h3>
        </div>
        <button value="10000" className="button-earn-credits" onClick={handleCredits}>Collect</button>
      </div>

    </div>
    {user === "" ? <Redirect push to="/" /> : console.log("user not logged in yet")}
    {creditAdded === true ? <Redirect push to="/creditconfirmation" /> : console.log("Credit not added yet")  }
  </>
}

export default EarnCredit



