package Input;

import Dragon.*;
import java.util.Scanner;

/**
 * Class {@code ConsoleInput} defines methods to work with an input from console.
 * Each method has a validation of User's input.
 */
public class ConsoleInput extends Input{

    /**
     * Constructs input class with console input as a source.
     */
    public ConsoleInput() {
        sc = new Scanner(System.in);
    }



    @Override
    public String inputDragonName() {
        String dragName;
        System.out.print("Enter the name: ");
        dragName = sc.nextLine();
        while (dragName.equals("") || dragName.equals("\n")) {
            System.out.println("Wrong name! Try again: ");
            dragName = sc.nextLine();
        }
        return dragName;
    }

    public Long inputXCord() {
        long cordX;
        System.out.print("Enter the X coordinate: ");
        while(true) {
            if (sc.hasNextLong()) {
                cordX = sc.nextLong();
                if (sc.nextLine().equals("") && cordX <= 302) break;
            }
            else {
                sc.nextLine();
            }
            System.out.print("Wrong coordinate! Try again: ");
        }
        return cordX;
    }

    public float inputYCord() {
        float cordY;
        System.out.print("Enter the Y coordinate: ");
        while(true) {
            if (sc.hasNextFloat()) {
                cordY = sc.nextFloat();
                if (sc.nextLine().equals("")) break;
            }
            else {
                sc.nextLine();
            }
            System.out.print("Wrong coordinate! Try again: ");
        }
        return cordY;
    }

    public int inputAge() {
        int dragAge;
        String temp;
        System.out.print("Enter the dragon's age: ");
        while(true) {
            temp = sc.nextLine();
            if (temp.matches("[1-9]\\d*")) {
                dragAge = Integer.parseInt(temp);
                break;
            }
            System.out.print("Wrong age format! Try again: ");
        }
        return dragAge;
    }

    public String inputDescription() {
        String description;
        System.out.print("Enter the dragon's description: ");
        description = sc.nextLine();
        if (description.equals(""))
            description = null;
        return  description;
    }

    public Long inputWingspan() {
        String temp;
        Long wingspan;

        System.out.print("Enter the dragon's wingspan: ");
        while(true) {
            temp = sc.nextLine();
            if (temp.matches("\\d*")) {
                if (temp.equals(""))
                    wingspan = null;
                else
                    wingspan = Long.parseLong(temp);
                break;
            }

            System.out.print("Wrong wingspan! Try again: ");
        }
        return wingspan;
    }

    public DragonType inputType() {
        String temp;
        DragonType type;

        System.out.print("Enter the dragon's type: (AIR, UNDERGROUND, FIRE, WATER) ");
        while(true) {
            temp = sc.nextLine();
            if (temp.toUpperCase().matches("AIR|UNDERGROUND|FIRE|WATER")) {
                type = DragonType.valueOf(temp.toUpperCase());
                break;
            }
            System.out.print("Wrong type format! Try again:");
        }
        return type;
    }

    public String inputKillerName() {
        System.out.print("Enter the killer's name: ");
        String personName = sc.nextLine();
        while (personName.equals("") || personName.equals("\n")) {
            System.out.println("Wrong name! Try again: ");
            personName = sc.nextLine();
        }
        return personName;
    }

    public String inputKilBirthday() {
        System.out.print("Enter the killer's birthday: (YYYY-MM-DD hh:mm:ss) ");
        String date;
        while(true) {
            date = sc.nextLine();
            if (date.matches("\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) " +
                    "(0[0-9]|1[0-9]|2[0-4]):([0-5]\\d):([0-5]\\d)"))
                return date;
            System.out.print("Try again: ");
        }
    }

    public Color inputKilEyeColor() {
        String temp;
        System.out.print("Enter the killer's eye color: (WHITE, RED, ORANGE, YELLOW, GREEN, BLACK) ");
        while(true) {
            temp = sc.nextLine();
            if (temp.toUpperCase().matches("WHITE|RED|ORANGE|YELLOW|GREEN|BLACK")) {
                return Color.valueOf(temp.toUpperCase());
            }
            System.out.print("Try again: ");
        }
    }

    public Color inputKilHairColor() {
        String temp;
        System.out.print("Enter the killer's hair color: (WHITE, RED, ORANGE, YELLOW, GREEN, BLACK) ");
        while(true) {
            temp = sc.nextLine();
            if (temp.toUpperCase().matches("WHITE|RED|ORANGE|YELLOW|GREEN|BLACK")) {
                return Color.valueOf(temp.toUpperCase());
            }
            System.out.print("Try again: ");
        }
    }

    public long inputKilZLoc() {
        long locZ;
        System.out.print("Enter the killer's Z location: ");
        while(true) {
            if (sc.hasNextLong()) {
                locZ = sc.nextLong();
                if (sc.nextLine().equals("")) break;
            }
            else
                sc.nextLine();
            System.out.print("Wrong coordinate! Try again: ");
        }
        return locZ;
    }

    public Long inputKilYLoc() {
        long locY;
        System.out.print("Enter the killer's Y location: ");
        while(true) {
            if(sc.hasNextLong()) {
                locY = sc.nextLong();
                if (sc.nextLine().equals("")) break;
            }
            else
                sc.nextLine();

            System.out.print("Wrong wingspan! Try again: ");
        }
        return locY;
    }

    public int inputKilXLoc() {
        int locX;
        System.out.print("Enter the killer's X location: ");
        while(true) {
            if (sc.hasNextInt()) {
                locX = sc.nextInt();
                if (sc.nextLine().equals("")) break;
            }
            else {
                sc.nextLine();
            }
            System.out.print("Wrong coordinate! Try again: ");
        }
        return locX;
    }

    public Country inputKilNation() {
        String temp;
        Country nation;
        System.out.print("Enter the killer's nationality: (ITALY, NORTH_KOREA, USA, INDIA, VATICAN) ");
        while(true) {
            temp = sc.nextLine();
            if (temp.toUpperCase().matches("ITALY|USA|VATICAN|NORTH_KOREA|INDIA")) {
                return Country.valueOf(temp.toUpperCase());
            }
            System.out.print("Try again: ");
        }
    }

    public boolean needKiller() {
        String ans;
        System.out.print("Is there a killer? (y/n) ");
        while(true) {
            ans = sc.nextLine();
            if (ans.matches("y|n"))
                switch(ans) {
                    case "y": return true;
                    case "n": return false;
                }
            System.out.print("Wrong answer format! ");
        }
    }

}
