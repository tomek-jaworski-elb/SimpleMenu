package com.consolemenu;

import org.apache.log4j.Logger;

public class App {

    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        new Menu().start();
    }
}
