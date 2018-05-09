package org.dominokit.domino.sample.shared.request;

import org.dominokit.domino.api.shared.request.RequestBean;

public class SampleRequest implements RequestBean {

    private String message;

    public SampleRequest() {
    }

    public SampleRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
