import React from "react"
import { Link, Redirect } from "react-router-dom"
import "./checkOut.scss"
import Emoji from "../emoji/Emoji"

function CheckOut({ setPassedUser }) {
  const [user, setUser] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")) || "")


  React.useEffect(() => {
    fetch(`http://localhost:8080/users/${user.id}`)
      .then(resp => resp.json())
      .then(data => {
        setUser(data)
      })
  }, [])

  function success() {

    const requestOptions = {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: -totalToSpend,
    }
    fetch(`http://localhost:8080/users/${user.id}/changecredit`, requestOptions)
      .then(response => response.json())
      .then(data => {
        console.log("fetch is working")
        localStorage.setItem("farmazonUser", JSON.stringify(data))
        setUser(data)
        setPassedUser(data)
      })
    const requestOptions1 = {
      method: "PUT",
    }
    fetch(`http://localhost:8080/checkout/${user.id}/`, requestOptions1)
      .then(response => response.json())
      .then(data => {
        console.log("cleared cart - not bought")
        localStorage.setItem("farmazonUser", JSON.stringify(data))
        setUser(data)
        setPassedUser(data)
      })
  }

  const productLinesToBuy = user.productLines.filter(element => {
    return element.inCart === true
  })
  const totalToSpend = productLinesToBuy.reduce((acc, line) => {
    return acc + line.totalPrice
  }, 0)
  const totalAnimals = productLinesToBuy.reduce((acc, line) => {
    return acc + line.quantity
  }, 0)
  const total = user.credit
  console.log(productLinesToBuy.length)
  return (
    <div className="checkout-main">
      <div className="cout-cow-column">
        <figure className="image image-is-1by1">
          <div className="emoji">
            <Emoji className="emoji" symbol={"💰"} />
          </div>
          <div className="emoji">
            <Emoji className="emoji" symbol={"🐮"} />
          </div>
          <div className="emoji">
            <Emoji className="emoji" symbol={"💰"} />
          </div>
        </figure>
      </div>
      <div className="checkout-central">
        <h1 className="cout-h1 title is-1">Checkout</h1>
        <div className="divider"></div>
        <h2 className="cout-h2">Number of products: {productLinesToBuy.length}</h2>
        <h2 className="cout-h2">Number of animals: {totalAnimals}</h2>
        <h2 className="cout-h2">Total: {totalToSpend}💰</h2>
        <h2 className="cout-h2">{user.username} Credits: {total}💰</h2>
        <h2 className="cout-h2">Credits after Transaction: {total - totalToSpend}💰</h2>
        {total - totalToSpend < 0 ? <h3>You cant afford this! Go earn some credits 🤠</h3> : <Link to="/confirmation"><button className="button is-success cout-button is-large" onClick={success}>Purchase</button></Link>}
        <Link to={`/cart/${user.id}`}><button className={"button is-danger cout-button"}>Return to cart</button></Link>
        {user === "" ? <Redirect push to="/" /> : console.log("user not logged in yet")}
      </div>
      <div className="cout-cow-column">
        <figure className="image image-is-1by1">
          <div className="emoji">
            <Emoji className="emoji" symbol={"💰"} />
          </div>
          <div className="emoji">
            <Emoji className="emoji" symbol={"🐮"} />
          </div>
          <div className="emoji">
            <Emoji className="emoji" symbol={"💰"} />
          </div>
        </figure>
      </div>
      {user === "" ? <Redirect push to="/" /> : console.log("user not logged in yet") }
    </div>
  )
}

export default CheckOut