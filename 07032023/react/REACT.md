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