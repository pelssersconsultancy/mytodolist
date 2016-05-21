package nl.pc.repository.producer;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.ValidationExtension;
import org.mongodb.morphia.logging.MorphiaLoggerFactory;
import org.mongodb.morphia.logging.slf4j.SLF4JLoggerImplFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import java.util.ArrayList;
import java.util.List;


public abstract class DatastoreProducer implements IDatastoreProducer {

    private Datastore datastore;

    @PostConstruct
    public void init() {
        DBConfiguration cfg = getDBConfiguration();
        List<MongoCredential> credentials = new ArrayList<>();

        cfg.getDbCredentials()
            .map(credential ->
                MongoCredential.createCredential(
                    credential.getUsername(),
                    cfg.getDatabaseName(),
                    credential.getPassword().toCharArray()))
            .ifPresent(credentials::add);

        MongoClient client = new MongoClient(new ServerAddress(cfg.getHostname(), cfg.getPort()),credentials);
        Morphia morphia = new Morphia();

        // Morphia Logger Plugin
        MorphiaLoggerFactory.reset();
        MorphiaLoggerFactory.registerLogger(SLF4JLoggerImplFactory.class);

        // JSR 303 Interceptors
        ValidationExtension validationExtension = new ValidationExtension(morphia);

        getEntityClasses().forEach(morphia::map);

        datastore = morphia.createDatastore(client, cfg.getPrefixedDatabaseName());
        datastore.ensureIndexes();

    }

    public abstract DBConfiguration getDBConfiguration();

    public abstract List<Class<? extends RootEntity>> getEntityClasses();

    @Lock(LockType.READ)
    public Datastore getDatastore() {
        return datastore;
    }
}
