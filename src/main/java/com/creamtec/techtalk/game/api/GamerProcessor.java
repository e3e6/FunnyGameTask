package com.creamtec.techtalk.game.api;

import java.awt.Point;

import javax.swing.Icon;

public interface GamerProcessor {

    boolean initialize(Cell[][] maze,
            MonsterProcessor monsterProcessor, FeedProcessor feedProcessor);

    void moveGamer(MoveAction action);

    Point getGamerPosition();

    Icon getGamerIcon();

    long getScore();

}
