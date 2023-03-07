import logo from './logo.svg';
import './App.css';

import Greet from './components/greet';
import Welcome from './components/welcome';

function App(){
  return (
    <div className='App'>
      <Greet name = "name4">
        <p>This is the child prop</p>
      </Greet>

      <Welcome name = "name2">
        <button>click</button>
      </Welcome>
    </div>
  );
}

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

export default App;
