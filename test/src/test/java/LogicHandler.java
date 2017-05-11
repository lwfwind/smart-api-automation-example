package test.java;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class LogicHandler {
    private static final Logger logger = Logger.getLogger(LogicHandler.class);

    public static void reset() {
        logger.info("LogicHandler.reset");
    }

    public static void update(int num) {
        logger.info("LogicHandler.update "+num);
    }

    public static void update(int num,boolean bool) {
        logger.info("LogicHandler.update "+num+" bool "+bool);
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

    public static Map<String,String> getSuiteFunctionMap(){
        Map<String,String> valueMap = new HashMap<>();
        valueMap.put("key","100");
        return valueMap;
    }

    public static Map<String,String> getGlobalFunctionMap(){
        Map<String,String> valueMap = new HashMap<>();
        valueMap.put("key","100");
        return valueMap;
    }
}
