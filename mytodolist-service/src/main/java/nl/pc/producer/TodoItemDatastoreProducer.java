package nl.pc.producer;


import nl.pc.common.SystemProperty;
import nl.pc.model.mongodb.RootEntity;
import nl.pc.model.mongodb.TodoItem;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
@TodoItemDatastore
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class TodoItemDatastoreProducer extends DatastoreProducer {

    @Inject
    @SystemProperty("todoitems.mongodb.hostname")
    private String hostname;

    @Inject
    @SystemProperty("todoitems.mongodb.port")
    private String port;

    @Inject
    @SystemProperty("todoitems.mongodb.databasename")
    private String databasename;

    @Inject
    @SystemProperty("global.environment")
    private String prefix;

//    @Inject
//    @SystemProperty("todoitems.mongodb.username")
//    private String username;
//
//    @Inject
//    @SystemProperty("todoitems.mongodb.password")
//    private String password;

    @Override
    public DBConfiguration getDBConfiguration() {
        return new DBConfiguration.Builder()
            .withDatabaseName(databasename)
            .withHostname(hostname)
            .withPort(Integer.parseInt(port))
            .withPrefix(prefix)
            .withJoiner("_")
//            .withCredentials(username, password)
            .build();
    }

    @Override
    public List<Class<? extends RootEntity>> getEntityClasses() {
        return Collections.singletonList(TodoItem.class);
    }


}
