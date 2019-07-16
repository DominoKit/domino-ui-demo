package org.dominokit.domino.uidemoserver.client;

import org.dominokit.domino.api.client.annotations.ClientModule;
import org.dominokit.domino.test.api.client.ClientContext;
import org.dominokit.domino.test.api.client.annotations.FakeView;
import org.dominokit.domino.test.api.client.annotations.OnBeforeClientStart;
import org.dominokit.domino.test.api.client.annotations.PresenterSpy;
import org.dominokit.domino.test.api.client.annotations.TestConfig;
import org.dominokit.domino.test.api.client.DominoTestCase;
import org.dominokit.domino.test.api.client.DominoTestRunner;
import org.dominokit.domino.uidemoserver.client.presenters.UiDemoServerPresenterSpy;
import org.dominokit.domino.uidemoserver.client.presenters.UiDemoServerProxy;
import org.dominokit.domino.uidemoserver.shared.services.UiDemoServerServiceFactory;
import org.dominokit.domino.uidemoserver.client.views.FakeUiDemoServerView;
import org.dominokit.domino.uidemoserver.shared.request.UiDemoServerRequest;
import org.dominokit.domino.uidemoserver.shared.response.UiDemoServerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(DominoTestRunner.class)
@ClientModule(name = "TestUiDemoServer")
@TestConfig(modules= {UiDemoServerModuleConfiguration.class})
public class UiDemoServerClientModuleTest extends DominoTestCase{

    @PresenterSpy(UiDemoServerProxy.class)
    UiDemoServerPresenterSpy presenterSpy;

    @FakeView(UiDemoServerProxy.class)
    FakeUiDemoServerView fakeView;

    public UiDemoServerClientModuleTest() {
        super(new UiDemoServerClientModuleTest_Config());
    }

    @OnBeforeClientStart
    public void mockRequest(ClientContext clientContext) {
        clientContext.forRequest(UiDemoServerServiceFactory.UiDemoServerService_request.class)
            .returnResponse(new UiDemoServerResponse("Server message"));
    }

    @Test
    public void givenUiDemoServerModule_whenRoutingToUiDemoServer_thenShouldUiDemoServerProxy_PresenterShouldBeActivated() {
        clientContext.history().fireState("uidemoserver");
        assertThat(presenterSpy.isActivated()).isTrue();
    }

    @Test
    public void givenUiDemoServerClientModule_whenUiDemoServerServerRequestIsSent_thenServerMessageShouldBeRecieved() {
        UiDemoServerServiceFactory.INSTANCE.request(new UiDemoServerRequest("client message"))
                .onSuccess(response -> assertThat(response.getServerMessage()).isEqualTo("Server message"))
                .onFailed(failedResponse -> fail(failedResponse.getThrowable().getMessage()))
                .send();
    }
}