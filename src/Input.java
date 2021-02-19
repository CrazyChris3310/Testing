import Dragon.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

abstract public class Input {

    Scanner sc;


    abstract String inputDragonName() throws WrongInputFormatException;
    abstract Long inputXCord() throws WrongInputFormatException;
    abstract float inputYCord() throws WrongInputFormatException;
    abstract int inputAge() throws WrongInputFormatException;
    abstract String inputDescription() throws WrongInputFormatException;
    abstract Long inputWingspan() throws WrongInputFormatException;
    abstract DragonType inputType() throws WrongInputFormatException;

    abstract String inputKillerName() throws WrongInputFormatException;
    abstract String inputKilBirthday() throws WrongInputFormatException;
    abstract Color inputKilEyeColor() throws WrongInputFormatException;
    abstract Color inputKilHairColor() throws WrongInputFormatException;
    abstract Country inputKilNation() throws WrongInputFormatException;
    abstract int inputKilXLoc() throws WrongInputFormatException;
    abstract Long inputKilYLoc() throws WrongInputFormatException;
    abstract long inputKilZLoc() throws WrongInputFormatException;
    abstract boolean needKiller() throws WrongInputFormatException;

    public String nextLine() {
        return sc.nextLine();
    }

    public boolean hasNext() {
        return sc.hasNext();
    }
}
