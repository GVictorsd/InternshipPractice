
import React from "react";

function ChildComp(props){
    return (
        <div>
            <button onClick={props.handler}>Button from child</button>
        </div>
    )
}

export default ChildComp;