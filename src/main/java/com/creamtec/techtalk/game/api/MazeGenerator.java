package com.creamtec.techtalk.game.api;

import java.util.List;

/**
 * Representation of the application maze generator.
 * <p>
 * Creates the maze description for the game. Note that single random is not acceptable, since
 * there should not be any unattainable areas, where feed or monsters can be generated.
 * <p>
 * Implementation of {@link MazeGenerator} should be able to generate maze with preferred size.
 * However, it is recommended to restrict possible sizes from 10x10 cells to 40x25 cells.
 */
public interface MazeGenerator {

    /**
     * Generates and returns description of a maze.
     *
     * @param horizontalCellCount
     *            required horizontal cells count of the maze
     * @param verticalCellCount
     *            required vertical cells count of the maze
     * @return generated description of the maze
     */
    List<Cell> generateMaze(int horizontalCellCount, int verticalCellCount);

}
