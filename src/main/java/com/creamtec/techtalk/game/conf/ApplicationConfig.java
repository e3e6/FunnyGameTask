package com.creamtec.techtalk.game.conf;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.creamtec.techtalk.game.api.FeedProcessor;
import com.creamtec.techtalk.game.api.GamerProcessor;
import com.creamtec.techtalk.game.api.MazeGenerator;
import com.creamtec.techtalk.game.api.MonsterProcessor;

public final class ApplicationConfig {

    /**
     * Class logger.
     */
    private static final Logger LOGGER = Logger.getLogger(
            ApplicationConfig.class);

    private static final String APPLICATION_PROPERTIES =
            "/application.properties";

    private static final String MAZE_GENERATOR_PROP_NAME =
            "app.maze.generator.class";

    private static final String GAME_PROCESSOR_PROP_NAME =
            "app.game.processor.class";

    private static final String MONSTER_PROCESSOR_PROP_NAME =
            "app.monster.processor.class";

    private static final String FEED_PROCESSOR_PROP_NAME =
            "app.feed.processor.class";

    private static Properties properties;

    private ApplicationConfig() {
        // Nothing inside
    };

    static {
        try {
            properties = new Properties();
            properties.load(ApplicationConfig.class
                    .getResourceAsStream(APPLICATION_PROPERTIES));
        } catch (IOException e) {
            LOGGER.error(e);
            throw new RuntimeException(
                    "Application configuration initialization exception", e);
        }
    }

    public static MazeGenerator getMazeGenerator() {
        return getAppClassInstance(MazeGenerator.class,
                MAZE_GENERATOR_PROP_NAME,
                "maze generator");
    }

    public static GamerProcessor getGameProcessor() {
        return getAppClassInstance(GamerProcessor.class,
                GAME_PROCESSOR_PROP_NAME,
                "game processor");
    }

    public static MonsterProcessor getMonsterProcessor() {
        return getAppClassInstance(MonsterProcessor.class,
                MONSTER_PROCESSOR_PROP_NAME,
                "monster processor");
    }

    public static FeedProcessor getFeedProcessor() {
        return getAppClassInstance(FeedProcessor.class,
                FEED_PROCESSOR_PROP_NAME,
                "feed processor");
    }

    @SuppressWarnings("unchecked")
    private static <T> T getAppClassInstance(Class<T> interfaze,
            String propName,
            String onErrorLogFragment) {
        String className = properties.getProperty(propName);

        try {
            Class<?> clazz =  Class.forName(className);
            if (interfaze.isAssignableFrom(clazz)) {
                return (T) clazz.newInstance();
            } else {
                LOGGER.error("Wrong " + onErrorLogFragment
                        + " class was specified.");
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e);
            return null;
        }
    }

}
