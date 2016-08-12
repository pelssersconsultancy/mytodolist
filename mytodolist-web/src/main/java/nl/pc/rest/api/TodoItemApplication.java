package nl.pc.rest.api;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import nl.pc.rest.filter.SecurityContextFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api/v1.0")
public class TodoItemApplication extends Application {

    public TodoItemApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/mytodolist/api/v1.0");
        beanConfig.setResourcePackage("nl.pc.rest.api");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        //add filters
        resources.add(SecurityContextFilter.class);

        //add Swagger resources
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);

        resources.add(TodoItemResource.class);
        return resources;
    }

}
