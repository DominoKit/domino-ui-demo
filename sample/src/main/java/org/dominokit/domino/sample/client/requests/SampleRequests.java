package org.dominokit.domino.sample.client.requests;

import org.dominokit.domino.api.client.annotations.Path;
import org.dominokit.domino.api.client.annotations.RequestFactory;
import org.dominokit.domino.api.client.request.Response;
import org.dominokit.domino.sample.shared.response.SampleResponse;
import org.dominokit.domino.sample.shared.request.SampleRequest;

@RequestFactory
public interface SampleRequests {
    @Path("SampleRequest")
    Response<SampleResponse> request(SampleRequest request);
}
