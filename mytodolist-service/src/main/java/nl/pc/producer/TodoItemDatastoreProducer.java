package nl.pc.producer;


import nl.pc.model.mongodb.RootEntity;
import nl.pc.model.mongodb.TodoItem;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import java.util.Collections;
import java.util.List;

@Singleton
@TodoItemDatastore
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class TodoItemDatastoreProducer extends DatastoreProducer {

//    @Inject
//    @SystemProperty("todoitems.mongodb.hostname")
    private String hostname = "localhost";

//    @Inject
//    @SystemProperty("todoitems.mongodb.port")
    private int port = 27017; //TODO: verify if this will work... as port is int

//    @Inject
//    @SystemProperty("todoitems.mongodb.databasename")
    private String databasename = "pc";

//    @Inject
//    @SystemProperty("todoitems.mongodb.prefix")
    private String prefix = "LOCAL";

//    @Inject
//    @SystemProperty("todoitems.mongodb.username")
    private String username;

//    @Inject
//    @SystemProperty("todoitems.mongodb.password")
    private String password;

    @Override
    public DBConfiguration getDBConfiguration() {
        return new DBConfiguration.Builder()
            .withDatabaseName(databasename)
            .withHostname(hostname)
            .withPort(port)
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
