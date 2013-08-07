package com.creamtec.techtalk.game.api;

import java.util.List;

/**
 * Represents processor for generation, regeneration and management of {@link Monster}.
 * <p>
 * {@link MonsterProcessor} should store generated {@link Monster} in an internal storage.
 * <p>
 * Implementation of {@link MonsterProcessor} should be initialized with the maze details before
 * using.
 */
public interface MonsterProcessor {

    /**
     * Method for initialization of a {@link MonsterProcessor} implementation.
     * <p>
     * {@link MonsterProcessor} implementation should know about the maze description.
     *
     * @param mazeDescription
     *            description of maze cells
     * @return <code>true</code>, if initialization of a {@link MonsterProcessor} has been performed
     *            successfully
     */
    boolean initialize(List<Cell> mazeDescription);

    /**
     * Perform recreation of {@link Monster} set.
     * <p>
     * Internal {@link Monster} storage should be updated on this method call.
     */
    void recreateMonsters();

    /**
     * Performs activation of life cycle of all the {@link Monster} from the internal storage.
     * <p>
     * Usual behavior should be processed for all the {@link Monster} from the internal storage on
     * this method call.
     */
    void refreshMonstersCycle();

    /**
     * Returns {@link Monster}, stored in an internal storage of the processor.
     *
     * @return {@link List} of {@link Monster}, stored in the processor.
     */
    List<Monster> getMonsters();

}
