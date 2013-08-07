package com.creamtec.techtalk.game.api;

import java.util.List;

/**
 * Represents processor for generation and regeneration of {@link Feed}.
 * <p>
 * {@link FeedProcessor} should store generated {@link Feed} in an internal storage.
 * <p>
 * Implementation of {@link FeedProcessor} should be initialized with the maze details before using.
 */
public interface FeedProcessor {

    /**
     * Method for initialization of a {@link FeedProcessor} implementation.
     * <p>
     * {@link FeedProcessor} implementation should know about the maze description.
     *
     * @param mazeDescription
     *            description of maze cells
     * @return <code>true</code>, if initialization of a {@link FeedProcessor} has been performed
     *            successfully
     */
    boolean initialize(List<Cell> mazeDescription);

    /**
     * Perform recreation of {@link Feed} set.
     * <p>
     * Internal {@link Feed} storage should be updated on this method call.
     */
    void regenerateFeed();

    /**
     * Returns {@link Feed}, stored in an internal storage of the processor.
     *
     * @return {@link List} of {@link Feed}, stored in the processor.
     */
    List<Feed> getFeed();

}
