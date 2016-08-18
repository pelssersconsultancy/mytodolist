package nl.pc.service.filter.field;


import nl.pc.model.mongodb.RootEntity;
import nl.pc.service.filter.IMultiFieldFilter;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MultiFieldFilter<ENTITY extends RootEntity, VALUE> implements IMultiFieldFilter<ENTITY> {

    private final VALUE value;
    private final List<String> fieldNames;

    public MultiFieldFilter(VALUE value, List<String> fieldNames) {
        this.value = value;
        this.fieldNames = new ArrayList<>(fieldNames);
    }

    @Override
    public List<String> getFieldNames() {
        return fieldNames;
    }

    @Override
    public boolean shouldApply() {
        return value != null;
    }

    @Override
    public Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery() {
        return query -> {
            //map fieldNames to criteria
            query.or(getFieldNames()
                    .stream()
                    .map(fieldName -> query.criteria(fieldName).equal(value))
                    .toArray(size -> new Criteria[size]));
            return query;
        };
    }
}
