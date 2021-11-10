package e2xDy.toDo.service;

import e2xDy.toDo.model.ToDoModel;
import e2xDy.toDo.model.ToDoRequestModel;
import e2xDy.toDo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Iterable<ToDoModel> getAllToDos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDoModel> getToDo(final Integer toDoId) {
        return toDoRepository.findById(toDoId);
    }

    public Optional<ToDoModel> createToDo(ToDoRequestModel toDoDetails) {
        ToDoModel toDo = new ToDoModel();
        toDo.setContent(toDoDetails.getContent());
        toDo.setDone(toDoDetails.getDone());
        toDoRepository.save(toDo);
        return toDoRepository.findById(toDo.getId());
    }

    public Optional<ToDoModel> updateToDo(final Integer toDoId, ToDoModel toDoDetails) {
        if (toDoRepository.findById(toDoId).isPresent()) {
            ToDoModel toDo = toDoRepository.findById(toDoId).get();
            toDo.setContent(toDoDetails.getContent());
            toDo.setDone(toDoDetails.getDone());
            toDoRepository.save(toDo);
            return toDoRepository.findById(toDo.getId());
        }
        return toDoRepository.findById(toDoId);
    }

    public boolean deleteToDo(final Integer toDoId) {
        if (toDoRepository.findById(toDoId).isPresent()) {
            ToDoModel toDo = toDoRepository.findById(toDoId).get();
            toDoRepository.delete(toDo);
            return true;
        }
        return false;
    }
}
