package com.progressoft.brix.domino.icons.shared.request;

import com.progressoft.brix.domino.api.shared.request.RequestBean;

public class IconsRequest implements RequestBean {

    private String message;

    public IconsRequest() {
    }

    public IconsRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
