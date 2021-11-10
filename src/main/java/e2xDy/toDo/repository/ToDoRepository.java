package e2xDy.toDo.repository;

import e2xDy.toDo.model.ToDoModel;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoModel, Integer> {
}