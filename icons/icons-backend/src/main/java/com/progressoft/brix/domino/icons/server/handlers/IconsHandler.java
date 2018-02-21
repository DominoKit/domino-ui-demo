package com.progressoft.brix.domino.icons.server.handlers;

import com.progressoft.brix.domino.api.server.handler.Handler;
import com.progressoft.brix.domino.api.server.handler.RequestHandler;
import com.progressoft.brix.domino.api.server.context.ExecutionContext;
import com.progressoft.brix.domino.icons.shared.response.IconsResponse;
import com.progressoft.brix.domino.icons.shared.request.IconsRequest;

import java.util.logging.Logger;

@Handler("IconsRequest")
public class IconsHandler implements RequestHandler<IconsRequest, IconsResponse> {
    private static final Logger LOGGER= Logger.getLogger(IconsHandler.class.getName());
    @Override
    public void handleRequest(ExecutionContext<IconsRequest, IconsResponse> executionContext) {
        LOGGER.info("message recieved from client : "+executionContext.getRequestBean().getMessage());
        executionContext.end(new IconsResponse("Server message"));
    }
}
