package utilities.Commands;

import Dragon.Dragon;
import Exceptions.WrongInputFormatException;
import Input.Input;
import utilities.DragonCollection;

public class RemoveGreaterCommand extends Command{


    public RemoveGreaterCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        try {
            input.nextLine();
            Dragon dragon = input.inputDragon();
            drg.removeGreater(dragon);
        } catch (WrongInputFormatException e) {
            System.out.println("Wrong Data given");
        }
    }
}
