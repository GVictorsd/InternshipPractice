export {}

type greetprops = {
    name: string
    num?: number
}

export const Parent = (props: greetprops) => {
    return (
        <div>
            <h1>Hello {props.name} {props.num}</h1>
        </div>
    )
}

export const Pr = (props: greetprops) => {
    return (
        <div>
            <h1>pr {props.name}</h1>
        </div>
    )
}