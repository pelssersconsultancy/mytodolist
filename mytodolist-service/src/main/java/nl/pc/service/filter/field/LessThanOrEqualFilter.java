package nl.pc.service.filter.field;


import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.query.Query;

import java.util.function.Function;

/**
 * Checks that a field is less than or equal to the value given
 * @param <ENTITY>
 */
public class LessThanOrEqualFilter<ENTITY extends RootEntity> extends SingleFieldFilter<ENTITY, Object> {

    public LessThanOrEqualFilter(Object value, String fieldName) {
        super(value, fieldName);
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return (query) -> query.field(getFieldName()).lessThanOrEq(getValue());
    }
}
