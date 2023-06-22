package org.dominokit.domino.uidemoserver.server.resources;

import com.google.auto.service.AutoService;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import org.dominokit.domino.api.server.entrypoint.ServerAppEntryPoint;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.domino.uidemoserver.shared.model.ContactList;
import org.dominokit.domino.uidemoserver.shared.model.ContactList_MapperImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

@AutoService(ServerAppEntryPoint.class)
public class DemoServerEntryPoint implements ServerAppEntryPoint<VertxContext> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServerEntryPoint.class);
    @Override
    public void onModulesLoaded(VertxContext vertxContext) {
        LOGGER.info("Executing server entry point...");
        vertxContext
                .router()
                .route(HttpMethod.GET, "/service/contacts")
                .handler(event -> {
                    Buffer buffer = vertxContext
                            .vertx()
                            .fileSystem()
                            .readFileBlocking("contacts.json");

                    String contactJson = buffer.toString(StandardCharsets.UTF_8);

                    ContactList contactList = ContactList_MapperImpl.INSTANCE.read(contactJson);
                   event.response()
                           .setStatusCode(200)
                           .end(Json.encode(contactList.getContacts()));
                });

        vertxContext
                .router()
                .route(HttpMethod.POST, "/form")
                .handler(event -> {
                    LOGGER.info("Uploading file completed");
                    event.response()
                            .setStatusCode(200)
                            .end();
                });
    }
}
