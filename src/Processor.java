import Dragon.*;

import java.io.*;
import java.nio.file.Files;
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

    //private Scanner sc;

    private final LocalDateTime initDate;

    private File path;

    Input input;

    Processor(File path) {
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

        //sc = new Scanner(System.in);

        initDate = LocalDateTime.now();

        input = new ConsoleInput();

    }

    public void inform() {
        System.out.println("Type of elements: Dragon");
        System.out.println("Size = " + arr.size());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss");
        System.out.println("Initialization date: " + fmt.format(initDate));
        System.out.println();
    }

    public void help() {

        System.out.println("help - show information for available commands");
        System.out.println("info - show information about collection");
        System.out.println("show - show all the elements of collection");
        System.out.println("add {element} - add new element to collection");
        System.out.println("update id {element} - update the element with given id");
        System.out.println("remove_by_id id - remove element with given id");
        System.out.println("clear - remove everything from collection");
        System.out.println("save - save collection to the file");
        System.out.println("execute_script file_name - read and execute script from given file");
        System.out.println("exit - stop the program without saving");
        System.out.println("remove_first - remove the first element from collection");
        System.out.println("remove_greater {element} - remove all elements, that are greater then given element");
        System.out.println("history - show last 14 commands");
        System.out.println("remove_any_by_killer killer - remove from collection one element with given killer");
        System.out.println("print_descending - show elements in descending order");
        System.out.println("print_field_descending_age - show the age of each element in descending order");

    }

    public void show() {
        arr.forEach(System.out::println);
    }

    public void add() {
        try {
            Dragon dragon = inputDragon();
            arr.add(dragon);
        } catch (WrongInputFormatException e) {
            System.out.println("Wrong Data given!");
        }
    }

    public Dragon inputDragon() throws WrongInputFormatException{
        Person killer = null;

        dragName = input.inputDragonName();
        cordX = input.inputXCord();
        cordY = input.inputYCord();
        dragAge = input.inputAge();
        description = input.inputDescription();
        wingspan = input.inputWingspan();
        type = input.inputType();

        if (input.needKiller()) {
            killer = inputKiller();
        }


        return new Dragon(dragName, new Coordinates(cordX, cordY), dragAge, description, wingspan, type, killer);
    }

    private void validateId(String strId) throws WrongIdFormatException {
        if(strId.matches("[1-9]+")) {
            id = Long.parseLong(strId);
            return;
        }

        throw new WrongIdFormatException("Wrong id format!");
    }

    public Person inputKiller() throws WrongInputFormatException{

        input.inputKillerName();
        input.inputKilBirthday();
        input.inputKilEyeColor();
        input.inputKilHairColor();
        input.inputKilNation();
        input.inputKilXLoc();
        input.inputKilYLoc();
        input.inputKilZLoc();

        return new Person(personName, date, eye, hair, nation, new Location(locX, locY, locZ));
    }

    public void updateId(String strId) {

        if (!removeById(strId))
            return;

        try {
            Dragon dragon = inputDragon();
            dragon.setId(id);
            arr.add(dragon);
        } catch (WrongInputFormatException e) {
            System.out.println("Wrong Data given!");
        }
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

    public void exit() {

    }

    public void executeScript(String script) {
        try {
            input = new FileInput(script);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        defineFileCommand();

        input = new ConsoleInput();

    }

    // REWRITE
    public void defineFileCommand() {
        String command;
        while (input.hasNext()) {
            String[] text = input.nextLine().split(" ");
            command = text[0];

            if (text.length > 2) {
                System.out.println("Wrong command format!");
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
                case "update": updateId(text[1]); break;
                case "remove_by_id": removeById(text[1]); break;
                case "execute_script": executeScript(text[1]); break;
                case "":
                    System.out.println("No command found!");
                default:
                    System.out.println("Wrong command!");
            }

            System.out.println();
        }
    }

    public void removeFirst() {
        arr.poll();
    }

    public void removeGreater() {
        try {
            Dragon dragon = inputDragon();
            arr.removeIf(drag -> drag.getName().compareTo(dragon.getName()) > 0);
        } catch (WrongInputFormatException e) {
            System.out.println("Wrong Data given");
        }
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

        Person killer;
        try {
            killer = inputKiller();
        } catch (WrongInputFormatException e) {
            System.out.println("Wrong data!");
            return;
        }

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

    public void parseFrom(File path) {
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
            String[] text = input.nextLine().split(" ");
            command = text[0];

            if (text.length > 2) {
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
                case "update": updateId(text[1]); break;
                case "remove_by_id": removeById(text[1]); break;
                case "execute_script": executeScript(text[1]); break;
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
        if (args.length != 1) {
            System.out.println("Wrong files");
            return;
        }
        File path = new File(args[0]);
        if (!path.exists()) {
            System.out.println("File not found!");
            return;
        }

        Processor proc = new Processor(path);
        proc.parseFrom(path);
        proc.defineCommand();

    }
}

