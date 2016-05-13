package nl.pelssersconsultancy.common;


import nl.pelssersconsultancy.exception.PropertyNotFoundException;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
 */

@Dependent
public class SystemPropertyProducer {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
    public @interface SystemProperty {
        @Nonbinding String value();
    }

    @Produces
    @SystemProperty("")
    public String findProperty(InjectionPoint ip) {
        SystemProperty annotation = ip.getAnnotated().getAnnotation(SystemProperty.class);
        Optional<String> propertyValue = Optional.ofNullable(System.getProperty(annotation.value()));
        return propertyValue.orElseThrow(() ->
                new PropertyNotFoundException("Could not locate system property " + annotation.value()));
    }
}

