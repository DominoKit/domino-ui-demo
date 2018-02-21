package com.progressoft.brix.domino.icons.client.requests;

import com.progressoft.brix.domino.api.client.request.ServerRequest;
import com.progressoft.brix.domino.icons.shared.response.IconsResponse;
import com.progressoft.brix.domino.icons.shared.request.IconsRequest;
import com.progressoft.brix.domino.api.client.annotations.Request;
import com.progressoft.brix.domino.api.client.annotations.Path;


@Request
@Path("IconsRequest")
public class IconsServerRequest extends ServerRequest<IconsRequest, IconsResponse> {
    public IconsServerRequest(IconsRequest requestBean) {
        super(requestBean);
    }
}
