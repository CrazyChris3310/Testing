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

    /**
     * Method inputs a dragon with all its attributes.
     * @return dragon.
     * @throws WrongInputFormatException if any attribute has wrong format.
     */
    public Dragon inputDragon() throws WrongInputFormatException {
        return new Dragon(inputDragonName(), new Coordinates(inputXCord(), inputYCord()), inputAge(), inputDescription(),
                inputWingspan(), inputType(), needKiller() ? inputKiller() : null);
    }

    /**
     * Method inputs a killer with all his attributes.
     * @return killer.
     * @throws WrongInputFormatException if any attribute has invalid format.
     */
    public Person inputKiller() throws WrongInputFormatException {
        return new Person(inputKillerName(), inputKilBirthday(), inputKilEyeColor(), inputKilHairColor(),
                inputKilNation(), new Location(inputKilXLoc(), inputKilYLoc(), inputKilZLoc()));

    }

    /**
     * Method inputs path to a file.
     * @return {@code path} scanned from input.
     * @throws WrongInputFormatException if path has wrong format.
     */
    public String inputFilePath() throws WrongInputFormatException{
        String path;
        path = sc.next();
        if (sc.nextLine().equals("")) {
            return path;
        }
        throw new WrongInputFormatException();
    }

    /**
     * Method inputs id from a source.
     * @return scanned id
     * @throws WrongIdFormatException if id has wrong format
     */
    public Long inputId() throws WrongIdFormatException {
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

    /**
     * Method scans everything in current line
     * @return the line that was skipped.
     */
    public String nextLine() {
        return sc.nextLine();
    }

    /**
     * Returns true if there is another token in input.
     * @return true if and only if this scanner has another token.
     */
    public boolean hasNext() {
        return sc.hasNext();
    }

    /**
     * Finds and returns the next complete token from this input stream.
     * @return the next token
     */
    public String next() { return sc.next(); }
}
