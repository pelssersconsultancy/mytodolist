package nl.pc.rest.api;


import io.swagger.annotations.Api;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todo-item")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Todo Item", description = "Operations about Todo Items")
public class TodoItemResource {


}
