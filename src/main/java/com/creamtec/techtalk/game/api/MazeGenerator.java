package com.creamtec.techtalk.game.api;


/**
 * Representation of the application maze generator.
 */
public interface MazeGenerator {

    Cell[][] generateMaze(int horizontalCellCount, int verticalCellCount);

}
