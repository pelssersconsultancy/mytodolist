package nl.pc.rest.api;


import io.swagger.annotations.*;
import nl.pc.rest.model.TodoItemCreateModel;
import nl.pc.rest.model.TodoItemViewModel;
import nl.pc.rest.service.ITodoItemRestService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Todo Item", description = "Operations about Todo Items")
@Path("/todo-item")
public class TodoItemResource {

    @Context
    private SecurityContext securityContext;

    @Context
    private UriInfo uriInfo;

    @Inject
    private ITodoItemRestService todoItemRestService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create a new Todo Item", notes = "Creates a new `TodoItem`")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message="Successfully created", response = TodoItemViewModel.class),
            @ApiResponse(code = 400, message="Invalid TodoItemCreateModel")
    })
    public Response createKpi(@Valid TodoItemCreateModel model) {
        TodoItemViewModel viewModel = todoItemRestService.create(model);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(viewModel.getId()).build())
                .entity(viewModel)
                .build();
    }

}
