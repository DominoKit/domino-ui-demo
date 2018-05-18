package org.dominokit.domino.sample.shared.response;

import org.dominokit.domino.api.shared.request.ResponseBean;

public class SampleResponse implements ResponseBean {

    private String serverMessage;

    public SampleResponse() {
    }

    public SampleResponse(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
}
