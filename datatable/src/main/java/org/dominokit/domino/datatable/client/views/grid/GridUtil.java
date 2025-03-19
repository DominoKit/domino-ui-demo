package org.dominokit.domino.datatable.client.views.grid;

public class GridUtil {
    /**
     * Builds a valid CSS grid-template-columns value based on
     * width, minWidth, and maxWidth.
     *
     * @param width    The default width (e.g. "300px", "50%", "auto", "1fr").
     *                 If null, "auto" is used.
     * @param minWidth The minimum width (e.g. "150px"), or null if not needed.
     * @param maxWidth The maximum width (e.g. "500px"), or null if not needed.
     * @return A valid CSS string for a single column in grid-template-columns.
     */
    public static String buildGridColumnValue(String width, String minWidth, String maxWidth) {
        // Normalize width: if null or empty, use "auto"
        if (width == null || width.trim().isEmpty()) {
            width = "auto";
        } else {
            width = width.trim();
        }

        // Trim minWidth and maxWidth if not null
        if (minWidth != null) {
            minWidth = minWidth.trim();
        }
        if (maxWidth != null) {
            maxWidth = maxWidth.trim();
        }

        // Case 1: No width, no min, no max → default "auto"
        if (width.equals("auto") && minWidth == null && maxWidth == null) {
            return "auto";
        }

        // Case 2: Only width is specified (and width is not "auto")
        if (!width.equals("auto") && minWidth == null && maxWidth == null) {
            return width;
        }

        // Case 3: Only minWidth is specified (width is auto, no max)
        if (width.equals("auto") && minWidth != null && maxWidth == null) {
            return "minmax(" + minWidth + ", auto)";
        }

        // Case 4: Width and minWidth are specified, no maxWidth
        if (!width.equals("auto") && minWidth != null && maxWidth == null) {
            return "minmax(" + minWidth + ", " + width + ")";
        }

        // Case 5: Only maxWidth is specified (width is auto, no min)
        if (width.equals("auto") && minWidth == null && maxWidth != null) {
            return "minmax(auto, " + maxWidth + ")";
        }

        // Case 6: Width and maxWidth are specified, no minWidth
        if (!width.equals("auto") && minWidth == null && maxWidth != null) {
            return "minmax(" + width + ", " + maxWidth + ")";
        }

        // Case 7: minWidth and maxWidth are specified, no width (width is auto)
        if (width.equals("auto") && minWidth != null && maxWidth != null) {
            return "minmax(" + minWidth + ", " + maxWidth + ")";
        }

        // Case 8: All three are specified (width is not "auto")
        if (!width.equals("auto") && minWidth != null && maxWidth != null) {
            return "clamp(" + minWidth + ", " + width + ", " + maxWidth + ")";
        }

        // Fallback (should not be reached)
        return width;
    }
}
