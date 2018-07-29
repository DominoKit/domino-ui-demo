package org.dominokit.domino.fieldmasking.shared.request;

import org.dominokit.domino.api.shared.request.RequestBean;

public class FieldMaskingRequest implements RequestBean {

    private String message;

    public FieldMaskingRequest() {
    }

    public FieldMaskingRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
