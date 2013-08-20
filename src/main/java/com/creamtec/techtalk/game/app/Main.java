package com.creamtec.techtalk.game.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.creamtec.techtalk.game.api.Cell;
import com.creamtec.techtalk.game.api.FeedProcessor;
import com.creamtec.techtalk.game.api.GameProcessor;
import com.creamtec.techtalk.game.api.MazeGenerator;
import com.creamtec.techtalk.game.api.MonsterProcessor;
import com.creamtec.techtalk.game.conf.ImplementationConfig;

/**
 * The game entry point.
 */
public class Main {

    /**
     * Class logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
    	
    	final ScreenSettings settingsScreen = new ScreenSettings();
    	
    	
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MazeGenerator generator = null;
                GameProcessor gameProcessor = null;
                FeedProcessor feedProcessor = null;
                MonsterProcessor monsterProcessor = null;
                
                try {
                    generator = ImplementationConfig.getMazeGenerator(); 
                    
                    gameProcessor = ImplementationConfig.getGameProcessor();
                    feedProcessor = ImplementationConfig.getFeedProcessor();
                    monsterProcessor = ImplementationConfig.getMonsterProcessor();

                } catch (Exception e) {
                    LOGGER.error(e);
                }
                
                // Read Settings
                
                Dimension screenDimension = settingsScreen.getScreenDimension();
                boolean isFullscreen = settingsScreen.isFullscreen();
                int cellSize = settingsScreen.getCellSize();
                int refreshRate = settingsScreen.getRefreshRate();
                
                settingsScreen.dispose();
                
                if(isFullscreen){
                	screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
                }
                
                
                //Init Game
            	int hCellCount = screenDimension.width/cellSize;
        		int wCellCount = screenDimension.height/cellSize;       		
        		
        		List<Cell> mazeDescription = generator.generateMaze(wCellCount, hCellCount);
        		
        		boolean initReady = true;
        		
        		initReady = initReady && feedProcessor.initialize(mazeDescription);
        		initReady = initReady && monsterProcessor.initialize(mazeDescription);       		
        		initReady = initReady && gameProcessor.initialize(mazeDescription, monsterProcessor, feedProcessor);
        		
        		
        		//Show
        		if(initReady){
        			GameFrame frame = new GameFrame(mazeDescription, gameProcessor, cellSize);
                		              		      
					if(isFullscreen){
						frame.setUndecorated(true);
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					} else {
						frame.setSize(screenDimension);
					}
                		      
                	frame.setVisible(true);	      
					frame.start(refreshRate);			  
					
        		} else {
        			JOptionPane.showMessageDialog(null, "The Game wasn't initialized properly. \n See logs for detail.");
        		}

                
            }

        });
    }

}
