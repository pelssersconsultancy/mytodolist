package nl.pc.rest.service;

import nl.pc.rest.model.AuditModel;
import nl.pc.rest.model.TodoItemCreateModel;
import nl.pc.rest.model.TodoItemViewModel;

public interface ITodoItemRestService {

    TodoItemViewModel get(String id);

    TodoItemViewModel create(TodoItemCreateModel createModel, AuditModel auditModel);
}
