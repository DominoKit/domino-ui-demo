package org.dominokit.domino.uidemoserver.server.resources;

import io.vertx.core.buffer.Buffer;
import org.dominokit.domino.api.server.plugins.ResourceContext;
import org.dominokit.domino.uidemoserver.shared.model.Contact;
import org.dominokit.domino.uidemoserver.shared.model.ContactList;
import org.dominokit.domino.uidemoserver.shared.model.ContactList_MapperImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Path("/service/")
public class DemoResource {

    @Context
    private ResourceContext resourceContext;

    @Path("contacts")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Contact> list() {
        Buffer buffer = resourceContext.getVertxContext()
                .vertx()
                .fileSystem()
                .readFileBlocking("contacts.json");

        String contactJson = buffer.toString(StandardCharsets.UTF_8);

        ContactList contactList = ContactList_MapperImpl.INSTANCE.read(contactJson);

        return contactList.getContacts();
    }
}