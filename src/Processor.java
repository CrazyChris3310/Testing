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

    private Long id = 0L;
    private String dragName = null;
    private int dragAge = 0;
    private String creationTime = null;
    private String description = null;
    private Long wingspan = null;
    private DragonType type = null;

    //Coordinates

    private long cordX = 0;
    private float cordY = 0;

    //Person coordinate

    private String personName = null;
    private String date = null;
    private Color eye = null;
    private Color hair = null;
    private Country nation = null;

    //Person location

    private int locX = 0;
    private Long locY = null;
    private long locZ = 0;

    private Scanner sc = new Scanner(System.in);

    public void inform() {

    }

    public void help() {

    }

    public void show() {
        for (Dragon dragon : arr) {
            System.out.println(dragon);
        }
    }

    public void add() {

    }


    public void inputId() throws WrongIdFormatException{
        if (sc.hasNextLong()) {
            id = sc.nextLong();
            if (sc.nextLine().equals("") && id > 0) {
                return;
            }
        }
        else
            sc.nextLine();

        throw new WrongIdFormatException("Wrong id format!");
    }

    public void validateId(String strId) throws WrongIdFormatException {

        if(strId.matches("[1-9]+")) {
            id = Long.parseLong(strId);
            return;
        }

        throw new WrongIdFormatException("Wrong id format!");
    }

    public void inputDragonName() {
        System.out.print("Enter the name: ");
        dragName = sc.nextLine();
        while (dragName.equals("") || dragName.equals("\s")) {
            System.out.println("Wrong name! Try again: ");
            dragName = sc.nextLine();
        }
    }

    public void inputXCord() {
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
    }

    public void inputYCord() {
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
    }

    public void inputAge() {
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
    }

    public void inputDescription() {
        System.out.print("Enter the dragon's description: ");
        description = sc.nextLine();
        if (description.equals(""))
            description = null;
    }

    public void inputWingspan() {
        String temp;

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
    }

    public void inputType() {
        String temp;

        System.out.print("Enter the dragon's type: (AIR, UNDERGROUND, FIRE, WATER) ");
        while(true) {
            temp = sc.nextLine();
            if (temp.toUpperCase().matches("AIR|UNDERGROUND|FIRE|WATER")) {
                type = DragonType.valueOf(temp.toUpperCase());
                break;
            }
            System.out.print("Wrong type format! Try again:");
        }
    }

    public void inputKillerName() {
        System.out.print("Enter the killer's name: ");
        personName = sc.nextLine();
        while (dragName.equals("") || dragName.equals("\s")) {
            System.out.println("Wrong name! Try again: ");
            dragName = sc.nextLine();
        }
    }

    public void inputKilBirthday() {
        System.out.print("Enter the killer's birthday: (YYYY-MM-DD hh-mm-ss) ");
        while(true) {
            date = sc.nextLine();
            if (date.matches("\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) " +
                    "(0[0-9]|1[0-9]|2[0-4]):([0-5]\\d):([0-5]\\d)"))
                break;
            System.out.print("Try again: ");
        }
    }

    public void inputKilEyeColor() {
        String temp;
        System.out.print("Enter the killer's eye color: (WHITE, RED, ORANGE, YELLOW, GREEN, BLACK) ");
        while(true) {
            temp = sc.nextLine();
            if (temp.toUpperCase().matches("WHITE|RED|ORANGE|YELLOW|GREEN|BLACK")) {
                eye = Color.valueOf(temp.toUpperCase());
                break;
            }
            System.out.print("Try again: ");
        }
    }

    public void inputKilHairColor() {
        String temp;
        System.out.print("Enter the killer's hair color: (WHITE, RED, ORANGE, YELLOW, GREEN, BLACK) ");
        while(true) {
            temp = sc.nextLine();
            if (temp.toUpperCase().matches("WHITE|RED|ORANGE|YELLOW|GREEN|BLACK")) {
                hair = Color.valueOf(temp.toUpperCase());
                break;
            }
            System.out.print("Try again: ");
        }
    }

    private void inputKilZLoc() {
        System.out.print("Enter the killer's Z location: ");
        while(true) {
            if (sc.hasNextInt()) {
                locZ = sc.nextInt();
                if (sc.nextLine().equals("")) break;
            }
            else
                sc.nextLine();
            System.out.print("Wrong coordinate! Try again: ");
        }
    }

    private void inputKilYLoc() {
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
    }

    private void inputKilXLoc() {
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
    }

    private void inputKilNation() {
        String temp;
        System.out.print("Enter the killer's nationality: (ITALY, NORTH_KOREA, USA, INDIA, VATICAN) ");
        while(true) {
            temp = sc.nextLine();
            if (temp.toUpperCase().matches("ITALY|USA|VATICAN|NORTH|KOREA|INDIA")) {
                nation = Country.valueOf(temp.toUpperCase());
                break;
            }
            System.out.print("Try again: ");
        }
    }

    public Person inputKiller() {

        inputKillerName();
        inputKilBirthday();
        inputKilEyeColor();
        inputKilHairColor();
        inputKilNation();
        inputKilXLoc();
        inputKilYLoc();
        inputKilZLoc();

        return new Person(personName, date, eye, hair, nation, new Location(locX, locY, locZ));
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

    public void updateId(String strId) {

        if (!removeById(strId))
            return;


        inputDragonName();
        inputXCord();
        inputYCord();
        inputAge();
        inputDescription();
        inputWingspan();
        inputType();


        Dragon dragon;
        Person killer = null;

        if (needKiller())
            killer = inputKiller();

        dragon = new Dragon(dragName, new Coordinates(cordX, cordY), dragAge, description, wingspan, type, killer);
        dragon.setId(id);
        arr.add(dragon);
    }

    public boolean removeById(String strId){
        try {
            validateId(strId);
            removeFromQueue(id);
        } catch (IdException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public void removeFromQueue(Long ident) throws NoSuchIdException{
        for (Dragon i : arr) {
            if (i.getId().equals(ident)) {
                arr.remove(i);
                return;
            }
        }

        throw new NoSuchIdException("There is no Dragon with such id in this collection");
    }

    public void clear() {

    }

    public void save() {

    }

    public void executeScript(String scriptPath) {

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

    public void parseFrom(String path) {
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
            String[] input = sc.nextLine().split(" ");
            command = input[0];

            if (input.length > 2) {
                System.out.println("Wrong command format! Try again");
                continue;
            }
            switch(command) {
                case "help": help(); break;
                case "info": inform(); break;
                case "show": show(); break;
                case "add": add(); break;
                case "clear": clear(); break;
                case "save": save(); break;
                case "exit": exit(); break;
                case "remove_first": removeFirst(); break;
                case "remove_greater": removeGreater(); break;
                case "history": history(); break;
                case "remove_any_by_killer": removeAnyByKiller(); break;
                case "print_descending": printDescending(); break;
                case "print_field_descending": printFieldDescendingAge(); break;
                case "update": updateId(input[1]); break;
                case "remove_by_id": removeById(input[1]); break;
                case "execute_script": executeScript(input[1]); break;
                default:
                    System.out.println("Wrong command! Try again");
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
        proc.parseFrom("Files\\bank.csv");
        proc.defineCommand();

    }
}
