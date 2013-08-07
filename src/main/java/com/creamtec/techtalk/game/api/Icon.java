package com.creamtec.techtalk.game.api;

import java.awt.Graphics;

/**
 * Representation of an icon for in-game objects.
 * <p>
 * It is recommended to have icon size eq or less than 32px.
 */
public interface Icon {

    /**
     * Returns real width of the icon in pixels.
     *
     * @return width of the icon in pixels
     */
    int getWidth();

    /**
     * Returns real height of the icon in pixels.
     *
     * @return height of the icon in pixels
     */
    int getHeight();

    /**
     * Draws icon on the specified {@link Graphics} starting from coordinates X and Y.
     *
     * @param g
     *            {@link Graphics} to draw the icon on it
     * @param x
     *            starting X-axis coordinates in pixels to draw the icon there
     * @param y
     *            starting Y-axis coordinates in pixels to draw the icon there
     */
    void drawIcon(Graphics g, int x, int y);

}
