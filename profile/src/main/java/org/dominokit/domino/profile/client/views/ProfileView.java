package org.dominokit.domino.profile.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.layout.shared.extension.IsLayout;

public interface ProfileView extends ContentView {
    void setLayout(IsLayout layout);
}