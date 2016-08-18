package nl.pc.service.filter;


import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.Query;

import java.util.function.Function;

public abstract class QueryFilter<ENTITY extends RootEntity> implements IMultiFieldFilter<ENTITY> {

    private final String pattern;

    public QueryFilter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean shouldApply() {
        return pattern != null && !pattern.isEmpty();
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return query -> {
            //map fieldNames to criteria
            query.or(getFieldNames()
                    .stream()
                    .map(fieldName -> query.criteria(fieldName).containsIgnoreCase(pattern))
                    .toArray(size -> new Criteria[size]));
            return query;
        };
    }

    protected String getPattern() {
        return pattern;
    }
}
