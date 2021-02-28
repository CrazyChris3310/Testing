package utilities.Commands;
import Input.*;
import utilities.*;

abstract public class Command {

    DragonCollection drg;
    Input input;

    public Command(DragonCollection collection, Input input) {
        drg = collection;
        this.input = input;
    }

    abstract public void execute();
}
