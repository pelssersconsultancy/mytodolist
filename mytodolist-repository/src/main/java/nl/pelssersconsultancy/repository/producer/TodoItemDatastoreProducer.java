package nl.pelssersconsultancy.repository.producer;

import nl.pelssersconsultancy.common.SystemPropertyProducer.*;
import nl.pelssersconsultancy.model.mongodb.RootEntity;
import nl.pelssersconsultancy.model.mongodb.TodoItem;

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
    @SystemProperty("todoitems.mongodb.username")
    private String username;

    @Inject
    @SystemProperty("todoitems.mongodb.password")
    private String password;

    @Override
    public DBConfiguration getDBConfiguration() {
        return new DBConfiguration.Builder()
            .withDabaseName(databasename)
                .withHostname(hostname)
                .withPort(port)
                .withCredentials(username, password)
                .build();
    }

    @Override
    public List<Class<? extends RootEntity>> getEntityClasses() {
        return Collections.singletonList(TodoItem.class);
    }


}
