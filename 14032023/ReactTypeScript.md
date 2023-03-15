# Typescript with React

## creating React App with typescript
```
npx create-react-app <appName> --template typescript
cd <appName>
npm start
```

## Typing props
```
type GreetProps = {
    name: string
    messageCount: number
    isloggedin: boolean
}

export const Greet = (props: GreetProps) => {
    ...
}



# Object typing
const propobj = {
  first: "alice",
  last: "ping"
}

<Objchild name={propobj} age = {6}/>

- USING
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




# passing arrays
const persons = [
    {first: ' ', last: ' '},
    {...},
    {...}
]

- using
type Person = {
    names: {
        first: string
        last: string
    }[]
}
function (props: Person){
    ...
    props.names.map(name => {
        return <h1 key = {name.first}>{name.first} {name.last} </h1>
    })
}
```

### Typing Children props

```
# simple string as child
<Heading> Simple Text </Heading>

type HeadingProp = {
    children: string
}

export const Heading= (props: HeadingProp) => {
    return <h2>{props.children}</h2>
}

# child is another react component
<Oscar>
    <Heading> simple Text </Heading>
</Oscar>

type Oscarprops = {
    children: React.ReactNode
}
function (props:Oscarprops)
```

### Typing Event Props
```
type ButtonProp = {
    handleClick: () => void
}
export const Button = (props: ButtonProp) => {
    return <button onClick={props.handleClick}>Click </button>
}

- using
<Button handleClick={() => {
    console.log('buttonclicked')
}}>

# incase of passing an event
type ButtonProps = {
    handleClick ; (event: React.MouseEvent<HTMLButtonElement>) => void
}

<Button onClick = {(event) => {...}}>
```

- Input
```
type InputProp = {
    value: string
    handleChange: (event : React.ChangeEvent<HTMLInputElement>) => void
}
Input = (props: InputProp) => {
    return <input type="text" value={props.value} onChange={props.handleChange}>
}

<Input value = '' handleChange={(event) => cosole.log(event)}>
```

### Style Props
```
type containerProp = {
    styles: React.CSSProperties
}
Container = (props: containerProp) => {
    return (
        <div style={props.style}>
    )
}

<Container styles=({border: "1px solid black", padding: '1rem'})>
```

### Moving props to a saperate file
```
file: person.types.ts

export type personprops = {...}

file: person.tsx
import {PersonProps} from './Person.types'
```

### Using type in other types
```
type a = {...}

type b = {
    var1: a
}
```

storybook
podium