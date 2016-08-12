package nl.pc.rest.api;


import nl.pc.rest.model.AuditModel;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.util.Date;

public abstract class AbstractResource {

    @Context
    protected SecurityContext securityContext;

    @Context
    protected UriInfo uriInfo;

    public AuditModel getAuditModel() {
        return new AuditModel(new Date(), securityContext.getUserPrincipal().getName());
    }
}
