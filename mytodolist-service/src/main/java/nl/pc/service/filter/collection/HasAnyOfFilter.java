package nl.pc.service.filter.collection;

import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.query.Query;

import java.util.Collection;
import java.util.function.Function;

/**
 * Checks that a field has any of the values listed. Conceptually the same as checking if the value of this field
 * is an element of {values} of type IN (InFilter)
 * @param <ENTITY>
 * @param <IN> type of the values
 */
public class HasAnyOfFilter<ENTITY extends RootEntity, IN> extends CollectionFilter<ENTITY, IN> {

    public HasAnyOfFilter(Collection<IN> collection, String fieldName) {
        super(collection, fieldName);
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return query -> query.field(getFieldName()).hasAnyOf(getCollection());
    }
}
