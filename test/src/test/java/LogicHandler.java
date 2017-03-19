package test.java;

import org.apache.log4j.Logger;


public class LogicHandler {
    protected static final Logger logger = Logger.getLogger(LogicHandler.class);

    public static void reset() {
        logger.info("LogicHandler.reset");
    }

    public static void update() {
        logger.info("LogicHandler.update");
    }

    public static String getBizType(){
        return "SEAT";
    }
}
