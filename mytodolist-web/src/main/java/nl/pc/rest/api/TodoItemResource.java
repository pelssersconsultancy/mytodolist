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
public class TodoItemResource extends AbstractResource {

    @Inject
    private ITodoItemRestService todoItemRestService;


    @GET
    @Path("/{id}")
    @ApiOperation(
            value = "Get the todo item with this id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Todo item with id found", response = TodoItemViewModel.class),
            @ApiResponse(code = 404, message = "No todo item with id found.")
    })
    public Response get(@ApiParam(value = "Id") @PathParam("id") String id) throws NotFoundException {
        TodoItemViewModel model = todoItemRestService.get(id);
        return Response.ok(model).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Create a new Todo Item", notes = "Creates a new `TodoItem`")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message="Successfully created", response = TodoItemViewModel.class),
            @ApiResponse(code = 400, message="Invalid TodoItemCreateModel")
    })
    @ApiImplicitParams(
            @ApiImplicitParam(name = "UserName", value = "User name", required = true, dataType = "string", paramType = "header")
    )
    public Response create(@Valid TodoItemCreateModel createModel) {
        TodoItemViewModel model = todoItemRestService.create(createModel, getAuditModel());
        return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build())
                .entity(model)
                .build();
    }




}
