package nl.pc.repository.producer;

import nl.pc.common.SystemPropertyProducer.*;
import nl.pc.model.mongodb.RootEntity;
import nl.pc.model.mongodb.TodoItem;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class TodoItemDatastoreProducer extends DatastoreProducer {

    @Inject
    @SystemProperty("todoitems.mongodb.hostname")
    private String hostname;

    @Inject
    @SystemProperty("todoitems.mongodb.port")
    private int port; //TODO: verify if this will work... as port is int

    @Inject
    @SystemProperty("todoitems.mongodb.databasename")
    private String databasename;

    @Inject
    @SystemProperty("todoitems.mongodb.prefix")
    private String prefix;

    @Inject
    @SystemProperty("todoitems.mongodb.username")
    private String username;

    @Inject
    @SystemProperty("todoitems.mongodb.password")
    private String password;

    @Override
    public DBConfiguration getDBConfiguration() {
        return new DBConfiguration.Builder()
            .withDatabaseName(databasename)
            .withHostname(hostname)
            .withPort(port)
            .withPrefix(prefix)
            .withCredentials(username, password)
            .build();
    }

    @Override
    public List<Class<? extends RootEntity>> getEntityClasses() {
        return Collections.singletonList(TodoItem.class);
    }


}
