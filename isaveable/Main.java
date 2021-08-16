package isaveable;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author adder
 */
public class Main {

    public static void main(String[] args) {
        Player Dex = new Player("Dex", 6, 10);
        System.out.println(Dex.toString());
        saveObject(Dex);

        Dex.setHitPoints(8);
        System.out.println(Dex);
        Dex.setWeapon("Knife");
        saveObject(Dex);
        //  loadObject(Dex);
        System.out.println(Dex);
        ISaveable werewolf = new Monster("Werewolf", 20, 10);
        System.out.println(werewolf.toString());

        //Casting werewolf class as a monster class even though it's saved as an
        //isaveable interface
        System.out.println("Strength" + ((Monster) werewolf).getStrength());        //implementing the interface but it still is a monther class
        saveObject(werewolf);
    }

    public static ArrayList<String> readValues() {
        int index = 0;
        ArrayList<String> values = new ArrayList();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Choose\n"
                + "1 to enter a string \n"
                + "0 to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
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

    /**
     * This method save an object to a storage device. Once the object to save
     * implements an ISaveable object it can use to list<> method to preform
     * necessary actions.
     *
     * @param objectToSave
     */
    public static void saveObject(ISaveable objectToSave) {
        //determines the size by using the write() method
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i)
                    + " to storage device");
        }
    }

    /**
     * Loads the values from an object that implements the ISaveable interface
     *
     * @param objectToLoad
     */
    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        //read the value for the parameter
        objectToLoad.read(values);
    }
}
