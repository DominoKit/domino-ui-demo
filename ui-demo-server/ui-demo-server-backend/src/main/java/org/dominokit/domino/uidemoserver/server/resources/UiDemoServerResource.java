package org.dominokit.domino.uidemoserver.server.resources;

import org.dominokit.domino.uidemoserver.shared.response.UiDemoServerResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class UiDemoServerResource {

    @Path("UiDemoServerRequest")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public UiDemoServerResponse sayHello() {
        return new UiDemoServerResponse("Hello from server");
    }
}