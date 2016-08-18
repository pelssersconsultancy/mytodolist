package nl.pc.service.filter;


import nl.pc.model.mongodb.RootEntity;
import org.mongodb.morphia.query.Query;

import java.util.function.Function;

public interface IFilter<ENTITY extends RootEntity> {

    /**
     *
     * @return whether this filter should be applied. E.g. blank values or empty or null collections should be skipped
     */
    boolean shouldApply();

    /**
     *
     * @return a new Query object after applying this filter to input Query
     */
    Function<Query<ENTITY>, Query<ENTITY>> addFilterToQuery();


    default String join(String... fieldNames) {
        return String.join(".", fieldNames);
    }
}
