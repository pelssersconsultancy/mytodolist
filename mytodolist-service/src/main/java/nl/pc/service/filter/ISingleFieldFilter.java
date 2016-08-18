package nl.pc.service.filter;


import nl.pc.model.mongodb.RootEntity;

public interface ISingleFieldFilter<ENTITY extends RootEntity> extends IFilter<ENTITY> {

    /**
     *
     * @return the field name to which the criteria is applied
     */
    String getFieldName();
}
