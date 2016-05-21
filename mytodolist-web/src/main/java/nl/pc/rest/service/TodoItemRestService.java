package nl.pc.rest.service;

import nl.pc.exception.ServiceException;
import nl.pc.model.mongodb.AuditTrail;
import nl.pc.model.mongodb.TodoItem;
import nl.pc.rest.model.TodoItemCreateModel;
import nl.pc.rest.model.TodoItemViewModel;
import nl.pc.service.ITodoItemService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static nl.pc.rest.model.TodoItemViewModel.*;


@Stateless
public class TodoItemRestService implements ITodoItemRestService {


    @Inject
    private ITodoItemService todoItemService;

    @Override
    public TodoItemViewModel create(TodoItemCreateModel createModel) {
        Date now = new Date();
        String id = UUID.randomUUID().toString();
        TodoItem todoItemNew = new TodoItem.Builder()
                .withAuditTrail(
                        new AuditTrail.Builder()
                                .withCreated(now)
                                .withLastModified(now)
                                .build())
                .withId(id)
                .withDescription(createModel.getDescription())
                .withShortName(createModel.getShortName())
                .build();

        todoItemService.insert(todoItemNew);
        Optional<TodoItem> todoItemCreated = todoItemService.find(id);

        return todoItemCreated
                .map(item -> new Builder()
                    .withCreated(item.getAuditTrail().getCreated())
                    .withDescription(item.getDescription())
                    .withId(item.getId())
                    .withLastModified(item.getAuditTrail().getLastModified())
                    .withShortName(item.getShortName())
                    .build())
                .orElseThrow(() -> new ServiceException("Failed to find created todo item."));
    }
}
