
import React, {Component} from "react";

class Click extends Component {
    constructor(){
        super();


        this.state = {
            message: "hello"
        }

        // this.handler = this.handler.bind(this);
    }

    // handler(){
    //     console.log(this);
    //     this.setState({
    //         message: "hi"
    //     })
    // }

    handler = () => {
        console.log(this);
        this.setState({
            message: "hi"
        })
    }

    render(){
        return (
            <div>
                <h1>{this.state.message}</h1>
                {/* <button onClick={this.handler.bind(this)}>Event Click</button> */}
                {/* <button onClick={() => this.handler()}>Event Click</button> */}
                <button onClick={this.handler}>Event Click</button>
            </div>
        )
    }
}

export default Click;