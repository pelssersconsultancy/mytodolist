package nl.pc.rest.service;

import nl.pc.rest.model.TodoItemCreateModel;
import nl.pc.rest.model.TodoItemViewModel;

public interface ITodoItemRestService {

    TodoItemViewModel create(TodoItemCreateModel createModel);
}
