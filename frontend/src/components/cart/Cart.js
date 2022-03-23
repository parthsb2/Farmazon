import ProductLineCard from "../productLineCard/ProductLineCard"
import React from "react"
import { Redirect, Link } from "react-router-dom"
import "./cart.scss"

function Cart() {

  const [productLines, setProductLines] = React.useState([])
  const [productLinesInCart, setProductLinesInCart] = React.useState([])
  // const [userId] = React.useState(JSON.parse(localStorage.getItem("farmazonUserId")))
  const [user, setUser] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")))
  let parsedEmoji

  function clearCart(id) {
    fetch(`http://localhost:8080/deleteproductlinebyid/${id}`, {
      method: "DELETE",
    })
  }

  function onClear() {
    productLinesInCart.forEach(line => {
      clearCart(line.id)
    })
    window.location.reload()
  }
  

  React.useEffect(() => {
    fetch(`http://localhost:8080/users/${user.id}`)
      .then(resp => resp.json())
      .then(data => {
        setProductLines(data.productLines)
        setUser(data)
      })
  }, [])

  console.log(productLines, "PRODUCT LINES")

  React.useEffect(() => {
    console.log(productLines, "INSIDE USE EFFECT")
    const filteredProductLines = productLines.filter(productLine => productLine.inCart === true)
    setProductLinesInCart(filteredProductLines)

  }, [productLines])

  console.log(productLinesInCart, "PRODUCT LINES IN CART")

  return (
    <div className="cart-body">
      <div className="cart-heading-container">
        <h1 className="cart-heading title is-1" id="cart-heading">{user === "" ? console.log("user = empty string") : user.username.charAt(user.username.length - 1) === "s" ? user.username.toUpperCase() + "' " : user.username.toUpperCase() + "'S "}CART</h1>
        { productLinesInCart[0] !== undefined ? <div className="buttons">
          <button className="cart-checkout-button button is-danger is-right" onClick={onClear}>
            Clear cart
          </button>
          <Link to={`/checkout/${user.id}`}>
            <button className="cart-checkout-button button is-success">
              Checkout
            </button>
          </Link>
        </div> : console.log("hey")}
      </div>
      <div className="product-lines-in-cart-container">
        {productLinesInCart.map((productLine) => {

          parsedEmoji = productLine.product.emoji.replace(/&#/g, "").replace(/;/g, "").toString(16)

          return (
            <ProductLineCard
              key={productLine.id}
              {...productLine}
              parsedEmoji={parsedEmoji}
              {...productLinesInCart}
            />
          )
        })}
      </div>
      {productLinesInCart[0] === undefined ? <div className="container" id="cart-empty-container"><h3 className="title is-3"> Your cart is empty! Click below to go to the products page 😊 </h3><Link className="button is-primary" id="cart-head-to-products-button" push to="/products">Head to Products</Link></div> : <p></p>}


      {user === "" ? <Redirect push to="/" /> : console.log("user not logged in yet")}
    </div>






  )
}

export default Cart