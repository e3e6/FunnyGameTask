package com.creamtec.techtalk.game.api;

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
     * Performs action of moving the player in the specified direction.
     * <p>
     * This method should be called by keyboard listeners of the game frame.
     *
     * @param action
     *            {@link MoveAction} to specify move direction
     */
    void movePlayer(MoveAction action);

    /**
     * Returns instance of {@link Player} with current info about the player object.
     *
     * @return {@link Player} with actual info about the player object
     */
    Player getPlayer();

}
