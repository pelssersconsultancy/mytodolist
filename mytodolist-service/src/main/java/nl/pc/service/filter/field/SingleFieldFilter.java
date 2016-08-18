package nl.pc.service.filter.field;


import nl.pc.model.mongodb.RootEntity;
import nl.pc.service.filter.ISingleFieldFilter;

public abstract class SingleFieldFilter<ENTITY extends RootEntity, VALUE> implements ISingleFieldFilter<ENTITY> {

    private final VALUE value;
    private final String fieldName;

    public SingleFieldFilter(VALUE value, String fieldName) {
        this.value = value;
        this.fieldName = fieldName;
    }

    public VALUE getValue() {
        return value;
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public boolean shouldApply() {
        return value != null;
    }
}
