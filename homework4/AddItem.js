import React,{ Component } from "react";

class AddItem extends Component{
    constructor(props){
        super(props)
        this.state = {
            inputCont:''
        }
    }
    inputChange = (event) =>{
        this.setState(
            {
                inputCont:event.target.value
            }
        )
        console.log(this.state.inputCont)
    }
    onAddButon = () =>{
        this.props.addfun(this.state.inputCont)
        this.setState(
            {
                inputCont:''
            }
        )
    }
    render(){
        return (
            <div>
                <input value = {this.state.inputCont} onChange = {this.inputChange}></input>
                <button onClick = {this.onAddButon}>Add</button>
            </div>
           
        )
    }
}
export default AddItem