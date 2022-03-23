import { Link } from "react-router-dom"
import Emoji from "../emoji/Emoji"
import React from "react"
import "./productCard.scss"

function ProductCard({ id, name, region, price, emoji, parsedEmoji, handleFavourite, isFavourite }) {
  
  return (
    <div className="column is-one-fifth-desktop is-one-quarter-tablet">
      <div className="card box-shadow">
        <div className="card-header">
          <div className="card-header-title">{name}</div>
        </div>
        <div className="card-footer" id="region-container">
          <div className="card-footer-item">
            <p className="has-text-weight-bold"> {region.charAt(0).toUpperCase() + region.substring(1) } </p>
          </div>
          <div className="card-footer-item">
            <p className="has-text-weight-bold"> {price}💰</p>
          </div>
          

        </div>
        <div className="card-image">
          <figure className="image image-is-1by1">
            <div className="card-emoji">
              {name.includes("Farmer") ? <img src={require(`../../images/${emoji}.png`).default} style={{ height: "225px", width: "auto", margin: "auto" }} /> : <Emoji className="emoji" symbol={String.fromCodePoint(parsedEmoji)} /> }
            </div>
          </figure>
        </div>
        
        <div className="card-footer" id="card-buttons">
          <p className="card-footer-item" onClick={() => handleFavourite(id)}>{!isFavourite ? <a>😐</a> : <a>😍</a>}</p>
          <p className="card-footer-item"><Link to={`/product/${id}`}>📚</Link></p>

        </div>
      </div>
    </div>
  )
}

export default ProductCard
