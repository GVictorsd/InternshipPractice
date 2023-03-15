import React from "react"

type Eventproptype = {
    clickhandler : (event: React.MouseEvent<HTMLButtonElement>) => void
    children: string
}

export const Eventprop = (props: Eventproptype) => {
    return(
        <div>
            <button onClick={props.clickhandler}>Click</button>
            <h2>{props.children}</h2>
        </div>

    ) 
}