package nl.pc.service;


import nl.pc.model.mongodb.TodoItem;
import org.mongodb.morphia.Key;

import java.util.Optional;

public interface ITodoItemRepository {

    Key<TodoItem> insert(TodoItem todoItem);

    Optional<TodoItem> find(String id);
}
