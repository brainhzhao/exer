package priv.zh.logframe.log4j;


import java.util.Hashtable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4jDemo{
    private final static Logger logger=LogManager.getLogger("Log4jDemo");
    public static void main(String[] args) {
        if(logger.isInfoEnabled()){
            logger.info("message");
        }
    }
}