package com.creamtec.techtalk.game.api;

import java.awt.Point;

/**
 * Represents any static item that can interact with the player.
 * <p>
 * UI developer should draw feed on the maze image.
 * <p>
 * This interface can be implemented to represent food, jewelry, special consumable or special
 * static items that can affect gaming process.
 */
public interface Feed {

    /**
     * Returns position of the feed inside the maze.
     * <p>
     * Position is the location of the feed inside maze, so X and Y are the coordinates of the cell,
     * where feed is placed, and not the pixel coordinates.
     * <p>
     * Position should be specified and can't be <code>null</code>.
     *
     * @return position of the feed inside the maze.
     */
    Point getPosition();

    /**
     * Returns feed type.
     * <p>
     * It is a point to show a bit of imagination. Feed type doesn't cause any effect to UI and
     * should be used for internal logic only. You should think of your own dictionary of feed
     * types.
     *
     * @return integer representation of feed type
     */
    int getType();

    /**
     * Return a special icon for the feed.
     * <p>
     * Icon should be specified and can't be <code>null</code>.
     * <p>
     * Feed icon should be drawn centered.
     * <p>
     * Note: prepare a feed icon, based on the recommended {@link Cell} size.
     *
     * @return special icon for the feed
     */
    Icon getIcon();

}
