package org.dominokit.domino.uidemoserver.shared.services;

import org.dominokit.domino.rest.shared.request.service.annotations.RequestFactory;
import org.dominokit.domino.uidemoserver.shared.response.UiDemoServerResponse;
import org.dominokit.domino.uidemoserver.shared.request.UiDemoServerRequest;

import javax.ws.rs.Path;

@RequestFactory
public interface UiDemoServerService {
    @Path("UiDemoServerRequest")
    UiDemoServerResponse request(UiDemoServerRequest request);
}
