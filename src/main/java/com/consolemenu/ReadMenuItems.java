package com.consolemenu;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadMenuItems {

    final static Logger logger = Logger.getLogger(ReadMenuItems.class);

    public static String[] getStrings(Path fileWithPath) {
        try {
            List<String> tmpList = Files.readAllLines(fileWithPath);
            String[] result = new String[tmpList.size()];
            tmpList.toArray(result);
            return result;
        } catch (IOException e) {
            logger.info("Error reading file");
            return new String[0];
        }
    }
}
