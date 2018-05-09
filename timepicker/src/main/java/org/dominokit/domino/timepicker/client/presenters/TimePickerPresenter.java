package org.dominokit.domino.timepicker.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsExtensionPoint;
import org.dominokit.domino.timepicker.client.views.TimePickerView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class TimePickerPresenter extends BaseClientPresenter<TimePickerView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimePickerPresenter.class);

    @InjectContext(extensionPoint=FormsExtensionPoint.class)
    public void contributeToFormsModule(FormsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "timepicker";
            }

            @Override
            public String getMenuPath() {
                return "Forms/Time picker";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}