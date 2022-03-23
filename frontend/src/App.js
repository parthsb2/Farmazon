import * as React from "react"
import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom"
import "./styles/main.scss"

import Login from "./components/login/Login"
import SignUp from "./components/signUp/SignUp"
import Products from "./components/productsList/ProductsList"
import ProductPage from "./components/productPage/ProductPage"
import Farm from "./components/farm/Farm"
import Cart from "./components/cart/Cart"
import CheckOut from "./components/checkOut/CheckOut"
import Confirmation from "./components/confirmation/Confirmation"
import EarnCredit from "./components/earnCredits/EarnCredit"
import Nav from "./components/nav/Nav"
import ConfirmationNav from "./components/confirmationNav/ConfirmationNav"
import CreditConfirmation from "./components/creditConfirmation/CreditConfirmation"
import AudioPlayer from "./components/audioPlayer/AudioPlayer"
import Footer from "./components/footer/Footer"

function App() {

  const [user, setUser] = React.useState(JSON.parse(localStorage.getItem("farmazonUser")) || "")
  const [userLoggedIn, setUserLoggedIn] = React.useState(false)
  const [userClickedSignOut, setUserClickedSignOut] = React.useState(false)

  console.log(user)

  React.useEffect(() => {
    if (user === "") {
      localStorage.setItem("farmazonUser", JSON.stringify(""))
      localStorage.setItem("farmazonUserId", JSON.stringify(""))

    } else if (user === "login") {
      localStorage.setItem("farmazonUser", JSON.stringify("login"))
      localStorage.setItem("farmazonUserId", JSON.stringify(""))
    } else if (user === undefined) {
      localStorage.setItem("farmazonUser", JSON.stringify("login"))
      localStorage.setItem("farmazonUserId", JSON.stringify(""))
    } else {
      console.log("HIT THE LAST IF APP.js")
      localStorage.setItem("farmazonUser", JSON.stringify(user))
      localStorage.setItem("farmazonUserId", JSON.stringify(user.id))
    }
  }, [user])

  return (

    <BrowserRouter>

      {/* {user !== "" && user !== "login" && user !== undefined ? <Nav passedUser={user} setPassedUser={setUser} userClickedSignOut={userClickedSignOut} setUserClickedSignOut={setUserClickedSignOut}/> : console.log("user empty")} */}
      <Switch>
        <Route exact path="/">
          {user === ""
            ? <SignUp setUser={setUser} />
            : userLoggedIn === false || user === undefined
              ? <Login setUser={setUser} setUserLoggedIn={setUserLoggedIn} userLoggedIn={userLoggedIn} />
              : <Redirect to="/products" />
          }
          
        </Route>

        <Route path="/products">
          {user !== "" && user !== "login" && user !== undefined ? <Nav passedUser={user} setPassedUser={setUser} userClickedSignOut={userClickedSignOut} setUserClickedSignOut={setUserClickedSignOut} /> : console.log("user empty")}
          <Products />
          
        </Route>

        {/* <Route exact path="/product/:productId" component={ProductPage} /> */}
        {/* <Route exact path="/farm/:userId" component={Farm} /> */}

        <Route path="/product/:productId">
          {user !== "" && user !== "login" && user !== undefined ? <Nav passedUser={user} setPassedUser={setUser} userClickedSignOut={userClickedSignOut} setUserClickedSignOut={setUserClickedSignOut} /> : console.log("user empty")}
          <ProductPage />
        </Route>

        <Route path="/farm/:userId">
          {user !== "" && user !== "login" && user !== undefined ? <Nav passedUser={user} setPassedUser={setUser} userClickedSignOut={userClickedSignOut} setUserClickedSignOut={setUserClickedSignOut} /> : console.log("user empty")}
          <Farm />
          <Footer />
        </Route>

        {/* <Route exact path="/cart/:cartId" component={Cart} userId={user.id}/> */}
        <Route path="/cart/:cartId">
          {user !== "" && user !== "login" && user !== undefined ? <Nav passedUser={user} setPassedUser={setUser} userClickedSignOut={userClickedSignOut} setUserClickedSignOut={setUserClickedSignOut} /> : console.log("user empty")}
          <Cart userId={user.id} />
        </Route>

        {/* <Route exact path="/checkout/:cartId" component={CheckOut}/> */}
        <Route path="/checkout/:cartId">
          {user !== "" && user !== "login" && user !== undefined ? <Nav passedUser={user} setPassedUser={setUser} userClickedSignOut={userClickedSignOut} setUserClickedSignOut={setUserClickedSignOut} /> : console.log("user empty")}
          <CheckOut setPassedUser={setUser} />
        </Route>

        {/* <Route exact path="/confirmation" component={Confirmation} /> */}
        <Route path="/confirmation">
          <ConfirmationNav />
          <Confirmation setPassedUser={setUser} />
        </Route>

        <Route path="/earncredit">
          {user !== "" && user !== "login" && user !== undefined ? <Nav passedUser={user} setPassedUser={setUser} userClickedSignOut={userClickedSignOut} setUserClickedSignOut={setUserClickedSignOut} /> : console.log("user empty")}
          <EarnCredit user={user} setUser={setUser} />
        </Route>
        {/* <Route exact path="/earncredit" component={EarnCredit} user={user} setUser={setUser} /> */}

        {/* <Route exact path="/confirmation" component={Confirmation} /> */}
        <Route path="/creditconfirmation">
          <ConfirmationNav />
          <CreditConfirmation setUser={setUser} />
        </Route>

      </Switch>
      {user !== "" && user !== "login" && user !== undefined ? <AudioPlayer /> : console.log("audio not yet playing")}
      <Footer />
    </BrowserRouter>
  )
}

export default App
