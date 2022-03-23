import React from "react"
import "./audioPlayer.scss"
import url from "../../music/farm_music.mp3"


// function useAudio(url){
//   const [audio] = React.useState(new Audio(url))
//   const [playing, setPlaying] = React.useState(false)

//   function toggle(){
//   setPlaying(!playing)
//   } 

//   React.useEffect(() => {
//     playing ? audio.play() : audio.pause()
//   },[playing])

//   React.useEffect(() => {
//     audio.addEventListener("ended", () => setPlaying(false))
//     return () => {
//       audio.removeEventListener("ended", () => setPlaying(false))
//     }
//   }, [])

//   return [playing, toggle]
// }

// function AudioPlayer(){
//   const [playing, toggle] = useAudio(url)

//   return (
//     <div className="music-player">
//       <p onClick={toggle}>{playing ? "⏹" : "▶"}</p>
//     </div>
//   )
// }



function AudioPlayer() {
  console.log("Audio player called, url = ", url)

  return <div className="audio-container"><audio id="audio-tag" className="audio-center" src={url} autoPlay loop controls/></div>

  
}

export default AudioPlayer