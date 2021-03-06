package nl.pc.service.filter.field;


import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.query.Query;

import java.util.function.Function;

/**
 * Checks that a field equals a value
 * @param <ENTITY>
 */
public abstract class EqualFilter<ENTITY extends RootEntity> extends SingleFieldFilter<ENTITY, Object> {

    public EqualFilter(Object value, String fieldName) {
        super(value, fieldName);
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return (query) -> query.field(getFieldName()).equal(getValue());
    }
}
