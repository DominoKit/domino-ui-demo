package org.dominokit.domino.uidemoserver.server.resources;

import com.google.auto.service.AutoService;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.dominokit.domino.api.server.entrypoint.ServerAppEntryPoint;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.domino.api.server.plugins.IndexPageContext;
import org.dominokit.domino.uidemoserver.shared.model.ContactList;
import org.dominokit.domino.uidemoserver.shared.model.ContactList_MapperImpl;

import java.nio.charset.StandardCharsets;

@AutoService(ServerAppEntryPoint.class)
public class DemoServerEntryPoint implements ServerAppEntryPoint<VertxContext> {
    @Override
    public void onModulesLoaded(VertxContext vertxContext) {
        JsonObject indexContext = new JsonObject();
        indexContext.put("appRootPath", vertxContext.config().getString("app.root.path"));
        IndexPageContext.INSTANCE.setIndexPageProvider(new DynamicIndexPageProvider(indexContext));
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
                .route(HttpMethod.POST, "/service/upload")
                .handler(event -> {
                   event.response()
                           .setStatusCode(200)
                           .end();
                });
    }
}
