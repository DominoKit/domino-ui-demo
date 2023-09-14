package org.dominokit.domino.uidemoserver.server.resources;

import com.google.auto.service.AutoService;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.freemarker.FreeMarkerTemplateEngine;
import org.dominokit.domino.api.server.PluginContext;
import org.dominokit.domino.api.server.plugins.IndexPageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AutoService(IndexPageProvider.class)
public class DynamicIndexPageProvider implements IndexPageProvider {

    public static final Logger LOGGER = LoggerFactory.getLogger(DynamicIndexPageProvider.class);
    private final JsonObject engineContext = new JsonObject();

    public DynamicIndexPageProvider(JsonObject engineContext) {
        this.engineContext.mergeIn(engineContext);
    }

    @Override
    public HttpServerResponse serveIndexPage(PluginContext context, RoutingContext routingContext, int statusCode) {
        LOGGER.info("Loading index page using dynamic index page loader...");
        FreeMarkerTemplateEngine engine = FreeMarkerTemplateEngine.create(context.getVertx());

        HttpServerResponse response = routingContext
                .response()
                .setStatusCode(statusCode)
                .putHeader("Content-type", "text/html");

        engine.render(engineContext
                , "templates/index.ftl", processedTemplate -> {
            if(processedTemplate.succeeded()) {
                String content = processedTemplate.result().toString();
                response.putHeader("Content-length", content.length() + "")
                .write(content);
                response.end();
            }else{
                response.end();
                LOGGER.error("failed to process index page template : ", processedTemplate.cause());
            }
        });

        return response;
    }

}
