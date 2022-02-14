package com.consolemenu;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadMenuItems {

    final static Logger logger = Logger.getLogger(App.class);

    public static List<String> getStrings(Path fileWithPath) {
        try {
            return Files.readAllLines(fileWithPath);
        } catch (IOException e) {
            logger.info("Error reading file");
            return null;
        }
    }
}
