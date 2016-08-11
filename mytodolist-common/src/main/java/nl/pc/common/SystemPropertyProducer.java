package nl.pc.common;


import nl.pc.exception.PropertyNotFoundException;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.Optional;

/**
 * Useful for injecting a system property
 *
 * When using wildfly you can define them e.g. in the standalone-full.xml like below:
 *
 * <server xmlns="urn:jboss:domain:3.0">
 *   <extensions>
 *       ...
 *   </extensions>
 *
 *   <system-properties>
 *       <property name="global.environment" value="PROD"/>
 *       <property name="global.year" value="2016"/>
 *   </system-properties>
 * </server>
 *
 *
 * Usage:
 *
 *   @Inject
 *   @SystemProperty("global.environment")
 *   private String environment;
 *
 *   @Inject
 *   @SystemProperty(value = "global.year", type = Integer.class)
 *   private Integer year;
 *
 */

@Dependent
public class SystemPropertyProducer {

    @Produces
    @SystemProperty("")
    public Object findProperty(InjectionPoint ip) {
        SystemProperty annotation = ip.getAnnotated().getAnnotation(SystemProperty.class);
        Optional<String> propertyValue = Optional.ofNullable(System.getProperty(annotation.value()));
        Class<?> type = annotation.type();

        return propertyValue.map(value -> convertValue(value, type)).orElseThrow(() ->
                new PropertyNotFoundException("Could not locate system property " + annotation.value()));
    }

    private Object convertValue(String value, Class<?> type ) {
        if (type == String.class) return value;
        if (type == Boolean.class) return Boolean.parseBoolean(value);
        if (type == Integer.class) return Integer.parseInt(value);
        if (type == Float.class) return Float.parseFloat(value);
        if (type == Long.class) return Long.parseLong(value);
        throw new IllegalArgumentException("Unsupported type");
    }
}

