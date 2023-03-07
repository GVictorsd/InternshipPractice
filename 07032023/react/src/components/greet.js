
import React from "react";

function Greet(props){
    console.log(props)
    return (
        <div>
            <h1> Hello {props.name} </h1>
            {props.children}
        </div>
    ) 
}

export default Greet;