package com.creamtec.techtalk.game.api;


/**
 * Represents timer, which should call processing of monsters lifecycle via
 * {@link MonsterProcessor}.
 * <p>
 * This timer is just an idea for UI developers. Game API does not require it.
 * It should be a kind of a separate thread or an object that is run in a separate thread.
 * <p>
 * In contrast to other interfaces, UI developer should implement and instantiate this.
 */
public interface MonsterTimer {

    /**
     * Method for initialization of a {@link MonsterTimer} implementation.
     * <p>
     * {@link MonsterTimer} implementation should know about the {@link MonsterProcessor}
     * implementation to call processing of monsters lifecycle.
     *
     * @param monsterProcessor
     *            the system implementation of {@link MonsterProcessor}
     */
    boolean initialize(MonsterProcessor monsterProcessor);

}
