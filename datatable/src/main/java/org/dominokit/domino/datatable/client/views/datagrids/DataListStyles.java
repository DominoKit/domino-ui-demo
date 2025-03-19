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

import org.dominokit.domino.ui.style.CssClass;

public interface DataListStyles {

  CssClass dui_datalist = () -> "dui-datalist";
  CssClass dui_datalist_search = () -> "dui-datalist-search";
  CssClass dui_datalist_search_box = () -> "dui-datalist-search-box";
  CssClass dui_datalist_sub_header = () -> "dui-datalist-subheader";
  CssClass dui_datalist_footer = () -> "dui-datalist-footer";
  CssClass dui_datalist_items_list = () -> "dui-datalist-items-list";
  CssClass dui_datalist_item = () -> "dui-datalist-item";
  CssClass dui_datalist_item_anchor = () -> "dui-datalist-item-anchor";
  CssClass dui_datalist_item_body = () -> "dui-datalist-item-body";
  CssClass dui_datalist_no_results = () -> "dui-datalist-no-results";
  CssClass dui_datalist_item_selected = () -> "dui-datalist-item-selected";
  CssClass dui_datalist_drop = () -> "dui-datalist-drop";
  CssClass dui_datalist_vscroll = () -> "dui-datalist-vscroll";

  CssClass dui_datalist_item_prefix = () -> "dui-datalist-item-prefix";
  CssClass dui_datalist_item_postfix = () -> "dui-datalist-item-postfix";
  CssClass dui_datalist_item_content = () -> "dui-datalist-item-content";
  CssClass dui_context_datalist = () -> "dui-context-datalist";

  CssClass dui_context_datalist_target_open = () -> "dui-context-datalist-target-open";
}
