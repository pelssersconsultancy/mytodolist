package nl.pc.service.filter.collection;

import nl.pc.model.mongodb.RootEntity;
import nl.pc.service.filter.ISingleFieldFilter;

import java.util.Collection;

public abstract class CollectionFilter<ENTITY extends RootEntity, IN> implements ISingleFieldFilter<ENTITY> {

    private final Collection<IN> collection;
    private final String fieldName;

    public CollectionFilter(Collection<IN> collection, String fieldName) {
        this.collection = collection;
        this.fieldName = fieldName;
    }

    public Iterable<IN> getCollection() {
        return this.collection;
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public boolean shouldApply() {
        return collection != null && !collection.isEmpty();
    }


}
