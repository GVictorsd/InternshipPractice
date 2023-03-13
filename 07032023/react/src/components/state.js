
import React, {Component} from "react";

class State extends Component {
    constructor(){
        super();
        this.state = {
            message: "hello",
            count: 0
        }
    }

    changeMessage = () => {

        // this.setState((prevState) => ({
        //     count : prevState.count + 1
        // }))

        this.state.count++;
        this.setState({});

        console.log(this.state.count);
        // if(this.state.message == 'hello'){
        //     this.setState({
        //         message : "Thank You",
        //         count: this.state.count
        //     })
        // }else{
        //     this.setState({
        //         message: 'hello'
        //     })
        // }
    }

    incrementFour(){
        this.changeMessage();
        this.changeMessage();
        this.changeMessage();
        this.changeMessage();
    }

    render(){
        return (
            <div>
                <h1>{this.state.message}</h1>
                <h2>{this.state.count}</h2>
                {/* <button onClick={() => this.incrementFour()}>Click</button> */}
                <button onClick={() => this.changeMessage()}>Click</button>
            </div>
        )
    }
}

export default State;