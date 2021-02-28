package Input;

import Dragon.*;
import Exceptions.IdException;
import Exceptions.WrongIdFormatException;
import Exceptions.WrongInputFormatException;

import java.util.Scanner;

/**
 * Class {@code Input} defines methods to work with an input from various sources.
 */
abstract public class Input {

    Scanner sc;

    abstract public String inputDragonName() throws WrongInputFormatException;
    abstract public Long inputXCord() throws WrongInputFormatException;
    abstract public float inputYCord() throws WrongInputFormatException;
    abstract public int inputAge() throws WrongInputFormatException;
    abstract public String inputDescription() throws WrongInputFormatException;
    abstract public Long inputWingspan() throws WrongInputFormatException;
    abstract public DragonType inputType() throws WrongInputFormatException;

    abstract public String inputKillerName() throws WrongInputFormatException;
    abstract public String inputKilBirthday() throws WrongInputFormatException;
    abstract public Color inputKilEyeColor() throws WrongInputFormatException;
    abstract public Color inputKilHairColor() throws WrongInputFormatException;
    abstract public Country inputKilNation() throws WrongInputFormatException;
    abstract public int inputKilXLoc() throws WrongInputFormatException;
    abstract public Long inputKilYLoc() throws WrongInputFormatException;
    abstract public long inputKilZLoc() throws WrongInputFormatException;
    abstract public boolean needKiller() throws WrongInputFormatException;

    public Dragon inputDragon() throws WrongInputFormatException {
        return new Dragon(inputDragonName(), new Coordinates(inputXCord(), inputYCord()), inputAge(), inputDescription(),
                inputWingspan(), inputType(), needKiller() ? inputKiller() : null);
    }

    public Person inputKiller() throws WrongInputFormatException {
        return new Person(inputKillerName(), inputKilBirthday(), inputKilEyeColor(), inputKilHairColor(),
                inputKilNation(), new Location(inputKilXLoc(), inputKilYLoc(), inputKilZLoc()));

    }

    public String inputFilePath() throws WrongInputFormatException{
        String path;
        path = sc.next();
        if (sc.nextLine().equals("")) {
            return path;
        }
        throw new WrongInputFormatException();
    }

    public Long inputId() throws IdException {
        Long id;
        if (sc.hasNextLong()) {
            id = sc.nextLong();
            if (sc.nextLine().equals("") && id > 0) {
                return id;
            }
        }
        else
            sc.nextLine();

        throw new WrongIdFormatException("Wrong id format!");
    }

    public String nextLine() {
        return sc.nextLine();
    }

    public boolean hasNext() {
        return sc.hasNext();
    }

    public String next() { return sc.next(); }
}
