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

package org.dominokit.domino.datatable.client.views.gridtable;

import org.dominokit.domino.ui.style.CssClass;

public interface DataTableStyles {

  CssClass dui_datatable = () -> "dui-gridtable";

  CssClass dui_datatable_responsive = () -> "dui-gridtable-responsive";

  CssClass dui_datatable_hover = () -> "dui-gridtable-hover";

  CssClass dui_datatable_bordered = () -> "dui-gridtable-bordered";

  CssClass dui_datatable_condensed = () -> "dui-gridtable-condensed";

  CssClass dui_datatable_striped = () -> "dui-gridtable-striped";

  CssClass dui_datatable_width_full = () -> "dui-gridtable-width-full";

  CssClass dui_datatable_fixed = () -> "dui-gridtable-fixed";

  CssClass dui_datatable_row = () -> "dui-gridtable-row";

  CssClass dui_datatable_th = () -> "dui-gridtable-th";

  CssClass dui_datatable_td = () -> "dui-gridtable-td";

  CssClass dui_datatable_thead = () -> "dui-gridtable-thead";

  CssClass dui_datatable_sticky_header = () -> "dui-gridtable-sticky-header";

  CssClass dui_datatable_body = () -> "dui-gridtable-body";

  CssClass dui_datatable_tfoot = () -> "dui-gridtable-tfoot";

  CssClass dui_datatable_row_marker = () -> "dui-gridtable-row-marker";

  CssClass dui_datatable_nav_bar = () -> "dui-gridtable-nav-bar";

  CssClass dui_datatable_row_selected = () -> "dui-gridtable-row-selected";

  CssClass dui_datatable_th_body = () -> "dui-gridtable-th-body";

  CssClass dui_datatable_th_title = () -> "dui-gridtable-th-title";

  CssClass dui_datatable_th_menu_icon = () -> "dui-gridtable-th-menu-icon";

  CssClass dui_datatable_utility_elements = () -> "dui-gridtable-utility-elements";

  CssClass dui_datatable_utility_element = () -> "dui-gridtable-utility-element";

  CssClass dui_datatable_column_utility = () -> "dui-gridtable-column-utility";

  CssClass dui_datatable_search_box = () -> "dui-gridtable-search-box";

  CssClass dui_datatable_details_td = () -> "dui-gridtable-details-td";

  CssClass dui_datatable_details_tr = () -> "dui-gridtable-details-tr";

  CssClass dui_datatable_column_filter = () -> "dui-gridtable-column-filter";

  CssClass dui_datatable_row_editable = () -> "dui-gridtable-row-editable";

  CssClass dui_row_dnd_grab = () -> "dui-row-dnd-grab";

  CssClass dui_datatable_drop_area = () -> "dui-gridtable-drop-area";

  CssClass dui_datatable_drop_row = () -> "dui-gridtable-drop-row";

  CssClass table_row_filtered = () -> "table-row-filtered";

  CssClass fixed_width = () -> "fixed-width";

  CssClass header = () -> "table-header";

  CssClass dui_column_resizer = () -> "dui-column-resizer";
}
