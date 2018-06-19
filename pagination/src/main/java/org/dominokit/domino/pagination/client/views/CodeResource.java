package org.dominokit.domino.pagination.client.views;

public class CodeResource {

    public static String defaultPagination() {
        return "Pagination.create(5)\n" +
                "    .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber)";
    }

    public static String activePageSample() {
        return "Pagination.create(5)\n" +
                "        .markActivePage()\n" +
                "        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))\n" +
                "        .setActivePage(3)";
    }

    public static String sizesSample() {
        return "Pagination.create(5)\n" +
                "    .markActivePage()\n" +
                "    .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))\n" +
                "    .setActivePage(3)\n" +
                "    .large()\n" +
                "    .asElement();\n" +
                "\n" +
                "Pagination.create(5)\n" +
                "    .markActivePage()\n" +
                "    .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))\n" +
                "    .setActivePage(3)\n" +
                "    .asElement();\n" +
                "\n" +
                "Pagination.create(5)\n" +
                "    .markActivePage()\n" +
                "    .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))\n" +
                "    .setActivePage(3)\n" +
                "    .small()\n" +
                "    .asElement();";
    }

    public static String pagerSample() {
        return "Pager.create()\n" +
                "    .onNext(() -> DomGlobal.console.info(\"Going to next page.\"))\n" +
                "    .onPrevious(() -> DomGlobal.console.info(\"Going to previous page.\"))\n" +
                "    .asElement();\n" +
                "\n" +
                "Pager.create()\n" +
                "    .onNext(() -> DomGlobal.console.info(\"Going to next page.\"))\n" +
                "    .onPrevious(() -> DomGlobal.console.info(\"Going to previous page.\"))\n" +
                "    .nextText(\"Newer\")\n" +
                "    .previousText(\"Older\")\n" +
                "    .showArrows()\n" +
                "    .asElement();\n" +
                "\n" +
                "Pager.create()\n" +
                "    .onNext(() -> DomGlobal.console.info(\"Going to next page.\"))\n" +
                "    .onPrevious(() -> DomGlobal.console.info(\"Going to previous page.\"))\n" +
                "    .nextText(\"Newer\")\n" +
                "    .previousText(\"Older\")\n" +
                "    .showArrows()\n" +
                "    .expand()\n" +
                "    .asElement();\n" +
                "\n" +
                "Pager.create()\n" +
                "    .onNext(() -> DomGlobal.console.info(\"Going to next page.\"))\n" +
                "    .onPrevious(() -> DomGlobal.console.info(\"Going to previous page.\"))\n" +
                "    .nextText(\"Newer\")\n" +
                "    .previousText(\"Older\")\n" +
                "    .showArrows()\n" +
                "    .expand()\n" +
                "    .disablePrevious()\n" +
                "    .asElement();";
    }
}
