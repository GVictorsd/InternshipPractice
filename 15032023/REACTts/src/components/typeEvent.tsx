import React from "react"

type typeeventprop = {
    value: string
    handlechange: (event: React.ChangeEvent<HTMLInputElement>) => void
}

export const TypeEvent = (props: typeeventprop) => {
    return (
        <div>
            <input type="text"  onChange= {props.handlechange}/>
        </div>
    )
}