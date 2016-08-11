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
 */

@Dependent
public class SystemPropertyProducer {

    @Produces
    @SystemProperty(value = "")
    public String findProperty(InjectionPoint ip) {
        SystemProperty annotation = ip.getAnnotated().getAnnotation(SystemProperty.class);
        Optional<String> propertyValue = Optional.ofNullable(System.getProperty(annotation.value()));
        return propertyValue.orElseThrow(() ->
                new PropertyNotFoundException("Could not locate system property " + annotation.value()));
    }

}

