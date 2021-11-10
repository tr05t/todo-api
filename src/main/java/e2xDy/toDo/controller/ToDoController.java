package e2xDy.toDo.controller;

import e2xDy.toDo.model.ToDoModel;
import e2xDy.toDo.repository.ToDoRepository;
import e2xDy.toDo.model.ToDoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/todo")
public class ToDoController {

    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping(path = "", name = "getToDos")
    public @ResponseBody
    Iterable<ToDoModel> getAllToDos() {
        return toDoRepository.findAll();
    }

    @GetMapping(path = "{toDoId}", name = "getToDo")
    public @ResponseBody
    Optional<ToDoModel> getToDo(@PathVariable final Integer toDoId) {
        return toDoRepository.findById(toDoId);
    }

    @PostMapping(path = "", name = "createToDo")
    public @ResponseBody
    Optional<ToDoModel> createToDo(@RequestBody ToDoRequestModel toDoDetails) {
        ToDoModel toDo = new ToDoModel();
        toDo.setContent(toDoDetails.getContent());
        toDo.setDone(toDoDetails.getDone());
        toDoRepository.save(toDo);
        return toDoRepository.findById(toDo.getId());
    }

    @PutMapping(path = "{toDoId}", name = "updateToDo")
    public @ResponseBody
    Optional<ToDoModel> updateToDo(@PathVariable final Integer toDoId, @RequestBody ToDoModel toDoDetails) {
        System.out.println(toDoRepository.findById(toDoId));
        if (toDoRepository.findById(toDoId).isPresent()) {
            ToDoModel toDo = toDoRepository.findById(toDoId).get();
            toDo.setContent(toDoDetails.getContent());
            toDo.setDone(toDoDetails.getDone());
            toDoRepository.save(toDo);
            return toDoRepository.findById(toDo.getId());
        }
        return toDoRepository.findById(toDoId);
    }

    @DeleteMapping(path = "{toDoId}", name = "deleteToDo")
    public @ResponseBody
    boolean deleteToDo(@PathVariable final Integer toDoId) {
        if (toDoRepository.findById(toDoId).isPresent()) {
            ToDoModel toDo = toDoRepository.findById(toDoId).get();
            toDoRepository.delete(toDo);
            return true;
        }
        return false;
    }
}
