package org.dominokit.domino.uidemoserver.client;

import org.dominokit.domino.api.client.annotations.ClientModule;
import org.dominokit.domino.test.api.client.annotations.PresenterSpy;
import org.dominokit.domino.test.api.client.annotations.TestConfig;
import org.dominokit.domino.test.api.client.DominoTestCase;
import org.dominokit.domino.test.api.client.DominoTestRunner;
import org.dominokit.domino.uidemoserver.client.presenters.UiDemoServerPresenterSpy;
import org.dominokit.domino.uidemoserver.client.presenters.UiDemoServerProxy;
import org.dominokit.domino.uidemoserver.client.views.UiDemoServerViewSpy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DominoTestRunner.class)
@ClientModule(name = "TestUiDemoServer")
@TestConfig(modules= {UiDemoServerModuleConfiguration.class})
public class UiDemoServerClientModuleTest extends DominoTestCase {

    @PresenterSpy(UiDemoServerProxy.class)
    UiDemoServerPresenterSpy presenterSpy;

    public UiDemoServerClientModuleTest() {
        super(new UiDemoServerClientModuleTest_Config());
    }

    @Test
    public void nothing() throws Exception {

    }

}
