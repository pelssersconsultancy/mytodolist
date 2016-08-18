package nl.pc.service.filter.field;


import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.query.Query;

import java.util.function.Function;

/**
 * Checks that a field is greater than or equal to the value given
 * @param <ENTITY>
 */
public abstract class GreaterThanOrEqualFilter<ENTITY extends RootEntity> extends SingleValueFilter<ENTITY, Object> {

    public GreaterThanOrEqualFilter(Object value) {
        super(value);
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return (query) -> query.field(getFieldName()).greaterThanOrEq(getValue());
    }
}
