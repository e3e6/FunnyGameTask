package com.creamtec.techtalk.game.api;

import java.awt.Color;

/**
 * Representation of the border for a cell.
 */
public interface CellBorder {

    /**
     * Indicates, if the cell has top border.
     *
     * @return true, if the cell has top border
     */
    public boolean hasTop();

    /**
     * Indicates, if the cell has right border.
     *
     * @return true, if the cell has right border
     */
    public boolean hasRight();

    /**
     * Indicates, if the cell has bottom border.
     *
     * @return true, if the cell has bottom border
     */
    public boolean hasBottom();

    /**
     * Indicates, if the cell has left border.
     *
     * @return true, if the cell has left border
     */
    public boolean hasLeft();

    /**
     * Returns border thickness for the cell in pixels.
     *
     * @return border thickness for the cell in pixels
     */
    public int getThickness();

    /**
     * Returns color of the cell borders.
     * <p>
     * Borders {@link Color} should be specified for a cell and can't be <code>null</code>.
     *
     * @return color of the cell borders
     */
    public Color getColor();

}
