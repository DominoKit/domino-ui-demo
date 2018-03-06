package com.progressoft.brix.domino.animation.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.animation.client.views.AnimationView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class AnimationPresenter extends BaseClientPresenter<AnimationView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnimationPresenter.class);

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    public void contributeToComponentCaseModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "animations";
            }

            @Override
            public String getMenuPath() {
                return "Animations";
            }

            @Override
            public String getIconName() {
                return "movie";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}