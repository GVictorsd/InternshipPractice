
import React, {Component} from "react";

import ChildComp from "./childComp";

class ParentComp extends Component{
    constructor() {
        super();
    }

    handler(){
        alert('hello from parent');
    }

    render(){
        return(
            <div>
                <ChildComp handler={this.handler}/>
            </div>
        )
    }

}

export default ParentComp;