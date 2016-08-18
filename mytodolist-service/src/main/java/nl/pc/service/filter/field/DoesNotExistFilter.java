package nl.pc.service.filter.field;



import nl.pc.model.mongodb.RootEntity;
import nl.pc.service.filter.ISingleFieldFilter;
import org.mongodb.morphia.query.Query;

import java.util.function.Function;

/**
 * Checks that a field does not exist in a document
 * @param <ENTITY>
 */
public abstract class DoesNotExistFilter<ENTITY extends RootEntity> implements ISingleFieldFilter<ENTITY> {

    @Override
    public boolean shouldApply() {
        return true;
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return (query) -> query.field(getFieldName()).doesNotExist();
    }
}
