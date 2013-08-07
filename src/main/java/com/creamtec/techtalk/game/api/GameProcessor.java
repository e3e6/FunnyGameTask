package com.creamtec.techtalk.game.api;

import java.awt.Point;
import java.util.List;

/**
 * Represents the main game processor.
 * <p>
 * Implementation of {@link GameProcessor} should manage game process and other auxiliary
 * processors.
 * <p>
 * Implementation of {@link GameProcessor} should be initialized before using.
 */
public interface GameProcessor {

    /**
     * Method for initialization of a {@link GameProcessor} implementation.
     * <p>
     * {@link GameProcessor} implementation should know about the maze description and other
     * auxiliary processors.
     *
     * @param mazeDescription
     *            description of maze cells
     * @param monsterProcessor
     *            reference to the system implementation of {@link MonsterProcessor}
     * @param feedProcessor
     *            reference to the system implementation of {@link FeedProcessor}
     * @return <code>true</code>, if initialization of a {@link GameProcessor} has been performed
     *            successfully
     */
    boolean initialize(List<Cell> mazeDescription,
            MonsterProcessor monsterProcessor, FeedProcessor feedProcessor);

    /**
     * Performs action of moving the gamer in the specified direction.
     * <p>
     * This method should be called by keyboard listeners of the game frame.
     *
     * @param action
     *            {@link MoveAction} to specify move direction
     */
    void moveGamer(MoveAction action);

    /**
     * Returns current position of the gamer inside the maze.
     * <p>
     * Position is the location of the gamer inside maze, so X and Y are the coordinates of the
     * cell, where the gamer is currently located, and not the pixel coordinates.
     * <p>
     * Position should be specified and can't be <code>null</code>.
     *
     * @return position of the gamer inside the maze.
     */
    Point getGamerPosition();

    /**
     * Return a special icon for the gamer.
     * <p>
     * Icon should be specified and can't be <code>null</code>.
     * <p>
     * Gamer icon should be drawn centered.
     * <p>
     * Note: prepare a gamer icon, based on the recommended {@link Cell} size.
     *
     * @return special icon for the gamer
     */
    Icon getGamerIcon();

    /**
     * Returns the current game score of the gamer.
     * <p>
     * Gamer score should be drawn on the game frame.
     *
     * @return number representation of the current gamer score
     */
    long getScore();

}
