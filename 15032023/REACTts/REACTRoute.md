
# React Router

## Paths
/ - home.js
/contact - contact.js
/about - about.js

## Installing
```
npm install react-router-dom@6.4
```

## Using in older versions(before v6.4)
```
import {BrowserRouter, Routes, Route, Link, NavLink} from 'react-router-dom'

function app(){
    return (
        <BrowserRouter>
            <header>
                <nav>
                    <Link to = "/">Home<Link>
                    <NavLink to="about">About </NavLink>
                </nav>
            </header>

            <main>
                <Routes>
                    <Route path='/' element={<Home />} />
                    <Route path='/about' element={<About/>} />
                </Routes>
            </main>
        </BrowserRouter>

    )
}

# import each of the <Home/> and <About /> components
```