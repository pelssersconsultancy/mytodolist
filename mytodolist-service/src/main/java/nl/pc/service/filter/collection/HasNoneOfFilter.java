package nl.pc.service.filter.collection;


import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.query.Query;

import java.util.Collection;
import java.util.function.Function;

/**
 * Checks that a field has none of the values listed.
 * @param <ENTITY>
 * @param <IN> type of the values
 */
public abstract class HasNoneOfFilter<ENTITY extends RootEntity, IN> extends CollectionFilter<ENTITY, IN> {

    public HasNoneOfFilter(Collection<IN> collection) {
        super(collection);
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return query -> query.field(getFieldName()).hasNoneOf(getCollection());
    }

}
