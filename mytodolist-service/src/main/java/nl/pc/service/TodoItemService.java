package nl.pc.service;

import org.mongodb.morphia.Datastore;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TodoItemService {

    @Inject
    private Datastore datastore;


}
