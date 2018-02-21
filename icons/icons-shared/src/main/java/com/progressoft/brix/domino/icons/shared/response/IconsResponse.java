package com.progressoft.brix.domino.icons.shared.response;

import com.progressoft.brix.domino.api.shared.request.ResponseBean;

public class IconsResponse implements ResponseBean {

    private String serverMessage;

    public IconsResponse() {
    }

    public IconsResponse(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
}
