package com.consolemenu;

import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Menu {
    private final List<String> mainMenu;
    private final List<String> lowerMenu;

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
                    } while (lowerMenuOption != lowerMenu.size() - 1);
                    break;
                }
            }
            if (menuOption == mainMenu.size() - 1) {
                System.out.println(mainMenu.get(menuOption));
            }
        } while (menuOption != mainMenu.size() - 1);
    }

    private void printMenu(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(i + ". " + strings.get(i));
        }
    }

    private int readInput(List<String> menu) {
        int result = 0;
        boolean isValid;

        do {
            printMenu(menu);

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            try {
                result = Integer.parseInt(line);
                if ((result + 1 > menu.size()) || (result < 0)) {
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
