package com.creamtec.techtalk.game.app;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.List;


import org.apache.log4j.Logger;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.CellBorder;
import com.creamtec.techtalk.game.api.Icon;
/**
 * Canvas to draw the Game
 * @author alex
 *
 */
public class GameCanvas extends Canvas {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Class logger.
     */
    private static final Logger LOGGER = Logger.getLogger(GameCanvas.class);

	private List<Cell> maze;
	
	/**
	 * Cell size in px
	 */
	private int cellSize;


	/**
	 * Canvas constructor
	 * @param maze maze description
	 * @param cellSize cell size
	 */
	public GameCanvas(List<Cell> maze, int cellSize) {
		this.maze = maze;
		this.cellSize = cellSize;
	}

	/**
	 * Render the maze on canvas
	 */
	public void render(){
		
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null){
			createBufferStrategy(2);
			requestFocus();
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		for(Cell cell: maze){
			g.setColor(cell.getBackgroundColor());
			
			CellBorder cellBorder = cell.getBorder();
			Point pos = cell.getPosition();
			
			int cellX = pos.x * cellSize;
			int cellY = pos.y * cellSize;
			
			//Draw Background color
			g.fillRect(cellX, cellY, cellSize, cellSize);
			
			//Draw cell border
			int borderThick = cellBorder.getThickness();
			
			if(borderThick > cellSize){
				borderThick = cellSize;
				LOGGER.error("Border of cell " + cell.getPosition() + " bigger than cell size.");
			}
			
			g.setColor(cellBorder.getColor());
			
			if(cellBorder.hasTop()){
				g.fillRect(cellX, cellY, cellSize, borderThick);
			}
			
			if(cellBorder.hasBottom()){
				g.fillRect(cellX, cellY + cellSize - borderThick, cellSize, borderThick);
			}
			
			if(cellBorder.hasLeft()){
				g.fillRect(cellX, cellY, borderThick, cellSize);
			}
			
			if(cellBorder.hasRight()){
				g.fillRect(cellX + cellSize - borderThick, cellY, borderThick, cellSize);
			}
			
			//DRaw Icon
			Icon icon = cell.getIcon();
			if(icon != null){
				icon.drawIcon(g, cellX, cellY);
			}
		}//end. for:cell
		
		g.dispose();
		bs.show();
	}

}
