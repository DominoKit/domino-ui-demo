package org.dominokit.domino.layout.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.layout.client.presenters.LayoutProxySlots;
import org.dominokit.domino.layout.shared.extension.IsLayout;

public interface LayoutView extends ContentView, IsLayout, LayoutProxySlots, IsLayout.GlobalLoader {
}