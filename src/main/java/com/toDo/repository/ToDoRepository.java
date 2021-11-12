package com.toDo.repository;

import com.toDo.model.ToDoModel;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoModel, Integer> {
}