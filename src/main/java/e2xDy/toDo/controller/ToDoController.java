package e2xDy.toDo.controller;

import e2xDy.toDo.model.ToDoModel;
import e2xDy.toDo.model.ToDoRequestModel;
import e2xDy.toDo.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody
    Iterable<ToDoModel> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping(path = "{toDoId}", name = "getToDo")
    public @ResponseBody
    Optional<ToDoModel> getToDo(@PathVariable final Integer toDoId) {
        return toDoService.getToDo(toDoId);
    }

    @PostMapping(path = "", name = "createToDo")
    public @ResponseBody
    Optional<ToDoModel> createToDo(@RequestBody ToDoRequestModel toDoDetails) {
        return toDoService.createToDo(toDoDetails);
    }

    @PutMapping(path = "{toDoId}", name = "updateToDo")
    public @ResponseBody
    Optional<ToDoModel> updateToDo(@PathVariable final Integer toDoId, @RequestBody ToDoModel toDoDetails) {
        return toDoService.updateToDo(toDoId, toDoDetails);
    }

    @DeleteMapping(path = "{toDoId}", name = "deleteToDo")
    public @ResponseBody
    boolean deleteToDo(@PathVariable final Integer toDoId) {
        return toDoService.deleteToDo(toDoId);
    }
}
