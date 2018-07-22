package org.dominokit.domino.datepicker.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.datepicker.client.views.DatePickerView;
import org.dominokit.domino.api.shared.extension.MainExtensionPoint;
import org.dominokit.domino.api.shared.extension.MainContext;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DatePickerPresenter extends ViewBaseClientPresenter<DatePickerView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatePickerPresenter.class);

    @InjectContext(extensionPoint=FormsExtensionPoint.class)
    public void contributeToFormsModule(FormsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "forms/datepicker";
            }

            @Override
            public String getMenuPath() {
                return "Forms/Date Picker";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}