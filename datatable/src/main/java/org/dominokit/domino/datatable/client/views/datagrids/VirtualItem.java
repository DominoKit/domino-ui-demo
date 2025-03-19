package org.dominokit.domino.datatable.client.views.datagrids;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.HasComponentMeta;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.Selectable;

import java.util.*;
import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class VirtualItem<T, I extends WindowItem<T>>
        implements HasComponentMeta<VirtualItem<T, I>>, Selectable<VirtualItem<T, I>>, HasSelectionListeners<VirtualItem<T, I>,VirtualItem<T, I>, T> {

    private I windowItem;
    private T record;
    private VirtualScrollItemMapper<T, I> mapper;
    private Map<String, ComponentMeta> metaObjects;
    private boolean selected;
    private boolean selectable = true;
    private boolean selectionListenersPaused = false;
    private Set<SelectionListener<? super VirtualItem<T, I>, ? super T>> selectionListeners;
    private Set<SelectionListener<? super VirtualItem<T, I>, ? super T>> deselectionListeners;

    public VirtualItem(T record, VirtualScrollItemMapper<T, I> mapper) {
        this.record = record;
        this.mapper = mapper;
    }

    public VirtualItem<T, I> select(){
        return select(isSelectionListenersPaused());
    }

    public VirtualItem<T, I> deselect(){
        return deselect(isSelectionListenersPaused());
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public VirtualItem<T, I> setSelected(boolean selected) {
        setSelected(selected, isSelectionListenersPaused());
        return this;
    }

    @Override
    public VirtualItem<T, I> select(boolean silent) {
        if(isSelectable()) {
            this.selected = true;
            ifItemPresent(i -> i.onSelectionChanged(this.selected));
            if (!silent) {
                triggerSelectionListeners(this, this.record);
            }
        }
        return this;
    }

    @Override
    public VirtualItem<T, I> deselect(boolean silent) {
        if(isSelectable()) {
            this.selected = false;
            ifItemPresent(i -> i.onSelectionChanged(this.selected));
            if (!silent) {
                triggerDeselectionListeners(this, this.record);
            }
        }
        return this;
    }

    @Override
    public boolean isSelectable() {
        return selectable;
    }

    @Override
    public VirtualItem<T, I> setSelectable(boolean selectable) {
        this.selectable = selectable;
        return this;
    }

    @Override
    public VirtualItem<T, I> setSelected(boolean selected, boolean silent) {
        if(selected){
            select(silent);
        }else {
            deselect(silent);
        }
        return this;
    }

    @Override
    public VirtualItem<T, I> pauseSelectionListeners() {
        this.selectionListenersPaused = true;
        return this;
    }

    @Override
    public VirtualItem<T, I> resumeSelectionListeners() {
        this.selectionListenersPaused = false;
        return this;
    }

    @Override
    public VirtualItem<T, I> togglePauseSelectionListeners(boolean toggle) {
        this.selectionListenersPaused = toggle;
        return this;
    }

    @Override
    public Set<SelectionListener<? super VirtualItem<T, I>, ? super T>> getSelectionListeners() {
        if(isNull(this.selectionListeners)) {
            this.selectionListeners = new HashSet<>();
        }
        return this.selectionListeners;
    }

    @Override
    public Set<SelectionListener<? super VirtualItem<T, I>, ? super T>> getDeselectionListeners() {
        if(isNull(this.deselectionListeners)) {
            this.deselectionListeners = new HashSet<>();
        }
        return this.deselectionListeners;
    }

    @Override
    public boolean isSelectionListenersPaused() {
        return this.selectionListenersPaused;
    }

    @Override
    public VirtualItem<T, I> triggerSelectionListeners(VirtualItem<T, I> source, T selection) {
        if(!selectionListenersPaused) {
            this.getSelectionListeners().forEach(listener -> listener.onSelectionChanged(Optional.ofNullable(source), this.record));
        }
        return this;
    }

    @Override
    public VirtualItem<T, I> triggerDeselectionListeners(VirtualItem<T, I> source, T selection) {
        if(!selectionListenersPaused) {
            getDeselectionListeners().forEach(listener -> listener.onSelectionChanged(Optional.ofNullable(source), this.record));
        }
        return this;
    }

    @Override
    public T getSelection() {
        return this.record;
    }

    public I windowItem() {
        if (isNull(windowItem)) {
            this.windowItem = mapper.map(record);
            this.windowItem.setVirtualItem((VirtualItem<T, WindowItem<T>>) this);
            this.windowItem.onSelectionChanged(isSelected());
        }
        return windowItem;
    }

    public void ifItemPresent(Consumer<I> consumer) {
        if(nonNull(windowItem)) {
            consumer.accept(windowItem);
        }
    }

    public T getRecord() {
        return record;
    }

    @Override
    public Map<String, ComponentMeta> getMetaObjects() {
        if (isNull(metaObjects)) {
            metaObjects = new HashMap<>();
        }
        return this.metaObjects;
    }

}
