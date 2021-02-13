import Dragon.*;

import java.io.*;
import java.util.*;

public class User {

    public static void inform() {

    }

    public static void help() {

    }

    public static void show() {

    }

    public static void add() {

    }

    public static void updateId() {

    }

    public static void removeById() {

    }

    public static void clear() {

    }

    public static void save() {

    }

    public static void executeScript() {

    }

    public static void exit() {

    }

    public static void removeFirst() {

    }

    public static void removeGreater() {

    }

    public static void history() {

    }

    public static void removeAnyByKiller() {

    }

    public static void printDescending() {

    }

    public static void printFieldDescendingAge() {

    }

    public static void fillFromFile(PriorityQueue<Dragon> arr) {
        // Parameters for Dragon

        String dragName = null;
        int dragAge = 0;
        String description = null;
        Long wingspan = null;
        DragonType type = null;

        //Coordinates

        long cordX = 0;
        float cordY = 0;

        //Person coordinate

        String personName = null;
        String date = null;
        Color eye = null;
        Color hair = null;
        Country nation = null;

        //Person location

        int locX = 0;
        Long locY = null;
        long locZ = 0;


        int counter = 0;
        int c;
        String text = "";
        InputStreamReader isr;

        // Initialize Input stream from file

        try {
            isr = new InputStreamReader(new FileInputStream("src/bank.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }


        do {
            try {
                c = isr.read();                     // trying to read one symbol from file
            } catch (IOException e) {
                System.out.println("Reading error");
                return;
            }
            if ((char) c != ',' && c != -1 && (char) c != '\r') text += (char)c;
            if ((char) c == ',' || (char) c == '\r') {
                boolean cond = text.equals("");
                switch(counter) {                                                   // defining each parameter for Dragon
                    case 0: dragName = text; break;                                 // including nulls
                    case 1: cordX = Long.parseLong(text); break;
                    case 2: cordY = Float.parseFloat(text); break;
                    case 3: dragAge = Integer.parseInt(text); break;
                    case 4: description = cond ? null : text; break;
                    case 5: wingspan = cond ? null : Long.parseLong(text); break;
                    case 6: type = cond ? null : DragonType.valueOf(text); break;
                    case 7: personName = cond ? null : text ; break;
                    case 8: date = cond ? null : text; break;
                    case 9: eye = cond ? null : Color.valueOf(text); break;
                    case 10: hair = cond ? null : Color.valueOf(text); break;
                    case 11: nation = cond ? null : Country.valueOf(text); break;
                    case 12: locX = cond ? 0 : Integer.parseInt(text); break;
                    case 13: locY = cond ? 0 : Long.parseLong(text); break;
                    case 14: locZ = cond ? 0 : Long.parseLong(text); break;
                }
                counter = ++counter % 15;
                text = "";
                if (counter == 0 && personName == null) {
                    arr.add(new Dragon(dragName, new Coordinates(cordX, cordY), dragAge, description, wingspan, type, null));
                }
                else if (counter == 0)
                    arr.add(new Dragon(dragName, new Coordinates(cordX, cordY), dragAge, description, wingspan, type, new Person(
                            personName, date, eye, hair, nation, new Location(locX, locY, locZ))));
            }
        } while (c != -1);

        try {
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void defineCommand() {
        Scanner sc = new Scanner(System.in);
        String command;
        do {
            System.out.print("Input a command: ");
            command = sc.nextLine();
            switch (command) {
                case "help": help(); break;
                case "info": inform(); break;
                case "show": show(); break;
                case "add": add(); break;
                case "update id": updateId(); break;
                case "remove_by_id": removeById(); break;
                case "clear": clear(); break;
                case "save": save(); break;
                case "execute_script": executeScript(); break;
                case "exit": exit(); break;
                case "remove_first": removeFirst(); break;
                case "remove_greater": removeGreater(); break;
                case "history": history(); break;
                case "remove_any_by_killer": removeAnyByKiller(); break;
                case "print_descending": printDescending(); break;
                case "print_field_descending": printFieldDescendingAge(); break;
                default:
                    System.out.println("Wrong command! Try again");
            }

        } while(!command.equals("exit"));
    }

    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Wrong files");
//            return;
//        }

        PriorityQueue<Dragon> arr = new PriorityQueue<>(new Comparator<Dragon>() {
            @Override
            public int compare(Dragon o1, Dragon o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        fillFromFile(arr);
        defineCommand();

        for (Dragon i : arr) {
            System.out.println(i);
        }


    }
}

