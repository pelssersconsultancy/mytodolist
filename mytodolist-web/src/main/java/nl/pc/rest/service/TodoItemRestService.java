package nl.pc.rest.service;


import nl.pc.model.mongodb.TodoItem;
import nl.pc.rest.mapper.TodoItemMapper;
import nl.pc.rest.model.AuditModel;
import nl.pc.rest.model.TodoItemCreateModel;
import nl.pc.rest.model.TodoItemViewModel;
import nl.pc.service.ITodoItemRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

@Stateless
public class TodoItemRestService implements ITodoItemRestService {

    @Inject
    private ITodoItemRepository todoItemRepository;

    @Override
    public TodoItemViewModel get(String id) throws NotFoundException {
        return todoItemRepository.find(id).map(TodoItemMapper::map).orElseThrow(NotFoundException::new);
    }

    @Override
    public TodoItemViewModel create(TodoItemCreateModel createModel, AuditModel auditModel) {
        TodoItem todoItemNew = TodoItemMapper.map(createModel, auditModel);
        todoItemRepository.insert(todoItemNew);
        return get(todoItemNew.getId());
    }
}
