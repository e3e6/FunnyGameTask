package com.creamtec.techtalk.game.app;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.GameProcessor;
import com.creamtec.techtalk.game.api.MoveAction;

/**
 * 
 * @author alex
 *
 */
public class GameFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameCanvas canvas;
	private GameProcessor controller;
	/**
	 * Render timer
	 */
	private TimerTask renderTask = new TimerTask() {
		
		@Override
		public void run() {
			canvas.render();
		}
	};

	/**
	 * 
	 * @param model
	 * @param controller
	 * @param cellSize 
	 * @throws HeadlessException
	 */
	public GameFrame(List<Cell> model, GameProcessor controller, int cellSize) throws HeadlessException {
	
		this.controller = controller;
		this.canvas = new GameCanvas(model, cellSize);
		this.canvas.addKeyListener(this);
		
		this.add(canvas, BorderLayout.CENTER); 
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	/**
	 * Start rendering
	 * @param updateRate update screen rate in ms.
	 */
	public void start(long updateRate){
		new Timer().schedule(renderTask, new Date(), updateRate);
	}


	@Override
	public void keyPressed(KeyEvent e) {

		MoveAction move = null;
		
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_KP_LEFT:
	
				move = MoveAction.LEFT;
			break;
			
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_KP_RIGHT:

				move = MoveAction.RIGHT;
			break;
			
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:

				move = MoveAction.UP;
			break;
			
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:

				move = MoveAction.DOWN;
			break;

		default:
			break;
		}
		
		controller.movePlayer(move);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			if(JOptionPane.showConfirmDialog(this, "Do you really want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
