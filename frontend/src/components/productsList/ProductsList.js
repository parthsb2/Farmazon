import React from "react"
import { Redirect } from "react-router-dom"
import ProductCard from "../productCard/ProductCard"
import "./productsList.scss"


function Products() {

  const [products, setProducts] = React.useState([])
  const [favourites, setFavourites] = React.useState(JSON.parse(localStorage.getItem("farmazonfavourites")) || [])
  const [select, updateSelect] = React.useState("")
  const [search, updateSearch] = React.useState("")
  const [isOnlyFavourites, setIsOnlyFavourites] = React.useState(false)
  const [user, setUser] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")))
  let parsedEmoji


  React.useEffect(() => {
    fetch("http://localhost:8080/products")
      .then(resp => resp.json())
      .then(data => {
        setProducts(data)
      })
  }, [])

  React.useEffect(() => {
    setUser(JSON.parse(localStorage.getItem("farmazonUser")))
  }, [])

  function handleFavourite(id) {
    const newFavourites = [...favourites]
    if (favourites.includes(id)) {
      const productsIndex = favourites.indexOf(id)
      newFavourites.splice(productsIndex, 1)
    } else {
      newFavourites.push(id)
    }
    setFavourites(newFavourites)
  }

  React.useEffect(() => {
    localStorage.setItem("farmazonfavourites", JSON.stringify(favourites))
  }, [favourites])

  function handleChangeSelect(event) {
    updateSelect(event.target.value)
  }

  function handleSearch(event) {
    updateSearch(event.target.value)
  }

  function handleClick() {
    setIsOnlyFavourites(!isOnlyFavourites)
    console.log(isOnlyFavourites)
  }

  function filterProducts() {
    if (isOnlyFavourites) {
      console.log(favourites.toString().toLowerCase())
      return products.filter(product => {
        return (product.name.toLowerCase().includes(search.toLowerCase()))
          && (select === "All" || product.region.toLowerCase().includes(select.toLowerCase()))
          && favourites.includes(product.id)
      })
    } else {
      return products.filter(product => {
        return (product.name.toString().toLowerCase().includes(search.toLowerCase()))
          && (select === "All" || product.region.toString().toLowerCase().includes(select.toLowerCase()))
      })
    }

  }

  return (products.length === 0 ? <p>Loading...</p> :
    <>
      <div className="section productsIndex">
        <div className="container">
          <div className="field has-addons" id="products-list-controls">
            <p className="control">
              <span className="select">
                <select onChange={handleChangeSelect} className="select" >
                  <option>All</option>
                  <option>Field</option>
                  <option>Desert</option>
                  <option>Air</option>
                  <option>Water</option>
                  <option>Mystical</option>
                </select>
              </span>
            </p>
            <p className="control">
              <span id="show-only-favourites" className="input">
                <label > Show Only Favourites </label>
                <input id="fav-checkbox" type="checkbox" onClick={handleClick} />
              </span>
            </p>
            <p className="control is-expanded">
              <input
                className="input"
                placeholder="Search..."
                onChange={handleSearch}

              />
            </p>
          </div>
          <div className="columns is-multiline">
            {filterProducts().map((product) => {

              parsedEmoji = product.emoji.replace(/&#/g, "").replace(/;/g, "").toString(16)

              return (
                <ProductCard
                  key={product.id}
                  handleFavourite={handleFavourite}
                  isFavourite={favourites.includes(product.id)}
                  {...product}
                  parsedEmoji={parsedEmoji}
                />
              )
            })}
          </div>
        </div>
      </div>
      {user === "" ? <Redirect push to="/" /> : console.log("user not logged in yet") }
    </>
  )
}

export default Products
