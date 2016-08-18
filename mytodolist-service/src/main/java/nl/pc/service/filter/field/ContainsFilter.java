package nl.pc.service.filter.field;


import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.query.Query;

import java.util.function.Function;

/**
 * Checks if a field contains a value
 * @param <ENTITY>
 */
public abstract class ContainsFilter<ENTITY extends RootEntity> extends SingleFieldFilter<ENTITY, String> {

    private final boolean ignoreCase;

    public ContainsFilter(String value, String fieldName, boolean ignoreCase) {
        super(value, fieldName);
        this.ignoreCase = ignoreCase;
    }

    @Override
    public boolean shouldApply() {
        return super.shouldApply() && !getValue().isEmpty();
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return (query) ->
                ignoreCase
                ? query.field(getFieldName()).containsIgnoreCase(getValue())
                : query.field(getFieldName()).contains(getValue());
    }
}
