
import React, {Component} from "react";

class Lists extends Component{
    render(){
        const names = ["name1", "name2", "name3", "name4"]
        return (
            <div>
                {
                    names.map(name => <li>{name}</li>)
                }
            </div>
        )
    }
}

export default Lists;