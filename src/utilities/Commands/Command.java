package utilities.Commands;
import Input.*;
import utilities.*;

/**
 * Root class for all commands. Contains source for input and the collection to work with.
 */
abstract public class Command {

    DragonCollection drg;
    Input input;

    public Command(DragonCollection collection, Input input) {
        drg = collection;
        this.input = input;
    }

    abstract public void execute();
}
