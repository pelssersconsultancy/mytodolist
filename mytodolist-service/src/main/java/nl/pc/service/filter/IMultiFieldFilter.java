package nl.pc.service.filter;


import nl.pc.model.mongodb.RootEntity;

import java.util.List;

public interface IMultiFieldFilter<ENTITY extends RootEntity> extends IFilter<ENTITY> {

    /**
     *
     * @return the field names to which the criteria is applied
     */
    List<String> getFieldNames();
}
