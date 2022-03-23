import React from "react"
import { useParams, Redirect } from "react-router-dom"
import Emoji from "../emoji/Emoji"
import "./productPage.scss"

function ProductPage() {

  const [product, setProduct] = React.useState({})
  const { productId } = useParams()
  const [userId] = React.useState(JSON.parse(localStorage.getItem("farmazonUserId")))
  const [user] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")) || "")
  const [emoji, setEmoji] = React.useState("")
  const [ productAddedToCart, setProductAddedToCart ] = React.useState(false)

  console.log(productId)

  React.useEffect(() => {
    fetch(`http://localhost:8080/products/${productId}`)
      .then(resp => resp.json())
      .then(data => setProduct(data))
  }, [productId])

  console.log(product)

  const [quantity, setQuantity] = React.useState(1)


  function handleCart() {
    console.log(userId)
    console.log(quantity)

    fetch(`http://localhost:8080/product/${productId}/newlinetocart`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        quantity: quantity,
        userId: userId,
      }),
    })
      .then((resp) => resp.json())
      .then((user) => {

        console.log(user)
        setProductAddedToCart(true)
      })
  }

  function handlePlus() {
    setQuantity(quantity + 1)
  }

  function handleMinus() {
    if (quantity > 1) {
      setQuantity(quantity - 1)
    }
  }

  React.useEffect(() => {
    if (product.emoji !== undefined) {
      setEmoji(product.emoji.replace(/&#/g, "").replace(/;/g, "").toString(16))
    }

  }, [product])


  console.log(product.region)

  return (
    product.region !== undefined ?

      <div className="product-page-body">
        <div className="product-page-container">


          <div className="product-page-title-container" >
            <h2 className="title is-1" id="product-page-title ">
              {product.name}
            </h2>
            <div className="divider"></div>
          </div>


          <div className="product-page-image-and-information-container">
            <div className="products-page-emoji">
              {product.name.includes("Farmer") ? <img src={require(`../../images/${product.emoji}.png`).default} /> : <Emoji symbol={String.fromCodePoint(emoji)} label={product.name} />}
            </div>
            <div className="product-page-information" >

              <label className="product-information-label" htmlFor="description">Description</label>
              <h3 className="product-page-description" id="description">
                {product.description}
              </h3>

              <label className="product-information-label" htmlFor="company">Company</label>
              <h3 className="product-page-company" id="company" >
                {product.company}
              </h3>
              <label className="product-information-label" htmlFor="region">Region</label>
              <h3 className="product-page-region" id="region" >
                {product.region.charAt(0).toUpperCase() + product.region.substring(1)}
              </h3>


            </div>

          </div>


          <div className="product-page-functions-container">
            <div className="divider under"></div>
            <div className="product-page-price-and-buttons">

              <div className="price-container">
                <label className="product-information-label" htmlFor="price">Price</label>
                <h3 className="product-page-price" id="rating" >
                  {product.price + "💰"}
                </h3>
              </div>

              <div className="rating-container">
                <label className="product-information-label" htmlFor="rating">Rating</label>
                <h3 className="product-page-rating" id="rating" >
                  {product.rating}/10 {product.rating === 10 ? "⭐" : product.rating > 8 ? "🔥" : product.rating > 6 ? "💖" : product.rating >= 4 ? "👍" : "🤢"}
                </h3>
              </div>

              <div className="button-container">
                <div className="quantity-adjustment-container">
                  <button className="button is-danger" id="quantity-button-minus" onClick={handleMinus}>-</button>
                  <input className="quantity-input" value={quantity}></input>
                  <button className="button is-success" id="quantity-button-add" onClick={handlePlus}>+</button>
                </div>
                <button className="button is-link" id="add-to-cart" onClick={handleCart}>Add to Cart</button>

              </div>

            </div>

          </div>


          {user === "" ? <Redirect push to="/" /> : console.log("user not logged in yet")}
        </div>
        { productAddedToCart === true ? <Redirect push to="/products" /> : console.log("user not logged in yet")  }
      </div>

      : <p>loading</p>
  
    
  )
}

export default ProductPage