import Dragon.*;

import java.io.*;
import java.util.*;

public class Processor {

    PriorityQueue<Dragon> arr = new PriorityQueue<>(new Comparator<Dragon>() {
        @Override
        public int compare(Dragon o1, Dragon o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    Long id = 0L;
    String dragName = null;
    int dragAge = 0;
    String creationTime = null;
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

    Scanner sc = new Scanner(System.in);

    public void inform() {

    }

    public void help() {

    }

    public void show() {

    }

    public void add() {

    }

    public void updateId() {
        long id = 0;

        try {
            id = sc.nextLong();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Wrong id format!");
            sc.next();
            return;
        }

        if (id < 0) {
            System.out.println("Wrong id format!");
            return;
        }

        boolean flag = false;
        for (Dragon i : arr) {
            if (i.getId() == id) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("No dragon with such id!");
            return;
        }

        System.out.print("Enter the name: ");
        dragName = sc.nextLine();
        while (dragName.equals("") || dragName.equals("\s")) {
            System.out.println("Wrong name! Try again: ");
            dragName = sc.nextLine();
        }

        System.out.print("Enter the X coordinate: ");
        try {
            cordX = sc.nextLong();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Wrong coordinate! Try again: ");
            sc.nextLine();
        }
        System.out.print("Enter the Y coordinate: ");



        System.out.print("Enter the dragon's age: ");
        System.out.print("Enter the dragon's description: ");
        System.out.print("Enter the dragon's wingspan: ");
        System.out.print("Enter the dragon's type: (AIR, UNDERGROUND, FIRE, WATER) ");
        System.out.print("Enter the killer's name: ");
        System.out.print("Enter the killer's birthday: (YYYY-MM-DD hh-mm-ss) ");
        System.out.print("Enter the killer's hair color: (WHITE, RED, ORANGE, YELLOW, GREEN, BLACK) ");
        System.out.print("Enter the killer's nationality: (ITALY, NORTH_KOREA, USA, INDIA, VATICAN) ");
        System.out.print("Enter the killer's X location: ");
        System.out.print("Enter the killer's Y location: ");
        System.out.print("Enter the killer's Z location: ");


    }

    public void removeById() {
        long id = 0;
        try {
            id = sc.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("Wrong id format!");
            sc.nextLine();
        }

        if (id < 0) {
            System.out.println("Wrong id format!");
            return;
        }

        for (Dragon i : arr) {
            if (i.getId() == id)
                arr.remove(i);
        }

    }

    public void clear() {

    }

    public void save() {

    }

    public void executeScript() {

    }

    public void exit() {

    }

    public void removeFirst() {
        arr.poll();
    }

    public void removeGreater() {

    }

    public void history() {

    }

    public void removeAnyByKiller() {

    }

    public void printDescending() {

    }

    public void printFieldDescendingAge() {

    }

    public void huy(String path) {
        Parser pars = new Parser();
        ArrayList<String> fileLines;

        // Maybe would ba better to use cycle to try again if wrong
        try {
            fileLines = pars.parseFromFile(path);
        } catch(FileNotFoundException e) {
            System.out.println("File not found! Try again");
            return;
        } catch(IOException e) {
            System.out.println("Reading error!");
            return;
        }

        ArrayList<String> columnList= new ArrayList<>();
        for (String fileLine : fileLines) {
            columnList = pars.getItems(fileLine);

            for (int i = 0; i < columnList.size(); ++i) {
                String text = columnList.get(i);
                boolean cond = text.equals("");
                switch(i) {                                                   // defining each parameter for Dragon
                    case 0: id = Long.parseLong(text);
                    case 1: dragName = text; break;                                 // including nulls
                    case 2: cordX = Long.parseLong(text); break;
                    case 3: cordY = Float.parseFloat(text); break;
                    case 4: creationTime = text; break;
                    case 5: dragAge = Integer.parseInt(text); break;
                    case 6: description = cond ? null : text; break;
                    case 7: wingspan = cond ? null : Long.parseLong(text); break;
                    case 8: type = cond ? null : DragonType.valueOf(text); break;
                    case 9: personName = cond ? null : text ; break;
                    case 10: date = cond ? null : text; break;
                    case 11: eye = cond ? null : Color.valueOf(text); break;
                    case 12: hair = cond ? null : Color.valueOf(text); break;
                    case 13: nation = cond ? null : Country.valueOf(text); break;
                    case 14: locX = cond ? 0 : Integer.parseInt(text); break;
                    case 15: locY = cond ? 0 : Long.parseLong(text); break;
                    case 16: locZ = cond ? 0 : Long.parseLong(text); break;
                }
            }
            if (personName == null)
                arr.add(new Dragon(id, dragName, new Coordinates(cordX, cordY), creationTime, dragAge, description, wingspan, type, null));
            else
                arr.add(new Dragon(id, dragName, new Coordinates(cordX, cordY),creationTime, dragAge, description, wingspan, type,
                        new Person(personName, date, eye, hair, nation, new Location(locX, locY, locZ))));
        }
    }

    public void defineCommand() {
        String command;
        do {
            System.out.print("Input a command: ");
            command = sc.next();
            switch (command) {
                case "help": help(); break;
                case "info": inform(); break;
                case "show": show(); break;
                case "add": add(); break;
                case "update": updateId(); break;
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
                    sc.nextLine();
            }

        } while(!command.equals("exit"));
    }

    public PriorityQueue<Dragon> getArr() {
        return arr;
    }

    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Wrong files");
//            return;
//        }


        Processor proc = new Processor();
        proc.huy("src\\bank.csv");
//        proc.defineCommand();

        for (Dragon i : proc.getArr()) {
            System.out.println(i);
        }


    }
}

