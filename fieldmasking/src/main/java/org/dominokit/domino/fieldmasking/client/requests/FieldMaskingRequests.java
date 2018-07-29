package org.dominokit.domino.fieldmasking.client.requests;

import org.dominokit.domino.api.client.annotations.Path;
import org.dominokit.domino.api.client.annotations.RequestFactory;
import org.dominokit.domino.api.client.request.Response;
import org.dominokit.domino.fieldmasking.shared.response.FieldMaskingResponse;
import org.dominokit.domino.fieldmasking.shared.request.FieldMaskingRequest;

@RequestFactory
public interface FieldMaskingRequests {
    @Path("FieldMaskingRequest")
    Response<FieldMaskingResponse> request(FieldMaskingRequest request);
}
