package nl.pelssersconsultancy.repository.producer;

import org.mongodb.morphia.Datastore;

import javax.enterprise.inject.Produces;

@FunctionalInterface
public interface IDatastoreProducer {

    @Produces
    Datastore getDatastore();

}
