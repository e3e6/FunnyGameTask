package com.creamtec.techtalk.game.api;

import java.awt.Color;
import java.awt.Point;

/**
 * Representation of a maze cell.
 * <p>
 * UI developer should draw maze by cells.
 * <p>
 * Recommended cell size is 32px.
 */
public interface Cell {

    /**
     * Returns position of the cell inside the maze.
     * <p>
     * Position is the location of the cell inside maze, so X and Y are the coordinates of the cell
     * inside the maze grid, and not the pixel coordinates.
     * <p>
     * Position should be specified and can't be <code>null</code>.
     *
     * @return position of the cell inside the maze.
     */
    Point getPosition();

    /**
     * Returns cell type.
     * <p>
     * It is a point to show a bit of imagination. Cell type doesn't cause any effect to UI and
     * should be used for internal logic only. You should think of your own dictionary of cell
     * types.
     *
     * @return integer representation of cell type
     */
    int getType();

    /**
     * Return configuration of cell borders.
     * <p>
     * CellBorder should be specified and can't be <code>null</code>.
     * <p>
     * See {@link CellBorder} for more details.
     *
     * @return configuration of cell borders.
     */
    CellBorder getBorder();

    /**
     * Return background color of the cell.
     * <p>
     * Background {@link Color} should be specified and can't be <code>null</code>.
     *
     * @return background color of the cell.
     */
    Color getBackgroundColor();

    /**
     * Return a special icon for the cell.
     * <p>
     * Icon can be unspecified for the cell.
     * <p>
     * If an icon is specified, it should be drawn over the cell's borders and background.
     * If icon size is less, than cell size, the icon should be drawn centered.
     *
     * @return special icon for the cell or <code>null</code>, if no icon specified for the cell.
     */
    Icon getIcon();

}
