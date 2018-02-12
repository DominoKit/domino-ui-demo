package com.progressoft.brix.domino.componentcase.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.extension.ContextAggregator;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.history.TokenFilter;
import com.progressoft.brix.domino.componentcase.client.views.CompponentCaseView;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.menu.shared.extension.MenuContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.progressoft.brix.domino.menu.shared.extension.MenuContext.*;
import static java.util.Objects.isNull;

@Presenter
public class DefaultComponentCasePresenter extends BaseClientPresenter<CompponentCaseView> implements ComponentCasePresenter, ComponentCaseContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultComponentCasePresenter.class);

    private ContextAggregator.ContextWait<MenuContext> menuContext = ContextAggregator.ContextWait.create();
    private ContextAggregator.ContextWait<LayoutContext> layoutContext = ContextAggregator.ContextWait.create();

    @Override
    public void initView(CompponentCaseView view) {
        ContextAggregator.waitFor(menuContext).and(layoutContext).onReady(() -> {
            view.init(layoutContext.get().getLayout());
            applyContributions(ComponentCaseExtensionPoint.class, () -> DefaultComponentCasePresenter.this);
        });
    }

    public class MenuBranch {
        private final String title;
        private final CanAddMenuItem menuItem;
        private final Map<String, MenuBranch> leaves = new HashMap<>();

        public MenuBranch(String title, CanAddMenuItem menuItem) {
            this.title = title;
            this.menuItem = menuItem;
        }
    }

    private Map<String, MenuBranch> roots = new HashMap<>();

    @Override
    public void contributeToMenuModule(MenuContext context) {
        menuContext.receiveContext(context);
    }

    @Override
    public void contributeToLayoutModule(LayoutContext context) {
        layoutContext.receiveContext(context);
    }

    @Override
    public void addDemoPage(ComponentCase componentCase) {

        boolean rootPage = componentCase.getMenuPath().split("/").length <= 1;
        if (componentCase.hasContent()) {
            history().listen(TokenFilter.exactMatch(componentCase.getHistoryToken()), state -> {
                showPage(componentCase);
            }).onDirectUrl(state -> {
                showPage(componentCase);
            });
        }

        if (rootPage) {
            addRootPage(componentCase);
        } else {
            addSubPage(componentCase);
        }

    }

    private void addSubPage(ComponentCase componentCase) {
        String[] pathElements = componentCase.getMenuPath().split("/");
        if (isNull(roots.get(pathElements[0])))
            throw new NoRootMenuException("No root menu : " + pathElements[0]);

        MenuBranch root = roots.get(pathElements[0]);
        for (int index = 1; index < pathElements.length - 1; index++) {
            root = getOrAddMenuBranch(root, pathElements[index]);
        }

        addSubPageToRoot(pathElements[pathElements.length-1], componentCase, root);

    }

    private void addSubPageToRoot(String path, ComponentCase componentCase, MenuBranch root) {
        CanAddMenuItem canAddMenuItem;
        if (componentCase.hasContent()) {
            canAddMenuItem = root.menuItem.addMenuItem(path, () -> {
                history().pushState(componentCase.getHistoryToken());
                showPage(componentCase);
            });
        } else {
            canAddMenuItem = root.menuItem.addMenuItem(path);
        }

        root.leaves.put(path, new MenuBranch(path, canAddMenuItem));
    }

    private MenuBranch getOrAddMenuBranch(MenuBranch root, String pathElement) {
        if (!root.leaves.containsKey(pathElement)) {
            CanAddMenuItem menuItem = root.menuItem.addMenuItem(pathElement);
            root.leaves.put(pathElement, new MenuBranch(pathElement, menuItem));
        }

        return root.leaves.get(pathElement);
    }

    private void addRootPage(ComponentCase componentCase) {
        CanAddMenuItem canAddMenuItem;
        if (componentCase.hasContent()) {
            canAddMenuItem = menuContext.get().addMenuItem(componentCase.getMenuPath(), componentCase.getIconName(), () -> {
                history().pushState(componentCase.getHistoryToken());
                showPage(componentCase);
            });
        } else {
            canAddMenuItem = menuContext.get().addMenuItem(componentCase.getMenuPath(), componentCase.getIconName());
        }

        roots.put(componentCase.getMenuPath(), new MenuBranch(componentCase.getMenuPath(), canAddMenuItem));
    }

    private void showPage(ComponentCase componentCase) {
        view.clear();
        layoutContext.get().getLayout().hideLeftPanel();
        componentCase.showIn(layoutContext.get().getLayout().getContentPanel());
    }

    private class NoRootMenuException extends RuntimeException {
        public NoRootMenuException(String message) {
            super(message);
        }
    }
}