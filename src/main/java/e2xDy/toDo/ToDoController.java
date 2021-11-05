package e2xDy.toDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(path = "/api/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping(path = "")
    public @ResponseBody
    Iterable<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    @PostMapping("")
    public @ResponseBody
    Optional<ToDo> createToDo() {
        ToDo toDo = new ToDo();
        toDo.setContent(UUID.randomUUID().toString());
        toDo.setDone(false);
        toDoRepository.save(toDo);
        return toDoRepository.findById(toDo.getId());
    }
}
