package com.newprojectjdbc.todo;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ToDoController {
    private final ToDoRepository toDoRepository = new ToDoRepository();
    @GetMapping("/todo-app") //listens to what is type in the URL field, endPoint in browser, not html, we return html with name todo-page
    public String showToDoPage(
            @RequestParam(name="description", required = false) String description,
            @RequestParam(name="status", required = false) String status,
            @RequestParam(name="agreement", required = false) Boolean agree,
            Model model //inversion of control
    ){
        if(this.isToDoParametersPresent(description, status)){
            ToDoItem todo = new ToDoItem(description, status.equals("completed"));
            this.addToDoToDatabase(todo);
            //to do smth in database
        }
        model.addAttribute("todoList", this.getTodosFromDatabase());
        return "todo-page"; //opens proper html file from templates folder
    }

    private void addToDoToDatabase(ToDoItem todo){
        toDoRepository.createToDo(todo);
        System.out.println(todo);
    }

    private ArrayList<ToDoItem> getTodosFromDatabase(){
        return this.toDoRepository.findAllTodos();
    }

    private boolean isToDoParametersPresent(String description, String status){
        return description != null &&
                status != null &&
                !status.isBlank() &&
                !description.isBlank();
    }


}
