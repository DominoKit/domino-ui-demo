package com.progressoft.brix.domino.icons.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwtmockito.GwtMockitoTestRunner;
import com.google.gwtmockito.WithClassesToStub;
import com.progressoft.brix.domino.icons.client.presenters.IconsPresenterSpy;
import com.progressoft.brix.domino.icons.client.views.IconsViewSpy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;

import static org.junit.Assert.*;

import com.progressoft.brix.domino.icons.client.presenters.IconsPresenter;
import com.progressoft.brix.domino.test.api.client.DominoTestClient;

@RunWith(GwtMockitoTestRunner.class)
@WithClassesToStub(RootPanel.class)
public class IconsClientModuleTest{

    private IconsPresenterSpy presenterSpy;
    private IconsViewSpy viewSpy;

    @Before
    public void setUp() {
        presenterSpy = new IconsPresenterSpy();
        viewSpy = new IconsViewSpy();
        DominoTestClient.useModules(new IconsModuleConfiguration(), new IconsUIModuleConfiguration())
                .replacePresenter(IconsPresenter.class, presenterSpy)
                .replaceView(IconsPresenter.class, viewSpy)
                .start();
    }

    @Test
    public void nothing() throws Exception {

    }

}
