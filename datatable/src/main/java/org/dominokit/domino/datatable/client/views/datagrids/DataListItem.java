/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.datatable.client.views.datagrids;

import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.menu.MenuSearchFilter;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.span;

/**
 * Represents a menu item that can be added to a menu. Each menu item can have a text and an
 * optional description.
 *
 * @param <V> the type of value associated with this menu item
 */
public class DataListItem<V> extends AbstractDataListItem<V> {

  private SpanElement textElement;

  /**
   * Constructs a menu item with the specified text.
   *
   * @param text the text for the menu item
   */
  public DataListItem(String text, V value) {
    super(value);
    if (nonNull(text) && !text.isEmpty()) {
      textElement = span().addCss(dui_datalist_item_content).setTextContent(text);
      appendChild(textElement);
    }
  }

  /**
   * Creates a menu item with the specified text.
   *
   * @param text the text for the menu item
   * @return the created menu item
   */
  public static <V> DataListItem<V> create(String text, V value) {
    return new DataListItem<>(text, value);
  }

  /**
   * Applies a custom child handler to the link element of this menu item
   *
   * @param handler The child handler to apply.
   * @return This menu item instance.
   */
  public DataListItem<V> withClickableElement(ChildHandler<DataListItem<V>, AnchorElement> handler) {
    handler.apply(this, linkElement);
    return this;
  }

  @Override
  public boolean startsWith(String character) {
    String textContent = Optional.ofNullable(textElement)
            .map(BaseDominoElement::getTextContent)
            .orElse("");

    if (textContent.isEmpty()) {
      return false;
    }
    return textContent.toLowerCase().startsWith(character.toLowerCase());
  }

  /**
   * Retrieves the text element of the menu item.
   *
   * @return the text element
   */
  public SpanElement getTextElement() {
    return textElement;
  }

  @Override
  public ZIndexLayer getZIndexLayer() {
    ZIndexLayer layer = parent.getZIndexLayer();
    return layer;
  }

}
