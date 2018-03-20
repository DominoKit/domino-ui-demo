package org.dominokit.domino.profile.client.views;

import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.layout.shared.extension.IsLayout;

public interface ProfileView extends View{
    void setLayout(IsLayout layout);
}