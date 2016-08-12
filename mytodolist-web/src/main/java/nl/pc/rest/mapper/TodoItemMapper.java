package nl.pc.rest.mapper;


import nl.pc.model.mongodb.AuditTrail;
import nl.pc.model.mongodb.TodoItem;
import nl.pc.rest.model.AuditModel;
import nl.pc.rest.model.TodoItemCreateModel;
import nl.pc.rest.model.TodoItemViewModel;

import java.util.UUID;

public class TodoItemMapper {

    private TodoItemMapper() {
        //util class
    }

    public static TodoItem map(TodoItemCreateModel createModel, AuditModel auditModel) {
        return new TodoItem.Builder()
                .withAuditTrail(
                        new AuditTrail.Builder()
                                .withCreated(auditModel.getTimestamp())
                                .withCreatedBy(auditModel.getUserName())
                                .withLastModified(auditModel.getTimestamp())
                                .withLastModifiedBy(auditModel.getUserName())
                                .build())
                .withId(UUID.randomUUID().toString())
                .withDescription(createModel.getDescription())
                .withShortName(createModel.getShortName())
                .build();
    }

    public static TodoItemViewModel map(TodoItem todoItem) {
        return new TodoItemViewModel.Builder()
                .withCreated(todoItem.getAuditTrail().getCreated())
                .withCreatedBy(todoItem.getAuditTrail().getCreatedBy())
                .withDescription(todoItem.getDescription())
                .withId(todoItem.getId())
                .withLastModified(todoItem.getAuditTrail().getLastModified())
                .withLastModifiedBy(todoItem.getAuditTrail().getLastModifiedBy())
                .withShortName(todoItem.getShortName())
                .build();
    }
}
