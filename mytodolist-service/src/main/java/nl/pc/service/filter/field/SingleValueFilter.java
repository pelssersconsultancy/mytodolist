package nl.pc.service.filter.field;


import nl.pc.model.mongodb.RootEntity;
import nl.pc.service.filter.ISingleFieldFilter;

public abstract class SingleValueFilter<ENTITY extends RootEntity, VALUE> implements ISingleFieldFilter<ENTITY> {

    private final VALUE value;

    public SingleValueFilter(VALUE value) {
        this.value = value;
    }

    public VALUE getValue() {
        return value;
    }

    @Override
    public boolean shouldApply() {
        return value != null;
    }
}
