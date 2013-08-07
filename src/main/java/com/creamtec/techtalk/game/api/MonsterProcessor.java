package com.creamtec.techtalk.game.api;

public interface MonsterProcessor {

    void recreateMonsters();

    void refreshMonstersCycle();

    Monster[] getMonsters();

}
