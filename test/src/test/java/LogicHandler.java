package test.java;

import com.qa.framework.library.database.DBHelper;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

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
