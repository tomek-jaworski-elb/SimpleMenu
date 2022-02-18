package com.consolemenu;

import org.apache.log4j.Logger;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private final String[] mainMenu;
    private final String[] lowerMenu;

    final static Logger logger = Logger.getLogger(Menu.class);


    private static final String[] PATH_MAIN_MENU = {"src", "main", "resources", "MainMenuItems.txt"};
    private static final String[] PATH_LOWER_MENU = {"src", "main", "resources", "LowerMenuItems.txt"};

    public Menu() {
        String[] tmp1 = ReadMenuItems.getStrings(Paths.get(PATH_MAIN_MENU[0], PATH_MAIN_MENU[1],
                PATH_MAIN_MENU[2], PATH_MAIN_MENU[3]));
        if (Arrays.equals(tmp1, new String[0])) {
            this.mainMenu = new String[0];
            logger.info("Nie wczytano menu");
        } else {
            this.mainMenu = tmp1;
        }
        String[] tmp2 = ReadMenuItems.getStrings(Paths.get(PATH_LOWER_MENU[0], PATH_LOWER_MENU[1],
                PATH_LOWER_MENU[2], PATH_LOWER_MENU[3]));
        if (Arrays.equals(tmp2, new String[0])) {
            this.lowerMenu = new String[0];
            logger.info("Nie wczytano menu");

        } else {
            this.lowerMenu = tmp2;
        }
    }

    public void start() {
        int menuOption;
        do {
            menuOption = readInput(mainMenu);
            if (menuOption < 0) {
                break;
            }
            inputSwitcherMainManu(menuOption);
            if (menuOption == mainMenu.length - 1) {
                System.out.println(mainMenu[menuOption]);
            }
        } while (menuOption != mainMenu.length - 1);
    }

    private void printMenu(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.println(i + ". " + strings[i]);
        }
    }

    private int readInput(String[] menu) {
        int result = 0;
        boolean isValid;

        do {
            if (menu.length == 0) {
                result = -1;
                break;
            }
            printMenu(menu);

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            try {
                result = Integer.parseInt(line);
                if ((result + 1 > menu.length) || (result < 0)) {
                    throw new NumberFormatException();
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Podaj właściwą liczbę!");
                isValid = false;
            }
        } while (!isValid);
        return result;
    }

    private void printObject(Object object) {
        System.out.println(object + " -> " + object.getClass().getSimpleName());
    }

    private void inputSwitcherMainManu(int menuOption) {
        int lowerMenuOption;
        switch (menuOption) {
            case 0: {
                printObject(menuOption);
                break;
            }
            case 1: {
                printObject(menuOption);
                break;
            }
            case 2: {
                do {
                    lowerMenuOption = readInput(lowerMenu);
                    inputSwitcheLowerMenu(lowerMenuOption);
                } while (lowerMenuOption != lowerMenu.length - 1);
                break;
            }
        }
    }

    private void inputSwitcheLowerMenu(int lowerMenuOption) {
        switch (lowerMenuOption) {
            case 0: {
                printObject(lowerMenuOption);
                break;
            }
            case 1: {
                printObject(lowerMenuOption);
                break;
            }
            case 2: {
                break;
            }
        }
    }
}
