import { Component, ReactNode } from "react"


type textchildprop = {
    children: string
}

export const Textchild = (props: textchildprop) => {
    return <h1>{props.children} </h1>
}

// export default class Textchild extends Component{
//     render():ReactNode{
//         return (
//             <h1>
//                 {this.props.children}
//             </h1>
//         )
//     }
// }

type objchildprop = {
    name: {
        first: string
        last: string
    }
    age?: number
}

export const Objchild = (props: objchildprop) => {
    return <h1> {props.name.first} {props.name.last} {props.age} </h1>
}


type arrchildprop = {
    person: {
        name: string
    }[]
}
export const Arrchild = (props: arrchildprop) => {
    return <h1>{props.person[2].name}</h1>
}