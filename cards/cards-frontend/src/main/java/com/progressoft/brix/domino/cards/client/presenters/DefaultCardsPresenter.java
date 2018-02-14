package com.progressoft.brix.domino.cards.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.cards.client.views.CardsView;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultCardsPresenter extends BaseClientPresenter<CardsView> implements CardsPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCardsPresenter.class);

    @Override
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/cards";
            }

            @Override
            public String getMenuPath() {
                return "Components/Cards";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}