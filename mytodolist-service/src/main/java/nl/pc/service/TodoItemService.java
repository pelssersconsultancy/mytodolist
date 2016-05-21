package nl.pc.service;

import nl.pc.model.mongodb.TodoItem;
import nl.pc.producer.IDatastoreProducer;
import nl.pc.producer.TodoItemDatastore;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;

import javax.ejb.Singleton;
import javax.inject.Inject;

import java.util.Optional;

@Singleton
public class TodoItemService implements ITodoItemService {

    private IDatastoreProducer datastoreProducer;

    @Inject
    public TodoItemService(@TodoItemDatastore IDatastoreProducer datastoreProducer) {
       this.datastoreProducer = datastoreProducer;
    }


    public Query<TodoItem> query() {
        return getDatastore().createQuery(TodoItem.class);
    }

    @Override
    public Key<TodoItem> insert(TodoItem todoItem) {
        return getDatastore().save(todoItem);
    }

    @Override
    public Optional<TodoItem> find(String id) {
        return Optional.ofNullable(query().field(TodoItem._id).equal(id).get());
    }

    public Datastore getDatastore() {
        return datastoreProducer.getDatastore();
    }

}
