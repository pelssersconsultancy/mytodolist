package nl.pc.service.filter.collection;

import nl.pc.model.mongodb.RootEntity;
import nl.pc.service.filter.ISingleFieldFilter;

import java.util.Collection;

public abstract class CollectionFilter<ENTITY extends RootEntity, IN> implements ISingleFieldFilter<ENTITY> {

    private final Collection<IN> collection;

    public CollectionFilter(Collection<IN> collection) {
        this.collection = collection;
    }

    public Iterable<IN> getCollection() {
        return this.collection;
    }

    @Override
    public boolean shouldApply() {
        return collection != null && !collection.isEmpty();
    }


}
