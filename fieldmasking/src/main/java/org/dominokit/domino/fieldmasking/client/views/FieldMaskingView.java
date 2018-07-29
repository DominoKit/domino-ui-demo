package org.dominokit.domino.fieldmasking.client.views;

import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.api.shared.extension.Content;

public interface FieldMaskingView extends View {
    Content getContent();
}