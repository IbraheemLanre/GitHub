package com.Ibraheem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player ibra = new Player("Ibra", 10, 15);
        System.out.println(ibra.toString());
        saveObject(ibra);

        ibra.setHitPoints(8);
        System.out.println(ibra);
        ibra.setWeapon("Stormbringer");
        saveObject(ibra);
        //loadObject(ibra);
        System.out.println(ibra);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        saveObject(werewolf);

    }
    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean appMenu = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while(!appMenu) {
            System.out.println("Choose an option: ");
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 0:
                    appMenu = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }


}