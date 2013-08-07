package com.creamtec.techtalk.game.app;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.creamtec.techtalk.game.api.MazeGenerator;
import com.creamtec.techtalk.game.conf.ApplicationConfig;

/**
 * The game entry point.
 */
public class Main {

    /**
     * Class logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MazeGenerator generator = null;
                try {
                    generator = ApplicationConfig.getMazeGenerator();
                } catch (Exception e) {
                    LOGGER.error(e);
                }

//                GameFrame frame = new GameFrame(generator);
//                frame.setVisible(true);
            }

        });
    }

}
