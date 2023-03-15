// import React from 'react';
// import logo from './logo.svg';
import './App.css';
import { Parent , Pr} from './components/parent';
import {Textchild, Objchild, Arrchild} from './components/childprops'
import { Eventprop } from './components/Eventprop';
import { TypeEvent } from './components/typeEvent';

const propobj = {
  first: "alice",
  last: "ping"
}

const person = [
  {name: "Bob"},
  {name: "Alice"},
  {name: "Jonny"}
]

function App() {
  return (
    <div className="App">
      <Parent name='apple' num={10}/>
      <Pr name = "hi"/>

      <Textchild> Hello child text </Textchild>


      <Objchild name={propobj} age = {6}/>

      <Arrchild person={person}/>

      <Eventprop clickhandler={(event) => {
        console.log("button Clicked");
        console.log(event);
      }}>Child text</Eventprop>

      <TypeEvent value='' handlechange={(event) => {
        console.log(event)
      }}></TypeEvent>

      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
    </div>
  );
}

export default App;
