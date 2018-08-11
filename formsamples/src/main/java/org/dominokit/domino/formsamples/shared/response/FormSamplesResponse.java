package org.dominokit.domino.formsamples.shared.response;

import org.dominokit.domino.api.shared.request.ResponseBean;

public class FormSamplesResponse implements ResponseBean {

    private String serverMessage;

    public FormSamplesResponse() {
    }

    public FormSamplesResponse(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
}
