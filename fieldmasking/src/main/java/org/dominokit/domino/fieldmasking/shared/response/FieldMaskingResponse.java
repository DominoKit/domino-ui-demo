package org.dominokit.domino.fieldmasking.shared.response;

import org.dominokit.domino.api.shared.request.ResponseBean;

public class FieldMaskingResponse implements ResponseBean {

    private String serverMessage;

    public FieldMaskingResponse() {
    }

    public FieldMaskingResponse(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
}
