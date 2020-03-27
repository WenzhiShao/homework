import React, { Component } from 'react'
import "./item.css"

class ListItem extends Component{
    constructor(props) {
        super(props)
        
    }

    onClick = (event) => {
        this.props.changeDone(event.currentTarget.value,event.currentTarget.checked)
    }

    render(){
        const item = this.props.item
        if(item.done) {
            return <s><p className = "done-Item"><input type="checkbox" onChange = {this.onClick} checked={true} value = {this.props.item.content}/>{this.props.item.content}</p></s>
        }
        return <p className = "Item"><input type="checkbox" onChange = {this.onClick} checked = {false} value = {this.props.item.content}/>{this.props.item.content}</p>
        
    }
}
export default ListItem