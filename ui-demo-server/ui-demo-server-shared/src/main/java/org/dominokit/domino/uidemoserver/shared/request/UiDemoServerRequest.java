package org.dominokit.domino.uidemoserver.shared.request;

import org.dominokit.jacksonapt.annotation.JSONMapper;

@JSONMapper
public class UiDemoServerRequest {

    private String message;

    public UiDemoServerRequest() {
    }

    public UiDemoServerRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
