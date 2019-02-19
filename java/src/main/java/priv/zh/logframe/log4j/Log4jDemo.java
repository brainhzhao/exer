package priv.zh.logframe.log4j;


import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo{
    private final static Logger logger=LogManager.getLogger("HelloWorld");
    public static void main(String[] args) {
        if(logger.isInfoEnabled()){
            logger.info("message");
        }
        
        logger.info("message");

    }
}