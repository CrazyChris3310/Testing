package utilities.Commands;

import Dragon.Dragon;
import Exceptions.WrongInputFormatException;
import Input.Input;
import utilities.DragonCollection;

/**
 * Command "remove_greater".
 */
public class RemoveGreaterCommand extends Command{


    public RemoveGreaterCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    /**
     * Method inputs a dragon and removes each dragon that is greater that entered.
     */
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
