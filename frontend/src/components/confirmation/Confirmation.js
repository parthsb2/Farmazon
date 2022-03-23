import React from "react"
import { Link, Redirect } from "react-router-dom"
import "./confirmation.scss"
import Emoji from "../emoji/Emoji"
import Confetti from "react-confetti"

function Confirmation() {
  const [user, setUser] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")) || "")

  React.useEffect(() => {
    fetch(`http://localhost:8080/users/${user.id}`)
      .then(resp => resp.json())
      .then(data => {
        localStorage.setItem("farmazonUser", JSON.stringify(data))
        setUser(data)
      })
  }, [])

  return <>
    <Confetti />
    <div className="confirmation-main">
      <div className="conf-cow-column">
        <figure className="image image-is-1by1">
          <div className="emoji">
            <Emoji className="emoji" symbol={"🐮"} />
          </div>
        </figure>
      </div>
      <div className="confirmation-central">
        <h1 className="conf-h1">Thank you for your order farmer!</h1>
        <h2 className="conf-h2">Your new animals should arrive at your farm soon!</h2>
        <Link to={`/farm/${user.id}`}><button className="button conf-button">Go to your Farm</button></Link>
        <Link to="/products"><button className="button conf-button">Back to products</button></Link>
        
      </div>
      <div className="conf-cow-column">
        <figure className="image image-is-1by1">
          <div className="emoji">
            <Emoji className="emoji" symbol={"🐮"} />
          </div>
        </figure>
      </div>
    </div>
    {user === "" ? <Redirect push to="/" /> : console.log("user not logged in yet") }
  </>
}

export default Confirmation
