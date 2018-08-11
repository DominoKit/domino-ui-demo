package org.dominokit.domino.formsamples.shared.request;

import org.dominokit.domino.api.shared.request.RequestBean;

public class FormSamplesRequest implements RequestBean {

    private String message;

    public FormSamplesRequest() {
    }

    public FormSamplesRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
