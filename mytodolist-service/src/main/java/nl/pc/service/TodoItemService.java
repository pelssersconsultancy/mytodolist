package nl.pc.service;

import nl.pc.model.mongodb.TodoItem;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class TodoItemService implements ITodoItemService {

    @Inject
    private Datastore datastore;

    public Query<TodoItem> query() {
        return datastore.createQuery(TodoItem.class);
    }

    @Override
    public Key<TodoItem> insert(TodoItem todoItem) {
        return datastore.save(todoItem);
    }

    @Override
    public Optional<TodoItem> find(String id) {
        return Optional.ofNullable(query().field(TodoItem._id).equal(id).get());
    }

}
