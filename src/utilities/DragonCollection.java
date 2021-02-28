package utilities;

import Exceptions.NoSuchIdException;
import Exceptions.NoSuchKillerException;
import Dragon.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DragonCollection {
    private PriorityQueue<Dragon> collection;
    private LinkedList<String> history;
    final private LocalDateTime initDate;
    private File path;

    public DragonCollection(File path) {
        this.path = path;
        initDate = LocalDateTime.now();
        collection = new PriorityQueue<Dragon>((Comparator<Dragon>) (o1, o2) -> o1.getName().compareTo(o2.getName()));
        history = new LinkedList<>();
        parseFrom(path);
    }

    public void parseFrom(File path) {
        Parser pars = new Parser();
        ArrayList<String> fileLines;

        try {
            fileLines = pars.parseFromFile(path);
        } catch(FileNotFoundException e) {
            System.out.println("File not found! Try again");
            return;
        } catch(IOException e) {
            System.out.println("Reading error!");
            return;
        }

        ArrayList<String> columnList;
        for (String fileLine : fileLines) {
            columnList = pars.getItems(fileLine);

            Long id = Long.parseLong(columnList.get(0));
            String dragName = columnList.get(1);                         // including nulls
            Long cordX = Long.parseLong(columnList.get(2));
            float cordY = Float.parseFloat(columnList.get(3));
            String creationTime = columnList.get(4);
            int dragAge = Integer.parseInt(columnList.get(5));
            String description = columnList.get(6).equals("") ? null : columnList.get(6);
            Long wingspan = columnList.get(7).equals("") ? null : Long.parseLong(columnList.get(7));
            DragonType type = columnList.get(8).equals("") ? null : DragonType.valueOf(columnList.get(8));
            String personName = columnList.get(9).equals("") ? null : columnList.get(9) ;
            String date = columnList.get(10).equals("") ? null : columnList.get(10);
            Color eye = columnList.get(11).equals("") ? null : Color.valueOf(columnList.get(11));
            Color hair = columnList.get(12).equals("") ? null : Color.valueOf(columnList.get(12));;
            Country nation = columnList.get(13).equals("") ? null : Country.valueOf(columnList.get(13));
            int locX = columnList.get(14).equals("") ? 0 : Integer.parseInt(columnList.get(14));
            long locY = columnList.get(15).equals("") ? 0 : Long.parseLong(columnList.get(15));
            long locZ = columnList.get(16).equals("") ? 0 : Long.parseLong(columnList.get(16));


            Person killer;
            if (personName == null)
                killer = null;
            else
                killer = new Person(personName, date, eye, hair, nation, new Location(locX, locY, locZ));

            collection.add(new Dragon(id, dragName, new Coordinates(cordX, cordY),creationTime, dragAge, description,
                    wingspan, type, killer));
        }
    }

    public File getFile() {
        return path;
    }
    public LocalDateTime getInitDate() {
        return initDate;
    }

    public int getSize() {
        return collection.size();
    }

    public PriorityQueue<Dragon> getCollection() {
        return collection;
    }

    public void add(Dragon dragon) {
        collection.add(dragon);
    }

    public void removeFromQueue(Long ident) throws NoSuchIdException {
        for (Dragon i : collection) {
            if (i.getId().equals(ident)) {
                collection.remove(i);
                return;
            }
        }

        throw new NoSuchIdException("There is no Dragon with such id in this collection");
    }

    public void clear() {
        collection.clear();
    }

    public void updateHistory(String command) {
        if (history.size() >= 14)
            history.removeFirst();
        history.add(command);
    }

    public void showHistory() {
        if (history.size() == 0) {
            System.out.println("History is empty");
        }
        history.forEach(System.out::println);
    }

    public void removeByKiller(Person killer) throws NoSuchKillerException{
        for (Dragon dragon : collection) {
            if (killer.equals(dragon.getKiller())) {
                collection.remove(dragon);
                return;
            }
        }
        throw new NoSuchKillerException();
    }

    public void removeFirst() {
        collection.poll();
    }

    public void removeGreater(Dragon dragon) {
        collection.removeIf(drag -> drag.getName().compareTo(dragon.getName()) > 0);
    }

}
