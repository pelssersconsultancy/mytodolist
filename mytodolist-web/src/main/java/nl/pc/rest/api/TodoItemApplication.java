package nl.pc.rest.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api/v1.0")
public class TodoItemApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = super.getClasses();
//        resources.addAll(getApiResources());
        return resources;
    }

}
