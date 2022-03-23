import "./farm.scss"
import FarmEmoji from "../emoji/FarmEmoji"
import { Redirect } from "react-router-dom"
import React from "react"

function Farm() {

  const [user, setUser] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")))
  const [filteredUserLines, setFilteredUserLines] = React.useState([])
  const [fieldAnimals, setFieldAnimals] = React.useState([])
  const [waterAnimals, setWaterAnimals] = React.useState([])
  const [desertAnimals, setDesertAnimals] = React.useState([])
  const [airAnimals, setAirAnimals] = React.useState([])
  const [mysticalAnimals, setMysticalAnimals] = React.useState([])

  const fieldEmojis = fieldAnimals.map(line => {
    let emoji
    const quantity = line.quantity
    if (line.product.emoji !== undefined) {      
      
      line.product.emoji.includes("emoji") ? emoji = line.product.emoji : emoji = line.product.emoji.replace(/&#/g, "").replace(/;/g, "").toString(16)
      
    }
    return Array(quantity).fill(emoji.includes("emoji") ? emoji : String.fromCodePoint(emoji))
  }).flat()

  const waterEmojis = waterAnimals.map(line => {
    let emoji
    const quantity = line.quantity
    if (line.product.emoji !== undefined) {      
      
      line.product.emoji.includes("emoji") ? emoji = line.product.emoji : emoji = line.product.emoji.replace(/&#/g, "").replace(/;/g, "").toString(16)
      
    }
    return Array(quantity).fill(emoji.includes("emoji") ? emoji : String.fromCodePoint(emoji))
  }).flat()

  const desertEmojis = desertAnimals.map(line => {
    let emoji
    const quantity = line.quantity
    if (line.product.emoji !== undefined) {      
      
      line.product.emoji.includes("emoji") ? emoji = line.product.emoji : emoji = line.product.emoji.replace(/&#/g, "").replace(/;/g, "").toString(16)
      
    }
    return Array(quantity).fill(emoji.includes("emoji") ? emoji : String.fromCodePoint(emoji))
  }).flat()

  const airEmojis = airAnimals.map(line => {
    let emoji
    const quantity = line.quantity
    if (line.product.emoji !== undefined) {      
      
      line.product.emoji.includes("emoji") ? emoji = line.product.emoji : emoji = line.product.emoji.replace(/&#/g, "").replace(/;/g, "").toString(16)
      
    }
    return Array(quantity).fill(emoji.includes("emoji") ? emoji : String.fromCodePoint(emoji))
  }).flat()

  const mysticalEmojis = mysticalAnimals.map(line => {
    let emoji
    const quantity = line.quantity
    
    if (line.product.emoji !== undefined) {      
      
      line.product.emoji.includes("emoji") ? emoji = line.product.emoji : emoji = line.product.emoji.replace(/&#/g, "").replace(/;/g, "").toString(16)
    }
    return Array(quantity).fill(emoji.includes("emoji") ? emoji : String.fromCodePoint(emoji))
  }).flat()


  React.useEffect(() => {
    fetch(`http://localhost:8080/users/${user.id}`)
      .then(resp => resp.json())
      .then(data => {
        setUser(data)
      })
  }, [])

  React.useEffect(() => {
    if (user !== "") {
      setFilteredUserLines(user.productLines.filter(line => line.inCart === false))
    }
  }, [user])


  console.log("User Lines -----", user.productLines)
  console.log("Filtered Lines -----", filteredUserLines)

  function filterRegion(region) {
    return filteredUserLines.filter(line => line.product.region === region)
  }

  React.useEffect(() => {
    setFieldAnimals(filterRegion("field"))
    setDesertAnimals(filterRegion("desert"))
    setAirAnimals(filterRegion("air"))
    setWaterAnimals(filterRegion("water"))
    setMysticalAnimals(filterRegion("mystical"))
  }, [filteredUserLines])

  console.log("Field --", fieldAnimals)
  console.log("Water --", waterAnimals)
  console.log("Air --", airAnimals)

  return <>
    <div className="main">
      <div className="sky">
        <div className="cloud">☁️</div>
        <div className="cloud1">☁️</div>
        <div className="cloud2">☁️</div>
        <div className="sun">🌞</div>
        <div className="mountain">⛰️</div>
        <div className="mountain1">⛰️</div>
        <div className="mountain2">⛰️</div>
        {airEmojis.map((emoji, i) => {
          const randWidth = Math.random() * 80 + 10
          const randHeight = Math.random() * 80 + 10
          return emoji.includes("emoji") ? <img src={require(`../../images/${emoji}.png`).default} style={{ width: "50px", height: "50px", position: "absolute", top: `${randHeight}%` , left: `${randWidth}%`  }} /> : <FarmEmoji className="farm-emoji" symbol={emoji} key={i} top={randHeight + "%"} left={randWidth + "%"} />

        })}
      </div>
      <div className="land">
        <div className="grass">
          <div className="house">🏠</div>
          <div className="tree">🌳</div>
          <div className="tree1">🌲</div>
          <div className="tree2">🌳</div>
          <div className="tree3">🌲</div>
          {fieldEmojis.map((emoji, i) => {
            const randWidth = Math.random() * 80 + 10
            const randHeight = Math.random() * 80 + 10
            return emoji.includes("emoji") ? <img src={require(`../../images/${emoji}.png`).default} style={{ width: "50px", height: "50px", position: "absolute", top: `${randHeight}%` , left: `${randWidth}%`  }}  /> : <FarmEmoji className="farm-emoji" symbol={emoji} key={i} top={randHeight + "%"} left={randWidth + "%"} />
          })}

        </div>
        <div className="desert">
          <div className="palm">🌴</div>
          <div className="palm1">🌴</div>
          <div className="palm2">🌴</div>
          <div className="oasis"></div>
          <div className="cactus">🌵</div>
          <div className="cactus1">🌵</div>

          {desertEmojis.map((emoji, i) => {
            const randWidth = Math.random() * 80 + 10
            const randHeight = Math.random() * 80 + 10
            return emoji.includes("emoji") ? <img src={require(`../../images/${emoji}.png`).default} style={{ width: "50px", height: "50px", position: "absolute", top: `${randHeight}%` , left: `${randWidth}%`  }}  /> : <FarmEmoji className="farm-emoji" symbol={emoji} key={i} top={randHeight + "%"} left={randWidth + "%"} />
          })}
        </div>
      </div>
      <div className="water">
        <div className="boat">⛵</div>
        {waterEmojis.map((emoji, i) => {
          const randWidth = Math.random() * 80 + 10
          const randHeight = Math.random() * 80 + 10
          return emoji.includes("emoji") ? <img src={require(`../../images/${emoji}.png`).default} style={{ width: "50px", height: "50px", position: "absolute", top: `${randHeight}%` , left: `${randWidth}%`  }}  /> : <FarmEmoji className="farm-emoji" symbol={emoji} key={i} top={randHeight + "%"} left={randWidth + "%"} />
        })}
      </div>
      {mysticalEmojis.map((emoji, i) => {
        const randWidth = Math.random() * 80 + 10
        const randHeight = Math.random() * 80 + 10
        return emoji.includes("emoji") ? <img src={require(`../../images/${emoji}.png`).default} style={{ width: "50px", height: "50px", position: "absolute", top: `${randHeight}%` , left: `${randWidth}%`  }}  /> : <FarmEmoji className="farm-emoji" symbol={emoji} key={i} top={randHeight + "%"} left={randWidth + "%"} />
      })}
    </div>

    {user === "" ? <Redirect push to="/" /> : console.log("user is logged in")}
  </>
}

export default Farm