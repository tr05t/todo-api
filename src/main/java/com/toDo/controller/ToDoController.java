package com.toDo.controller;

import com.toDo.service.ToDoService;
import com.toDo.model.ToDoModel;
import com.toDo.model.ToDoRequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping(path = "", name = "getToDos")
    @RolesAllowed({"todo-user", "todo-admin"})
    public @ResponseBody
    Iterable<ToDoModel> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping(path = "{toDoId}", name = "getToDo")
    @RolesAllowed({"todo-admin"})
    public @ResponseBody
    Optional<ToDoModel> getToDo(@PathVariable final Integer toDoId) {
        return toDoService.getToDo(toDoId);
    }

    @PostMapping(path = "", name = "createToDo")
    @RolesAllowed({"todo-user", "todo-admin"})
    public @ResponseBody
    Optional<ToDoModel> createToDo(@RequestBody ToDoRequestModel toDoDetails) {
        return toDoService.createToDo(toDoDetails);
    }

    @PutMapping(path = "{toDoId}", name = "updateToDo")
    @RolesAllowed({"todo-user", "todo-admin"})
    public @ResponseBody
    Optional<ToDoModel> updateToDo(@PathVariable final Integer toDoId, @RequestBody ToDoModel toDoDetails) {
        return toDoService.updateToDo(toDoId, toDoDetails);
    }

    @DeleteMapping(path = "{toDoId}", name = "deleteToDo")
    @RolesAllowed({"todo-user", "todo-admin"})
    public @ResponseBody
    boolean deleteToDo(@PathVariable final Integer toDoId) {
        return toDoService.deleteToDo(toDoId);
    }
}
