package test.java;

import org.apache.log4j.Logger;


public class LogicHandler {
    private static final Logger logger = Logger.getLogger(LogicHandler.class);

    public static void reset() {
        logger.info("LogicHandler.reset");
    }

    public static void update(int num) {
        logger.info("LogicHandler.update "+num);
    }

    public static String getBizType(){
        return "SEAT";
    }

    public static String getSuiteFunctionValue(String param){
        return param;
    }

    public static String getGlobalFunctionValue(String param){
        return param;
    }
}
