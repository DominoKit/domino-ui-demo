package org.dominokit.domino.uidemoserver.shared.response;

import org.dominokit.jacksonapt.annotation.JSONMapper;

@JSONMapper
public class UiDemoServerResponse {

    private String serverMessage;

    public UiDemoServerResponse() {
    }

    public UiDemoServerResponse(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
}
