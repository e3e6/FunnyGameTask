package com.creamtec.techtalk.game.api;

import java.awt.Point;

/**
 * Object that represents current information about the player.
 * <p>
 * UI developer should draw player on the maze image.
 */
public interface Player {

    /**
     * Returns current position of the player inside the maze.
     * <p>
     * Position is the location of the player inside maze, so X and Y are the coordinates of the
     * cell, where the player is currently located, and not the pixel coordinates.
     * <p>
     * Position should be specified and can't be <code>null</code>.
     *
     * @return position of the player inside the maze.
     */
    Point getPosition();

    /**
     * Return a special icon for the player.
     * <p>
     * Icon should be specified and can't be <code>null</code>.
     * <p>
     * Player icon should be drawn centered.
     * <p>
     * Note: prepare a player icon, based on the recommended {@link Cell} size.
     *
     * @return special icon for the player
     */
    Icon getIcon();

    /**
     * Returns the current game score of the player.
     * <p>
     * Player score should be drawn on the game frame.
     *
     * @return number representation of the current player score
     */
    long getScore();

}
