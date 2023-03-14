

import React from "react";

import "./mystyle.css";

import style from './mystyle.module.css'

const fontxl = {
    color: 'blue'
}


function styleComp(){
    return (
        <div>
            <h1 className='redcolor'>RED</h1>
            <h1 style={fontxl}>Blue</h1>
            <h1 className={style.fontcolor}>Hot Pink</h1>

        </div>
    )
}

export default styleComp;
