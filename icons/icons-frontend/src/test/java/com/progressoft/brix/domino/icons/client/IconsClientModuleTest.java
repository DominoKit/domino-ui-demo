package com.progressoft.brix.domino.icons.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import com.google.gwtmockito.GwtMockitoTestRunner;

import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import com.progressoft.brix.domino.test.api.client.DominoTestClient;
import com.progressoft.brix.domino.test.api.client.ClientContext;
import com.progressoft.brix.domino.icons.client.presenters.IconsPresenter;
import com.progressoft.brix.domino.icons.client.requests.IconsServerRequest;
import com.progressoft.brix.domino.icons.shared.request.IconsRequest;
import com.progressoft.brix.domino.icons.shared.response.IconsResponse;
import com.progressoft.brix.domino.icons.client.presenters.IconsPresenterSpy;
import com.progressoft.brix.domino.icons.client.views.FakeIconsView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@ClientModule(name="TestIcons")
@RunWith(GwtMockitoTestRunner.class)
public class IconsClientModuleTest{

    private IconsPresenterSpy presenterSpy;
    private FakeIconsView fakeView;
    private ClientContext clientContext;

    @Before
    public void setUp() {
        presenterSpy = new IconsPresenterSpy();
        DominoTestClient.useModules(new IconsModuleConfiguration(), new TestIconsModuleConfiguration())
            .replacePresenter(IconsPresenter.class, presenterSpy)
            .viewOf(IconsPresenter.class, view -> fakeView= (FakeIconsView) view)
            .onStartCompleted(clientContext -> this.clientContext = clientContext)
            .start();
    }

    @Test
    public void givenIconsModule_whenContributingToMainExtensionPoint_thenShouldReceiveMainContext() {
        assertThat(presenterSpy.getMainContext()).isNotNull();
    }

    @Test
    public void givenIconsClientModule_whenIconsServerRequestIsSent_thenServerMessageShouldBeRecieved() {
        clientContext.forRequest(IconsServerRequest.class).returnResponse(new IconsResponse("Server message"));

        new IconsServerRequest(new IconsRequest("client message")).onSuccess(response -> assertThat(response.getServerMessage()).isEqualTo("Server message"))
        .onFailed(failedResponse -> fail(failedResponse.getError().getMessage()))
        .send();
    }
}
