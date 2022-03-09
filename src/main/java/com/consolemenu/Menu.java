package com.consolemenu;

import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final static String[] mainMenu = {"Zamknij program", "Początek", "Środek", "LowerMenu 1", "LowerMenu 2"};
    private final static String[] lowerMenu = {"Wróć wyżej", "Podmenu 0", "Podmenu 1"};

    final static Logger logger = Logger.getLogger(Menu.class);

    private static final Path MAIN_MANU_LABELS = Paths.get("src", "main", "resources", "MainMenuItems.txt");
    private static final Path LOWER_MANU_LABELS = Paths.get("src", "main", "resources", "LowerMenuItems.txt");


 //   public Menu() {
//        String[] tmp1 = ReadMenuItems.getStrings(MAIN_MANU_LABELS);
//        if (Arrays.equals(tmp1, new String[0])) {
//            this.mainMenu = new String[0];
//            logger.info("Nie wczytano menu");
//        } else {
//            this.mainMenu = tmp1;
//        }
//        String[] tmp2 = ReadMenuItems.getStrings(LOWER_MANU_LABELS);
//        if (Arrays.equals(tmp2, new String[0])) {
//            this.lowerMenu = new String[0];
//            logger.info("Nie wczytano menu");
//        } else {
//            this.lowerMenu = tmp2;
//        }
//    }

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
        } while (menuOption != 0);
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
            try {
                String line = scanner.nextLine();
                if (line.isEmpty() || line.isBlank() || line.equals("\n")) {
                    throw new InputMismatchException("Empty string");
                }
                result = Integer.parseInt(line);
                if ((result + 1 > menu.length) || (result < 0)) {
                    throw new NumberFormatException();
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Podaj właściwą liczbę!");
                isValid = false;
            } catch (InputMismatchException e) {
                isValid = false;
            }
        } while (!isValid);
        return result;
    }

    private void printObject(Object object) {
        System.out.println(object + " -> " + object.getClass().getSimpleName());
    }

    private void inputSwitcherMainManu(int menuOption) {
        int lowerMenuOption1, lowerMenuOption2;
        switch (menuOption) {
            case 4: {
                printObject(menuOption);
                break;
            }
            case 1: {
                printObject(menuOption);
                break;
            }
            case 2: {
                do {
                    lowerMenuOption1 = readInput(lowerMenu);
                    inputSwitcherLowerMenu(lowerMenuOption1);
                } while (lowerMenuOption1 != 0);
                break;
            }
            case 3: {
                do {
                    lowerMenuOption2 = readInput(lowerMenu);
                    inputSwitcherLowerMenu(lowerMenuOption2);
                } while (lowerMenuOption2 != 0);
                break;
            }
        }
    }

    private void inputSwitcherLowerMenu(int lowerMenuOption) {
        switch (lowerMenuOption) {
            case 3: {
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
