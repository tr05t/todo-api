package e2xDy.toDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping(path = "", name = "getToDos")
    public @ResponseBody
    Iterable<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    @GetMapping(path = "{toDoId}", name = "getToDo")
    public @ResponseBody
    Optional<ToDo> getToDo(@PathVariable Integer toDoId) {
        return toDoRepository.findById(toDoId);
    }

    @PostMapping(path = "", name = "createToDo")
    public @ResponseBody
    Optional<ToDo> createToDo(@RequestBody ToDoRequestModel toDoDetails) {
        ToDo toDo = new ToDo();
        toDo.setContent(toDoDetails.getContent());
        toDo.setDone(toDoDetails.getDone());
        toDoRepository.save(toDo);
        return toDoRepository.findById(toDo.getId());
    }

    @PutMapping(path = "{toDoId}", name = "updateToDo")
    public @ResponseBody
    Optional<ToDo> updateToDo(@PathVariable Integer toDoId, @RequestBody ToDo toDoDetails) {
        System.out.println(toDoRepository.findById(toDoId));
        if (toDoRepository.findById(toDoId).isPresent()) {
            ToDo toDo = toDoRepository.findById(toDoId).get();
            toDo.setContent(toDoDetails.getContent());
            toDo.setDone(toDoDetails.getDone());
            toDoRepository.save(toDo);
            return toDoRepository.findById(toDo.getId());
        }
        return toDoRepository.findById(toDoId);
    }

    @DeleteMapping(path = "{toDoId}", name = "deleteToDo")
    public @ResponseBody
    boolean deleteToDo(@PathVariable Integer toDoId) {
        if (toDoRepository.findById(toDoId).isPresent()) {
            ToDo toDo = toDoRepository.findById(toDoId).get();
            toDoRepository.delete(toDo);
            return true;
        }
        return false;
    }
}
