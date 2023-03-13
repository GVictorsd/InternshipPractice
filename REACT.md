# REACTjs

## Folder structure
- package.json - contains dependencies and scripts to build and test application
- node_modules - all dependencies are installed here

### Component
- Describe a part of the UI
- Are reusable and can be nested
- eg - header, sidenav, maincontent, footer, root(App)(contains all other components)
Components are placed in js file App.js -> AppComponent

### Types of components
Two types

- Stateless functional component
```
- javascript functions

function welcome(props){
    return <h1> Hello, (props.name)</h1>
}
```

- Statefull class component
```
- classes that extend Component class
- Render method returning HTML

class Welcome extends React.Component {
    render(){
        return <h1> hello, {this.props.name} </h1>
    }
}

```

## Functional Components
- A js function that can take parameters called `props` and reuturn html(jsx)

```
# create new folder in src called Components and a file named Greet.js

import React from 'react'
function Greet(){
    return <h1> Hello World </h1>
}

export default Greet;
```

```
# in App.js
import Greet from './components/Greet'
#in render method
<div className = "App">
    <Greet> </Greet>
</div>
```

- arrow function in js
```
const Greet = () => <h1> Hello World </h1>
```

### Exporting and imporing
- default exports
can be imported with any name

```
export default Greet

# in importing file
import <anyName> from './components/Greet'
```

- named exports
Must be imported with the same name as defined in export file

```
export const Greet = () => <h1> hello </h1>

# in importing file
import { Greet } from './components/Greet' <- {} specify constant import
import <anyName> from './components/Greet' <- DOESNT WORK

```

## Class components
- They are ES6 classes that receive `props` ,return html(jsx) and also maintain its own private state

```
# Welcome.js

import React, {Component} from 'react'

class Welcome extends Component {
    render(){
        return <h1> hello world </h1>
    }
}

export default Welcome;

# importing is same
```

### JSX
- Extension to the javascrip syntax
- Have tags and attributes
- makes react code simpler
- later translated to regular javascript
- Optional to use incase of react

```
<div>
    <h1> Hello </h1>
</div>

# in normal js

return React.createElement(<htmlElement>, <props>, <childrenToHtmlElement> )
return React.createElement('div', null, 'Hello');

return React.createElement(
    'div', 
    null, 
    React.createElement('h1', null, 'Hello')
);

return React.createElement(
    'div', 
    {id: 'hello', className: 'myclass'}
    React.createElement('h1', null, 'Hello')
);
# for the above, jsx
<div className="myclass">
    <h1>
</div>
```

## Props
- Optional properties that the components can accept
- Props are immutable

```
# passing props
<Greet name = "alice" />

# using them
const Greet = (props) => {
    console.log(props);
    console.log(props.name);
    return <h1> Hello {props.name}</h1>
}
```

### Props.children
Rendering the child elements
```
# in main file
<Greet name = "alice" >
    <p> children props </p>
</Greet>

# in component file
# in order to show the child prop
return (
    <div>
        <h1>
            hello {props.name}
        </h1>
        {props.children}
    </div>
)

note: return should be enclosed by a single div tag
```

### props with class
```
props are included by default in `this`

return <h1> hi {this.props.name} </h1>
```

### Props vs State
- props get passed to the component and state is managed within the component
- props are immutable while state can change
- props(functional comp), this.props(class compon)
- useState Hook (func comp), this.state(class comp)

### State example
```
class Message extends Components {
    constructor(){
        super();
        this.state = {
            message: 'hello'
        }
    }

    render(){
        return <h1>{this.state.message}</h1>
    }
}
```

## this.setState()
- Used to change the state of the UI components
- calls to setState() are asyncronous

```
changeMessage(){
    this.setState({
        message: "Thank You"
    })
}

render(){
    return(
        <div>
            <h1>{this.state.message}</h1>
            <button onClick={()=>changeMessage()}> click </button>
        </div>
    )
}
```

Asyncronous nature

```
this.setState({
    count : this.state.count()++;  <= asyncronous call
})
console.log(this.state.count);   <= executed before setState



# Call back function (pass as second paramenter as arrow function)
this.setState({
    count : this.state.count()++;
},
() => {
    console.log('callback value' + this.state.count());
})

```

