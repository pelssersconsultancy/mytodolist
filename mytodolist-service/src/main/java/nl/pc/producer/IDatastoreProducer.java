package nl.pc.producer;

import org.mongodb.morphia.Datastore;

@FunctionalInterface
public interface IDatastoreProducer {

    Datastore getDatastore();

}
