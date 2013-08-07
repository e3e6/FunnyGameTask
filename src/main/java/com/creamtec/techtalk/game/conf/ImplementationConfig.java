package com.creamtec.techtalk.game.conf;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.creamtec.techtalk.game.api.FeedProcessor;
import com.creamtec.techtalk.game.api.GameProcessor;
import com.creamtec.techtalk.game.api.MazeGenerator;
import com.creamtec.techtalk.game.api.MonsterProcessor;

/**
 * Implementation configuration to link UI and game API implementation.
 * <p>
 * UI developer should use this class get access to API implementation.
 * UI developer have to create the instance of each processor and perform its initialization.
 * <p>
 * Game logic developer should fill in file "impl.properties" and provide it to UI developer.
 */
public final class ImplementationConfig {

    /**
     * Class logger.
     */
    private static final Logger LOGGER = Logger.getLogger(
            ImplementationConfig.class);

    private static final String IMPLEMENTATION_PROPERTIES =
            "/impl.properties";

    private static final String MAZE_GENERATOR_PROP_NAME =
            "app.maze.generator.class";

    private static final String GAME_PROCESSOR_PROP_NAME =
            "app.game.processor.class";

    private static final String MONSTER_PROCESSOR_PROP_NAME =
            "app.monster.processor.class";

    private static final String FEED_PROCESSOR_PROP_NAME =
            "app.feed.processor.class";

    private static Properties properties;

    private ImplementationConfig() {
        // Nothing inside
    };

    static {
        try {
            properties = new Properties();
            properties.load(ImplementationConfig.class
                    .getResourceAsStream(IMPLEMENTATION_PROPERTIES));
        } catch (IOException e) {
            LOGGER.error(e);
            throw new RuntimeException(
                    "Implementation configuration initialization exception", e);
        }
    }

    public static MazeGenerator getMazeGenerator() {
        return getImplClassInstance(MazeGenerator.class,
                MAZE_GENERATOR_PROP_NAME,
                "maze generator");
    }

    public static GameProcessor getGameProcessor() {
        return getImplClassInstance(GameProcessor.class,
                GAME_PROCESSOR_PROP_NAME,
                "game processor");
    }

    public static MonsterProcessor getMonsterProcessor() {
        return getImplClassInstance(MonsterProcessor.class,
                MONSTER_PROCESSOR_PROP_NAME,
                "monster processor");
    }

    public static FeedProcessor getFeedProcessor() {
        return getImplClassInstance(FeedProcessor.class,
                FEED_PROCESSOR_PROP_NAME,
                "feed processor");
    }

    @SuppressWarnings("unchecked")
    private static <T> T getImplClassInstance(Class<T> interfaze,
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