### prevState
- Whenever state needs to be updated based on previous value, use prevState
- Example calling multiple calls to increment the value in ui

```
# example
increment(){
    # increment the value based on simple current value
    setState(count: this.state.count + 1)
}

# This updates ui only once since react groups multiple update calls into single one
incrementFive(){
    this.increment()
    this.increment()
    this.increment()
    this.increment()
    this.increment()
}
```

- Instead pass a function a an arg to setState
- As an optional second arg, props object can be passed 

```
increment(){
    this.setState((prevState, props) => ({
        count: prevState.state.count;
    }))

}
```

### Destructuring props and state
- in functional component
```
# destructuring in the parameter
# props containg props.name, props.age
const Greet = ({name, age}) => {
    return (
        <h1>{name}, {age}</h1>
    )
}

# destructuring in the body
const Greet = (props) => {
    const {name, age} = props;
    ...
}
```
- Class Components
```
# destructure in render method
render(){
    # props can have multiple props but destructuring only that are needed>
    const {name, age} = this.props;
}
```

## Event Handling
- functional component

```
function Click(){
    function handler(){
        ...
    }

    return (
        <div>
# Dont add paranthesis after handler
        <button onClick={handler}> </button>
# plane html
        <button onclick="handler"> // in plane html 
        </div>
    )
}
```

- Class Component
```
render(){
    return (
        <div>
            <button onClick={this.clickHandler}> click </button>
        </div>
    )
}
```

### binding event handlers
- required because of the way `this` works in js
- `this` keyword is `undefined` in an event handler in case of a class component. so, binding is required for event handlers

```
handler(){
    this.setState({})
}

# Using Bind method
<button onClick={this.handler.bind(this)}>click</button>

# using arrow function 
<button onClick={() => this.clickHandler()}> click </button>

# binding in the constructor(recomended)
constructor(){
    ...
    this.handler = this.handler.bind(this);
}

<button onClick={this.handler}>


# Define handler as an arrow funcion(recommended)
handler = () => {
    this.setState(...)
}
```

### Methods as props
```
# In parent component
class parent exten...{
    ...

    handler = () => {
        ...
    }

    render(){
        return (
            <div> <ChildComponent handler = {this.handler} /></div> 
        )
    }
}

# in child Component
function ChildComp(props){
    return (
        <div>
            <button onClick={props.handler}> click </button>
    )
}
```
- passing parameter from a child component to parent method
```
# passing parameter from a child component to parent method
# use arrow functions
# in child component

<button onClick={() => props.handler(<parameters>)}> click </button>
```

## Conditional rendering
- if/else

```
render(){
    if(cond){
        return ...
    }else{
        return ...
    }
}
```

- using js variables
```
render(){
    let message
    if(...){
        message = <jsx>
    }else {
        message = <jsx>
    }

    return message;
}
```

- Ternary operator
can be used inside jsx

```
return(
    this.state.loggedin ?
    <jsx1>:
    <jsx2>;
)
```

## List rendering

### map() method
- creates a new array with the results of a function called on every element of the input array
```
var arr = [1,2,3];
const map1 = arr.map(x => x*2);
map1 // [1,4,9]
```

```
const names = ['n1', 'n2', 'n3']
return (
    <div>
        {
            names.map(name => <h2>{name}</h2>)
        }
    </div>
)
```

### Lists and keys
- keys are special string attributes(prop) that need to be included while creating a list
- Keys help react to figure out which elements of the list are updated 

```
persons.map(person => <li key={unique_id}> person </li>)
```

- using index of the array as keys
- use indexes for keys if:
- the elements are never reordered or changed
- list is static
```
# map function receives 2 parameters(value and index)
const names = [...];
const nameList = names.map((name,indes) => <h2 key={index}> {name} </h2>)
```

## Styling and CSS
- CSS stylesheets
```
# create css file
# import to js file
import './myStyles.css'
# add class names to required elements in jsx
<div className = "classname">

## passing class names as props

let className = props.primary ? 'primary' : '';
return (
    <div className={className}>...</div>
)
```