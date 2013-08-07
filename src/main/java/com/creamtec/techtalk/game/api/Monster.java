package com.creamtec.techtalk.game.api;

import java.awt.Point;

/**
 * Represents any dynamic item that can interact with the player.
 * <p>
 * UI developer should draw monsters on the maze image.
 * <p>
 * This interface can be implemented to represent monsters, moving food or special
 * dynamic items that can affect gaming process
 */
public interface Monster {

    /**
     * Returns current position of the monster inside the maze.
     * <p>
     * Position is the location of the monster inside maze, so X and Y are the coordinates of the
     * cell, where monster is currently located, and not the pixel coordinates.
     * <p>
     * Position should be specified and can't be <code>null</code>.
     *
     * @return position of the monster inside the maze.
     */
    Point getPosition();

    /**
     * Returns monster type.
     * <p>
     * It is a point to show a bit of imagination. Monster type doesn't cause any effect to UI and
     * should be used for internal logic only. You should think of your own dictionary of monster
     * types.
     *
     * @return integer representation of monster type
     */
    int getType();

    /**
     * Return a special icon for the monster.
     * <p>
     * Icon should be specified and can't be <code>null</code>.
     * <p>
     * Monster icon should be drawn centered.
     * <p>
     * Note: prepare a monster icon, based on the recommended {@link Cell} size.
     *
     * @return special icon for the monster
     */
    Icon getIcon();

}
