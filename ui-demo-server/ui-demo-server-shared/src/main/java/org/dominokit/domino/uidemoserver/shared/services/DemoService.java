package org.dominokit.domino.uidemoserver.shared.services;

import org.dominokit.rest.shared.request.service.annotations.RequestFactory;
import org.dominokit.domino.uidemoserver.shared.model.Contact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@RequestFactory
public interface DemoService {
    @GET
    @Path("contacts")
    List<Contact> list();
}
