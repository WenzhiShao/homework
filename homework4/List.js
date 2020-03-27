import React from 'react'
import { Component } from "react";
import ListItem from "./ListItem"
import AddItem from './AddItem';
class List extends Component{
    constructor(props){
        super(props)
        this.state = {
            todolist : [
                {content:'吃饭',done:true},
                {content:'sleep',done:false}
            ]
        }
        this.changeDone = this.changeDone.bind(this)
    }
    addItem = (newContent) => {
        const newI = [...this.state.todolist, {content:newContent,done:false}]
        this.setState(
            {
                todolist:newI
            }
        )
    }

    changeDone(task, state){
        const newTodoList = this.state.todolist
        for(var i=0;i<newTodoList.length;i++){
           if(newTodoList[i].content == task) {
            newTodoList[i].done = state
            this.setState(
                {
                    todolist:newTodoList
                }
            )
           }
        }
    }

    render() {
        return(
            <div>
                {
                    this.state.todolist.map(item=> <ListItem item = {item}  changeDone = {this.changeDone}/>)
                }
                <AddItem addfun = {this.addItem}/>
            </div>
        )
    }
}
export default List