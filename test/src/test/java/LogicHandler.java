package test.java;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/6/22.
 */
public class LogicHandler {
    protected static final Logger logger = Logger.getLogger(LogicHandler.class);

    public static void reset() {
        logger.info("LogicHandler.reset");
    }

    public static void update() {
        logger.info("LogicHandler.update");
    }
}
