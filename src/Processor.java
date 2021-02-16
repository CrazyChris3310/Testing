import Dragon.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Processor {

    PriorityQueue<Dragon> arr;
    LinkedList<String> history;

    private Long id;
    private String dragName;
    private int dragAge;
    private String creationTime;
    private String description;
    private Long wingspan;
    private DragonType type;

    //Coordinates

    private long cordX;
    private float cordY;

    //Person coordinate

    private String personName;
    private String date;
    private Color eye;
    private Color hair;
    private Country nation;

    //Person location

    private int locX;
    private Long locY;
    private long locZ;

    private Scanner sc;

    private final LocalDateTime initDate;

    private String path;

    Processor(String path) {
        this.path = path;

        arr = new PriorityQueue<>(new Comparator<Dragon>() {
            @Override
            public int compare(Dragon o1, Dragon o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        history = new LinkedList<>();

        id = 0L;
        dragName = null;
        dragAge = 0;
        creationTime = null;
        description = null;
        wingspan = null;
        type = null;

        cordX = 0;
        cordY = 0;

        personName = null;
        date = null;
        eye = null;
        hair = null;
        nation = null;

        //Person location

        locX = 0;
        locY = null;
        locZ = 0;

        sc = new Scanner(System.in);

        initDate = LocalDateTime.now();

    }

    public void inform() {
        System.out.println("Type of elements: Dragon");
        System.out.println("Size = " + arr.size());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss");
        System.out.println("Initialization date: " + fmt.format(initDate));
        System.out.println();
    }

    public void help() {

    }

    public void show() {
        arr.forEach(System.out::println);
    }

    public void add() {
        Dragon dragon = inputDragon();
        arr.add(dragon);
    }

    public Dragon inputDragon() {
        inputDragonName();
        inputXCord();
        inputYCord();
        inputAge();
        inputDescription();
        inputWingspan();
        inputType();

        Person killer = null;
        if (needKiller()) {
            killer = inputKiller();
        }

        return new Dragon(dragName, new Coordinates(cordX, cordY), dragAge, description, wingspan, type, killer);
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

    private void validateId(String strId) throws WrongIdFormatException {

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

        Dragon dragon = inputDragon();

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
        arr.clear();
    }

    private <T> String defineNull(T value) {
        if (value == null) {
            return "";
        }
        return value.toString();
    }

    public void save() {

        DateTimeFormatter zdtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss xxxxx");
        DateTimeFormatter ldtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        String output;
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path))) {
            for (Dragon dragon : arr) {
                output = "" + dragon.getId() + "," + dragon.getName() + "," + dragon.getCoordinates().getX() + "," +
                        dragon.getCoordinates().getY() + "," + zdtFormatter.format(dragon.getCreationDate()) + "," +
                        dragon.getAge() + "," + defineNull(dragon.getDescription()) + "," + defineNull(dragon.getWingspan()) +
                        "," + defineNull(dragon.getType()) + ",";
                if (dragon.getKiller() == null)
                    output += ",,,,,,,\n";
                else
                    output += dragon.getKiller().getName() + "," + ldtFormatter.format(dragon.getKiller().getBirthday()) +
                            "," + dragon.getKiller().getEyeColor() + "," + dragon.getKiller().getHairColor() +
                            "," + dragon.getKiller().getNationality() + "," + dragon.getKiller().getLocation().getX() +
                            "," + dragon.getKiller().getLocation().getY() + "," + dragon.getKiller().getLocation().getZ() + "\n";

                bos.write(output.getBytes());
                bos.flush();

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!)");
        } catch (IOException e) {
            System.out.println("Writing error");
        }


    }

    public void executeScript(String scriptPath) {

    }

    public void exit() {

    }

    public void removeFirst() {
        arr.poll();
    }

    public void removeGreater() {
        Dragon dragon = inputDragon();
        arr.removeIf(drag -> drag.getName().compareTo(dragon.getName()) > 0);
    }

    public void showHistory() {
        if (history.size() == 0) {
            System.out.println("History is empty");
            return;
        }
        history.forEach(System.out::println);
    }

    private void updateHistory(String command) {
        if (history.size() == 15)
            history.removeFirst();
        history.add(command);
    }

    public void removeAnyByKiller() {

        Person killer = inputKiller();

        for (Dragon dragon : arr) {
            if (dragon.getKiller().equals(killer)) {
                arr.remove(dragon);
                return;
            }
        }
    }

    public void printDescending() {
        ArrayList<Dragon> temp = new ArrayList<>(arr);
        temp.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        temp.forEach(System.out::println);
    }

    public void printFieldDescendingAge() {
        ArrayList<Dragon> temp = new ArrayList<>(arr);
        temp.sort((o1, o2) -> o1.getAge() - o2.getAge());
        for (Dragon dragon : temp) {
            System.out.println(dragon.getAge());
        }
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
            Person killer;
            if (personName == null)
                killer = null;
            else
                killer = new Person(personName, date, eye, hair, nation, new Location(locX, locY, locZ));

            arr.add(new Dragon(id, dragName, new Coordinates(cordX, cordY),creationTime, dragAge, description, wingspan,
                    type, killer));
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
                case "history": showHistory(); break;
                case "remove_any_by_killer": removeAnyByKiller(); break;
                case "print_descending": printDescending(); break;
                case "print_field_descending_age": printFieldDescendingAge(); break;
                case "update": updateId(input[1]); break;
                case "remove_by_id": removeById(input[1]); break;
                case "execute_script": executeScript(input[1]); break;
                case "":
                    System.out.println("No command found! Try again"); continue;
                default:
                    System.out.println("Wrong command! Try again"); continue;
            }

            updateHistory(command);

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
        String path = "Files\\output.csv";


        Processor proc = new Processor(path);
        proc.parseFrom(path);
        proc.defineCommand();

    }
}

