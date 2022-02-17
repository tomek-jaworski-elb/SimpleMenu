package com.consolemenu;

import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {
    private final String [] mainMenu;
    private final String [] lowerMenu;

    public Menu() {
        this.mainMenu = ReadMenuItems.getStrings(Paths.get("src","main","resources","MainMenuItems.txt"));
        this.lowerMenu = ReadMenuItems.getStrings(Paths.get("src","main","resources","LowerMenuItems.txt"));
    }

    public void start() {
        int menuOption;
        int lowerMenuOption;
        do {
            menuOption = readInput(mainMenu);
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
                    } while (lowerMenuOption != lowerMenu.length - 1);
                    break;
                }
            }
            if (menuOption == mainMenu.length - 1) {
                System.out.println(mainMenu[menuOption]);
            }
        } while (menuOption != mainMenu.length- 1);
    }

    private void printMenu(String [] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.println(i + ". " + strings[i]);
        }
    }

    private int readInput(String [] menu) {
        int result = 0;
        boolean isValid;

        do {
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

}
