package utilities.Commands;

import Dragon.*;
import Exceptions.WrongInputFormatException;
import Input.Input;
import utilities.DragonCollection;

public class AddCommand extends Command{


    public AddCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        try {
            input.nextLine();
            Dragon dragon = input.inputDragon();
            drg.add(dragon);
        } catch (WrongInputFormatException e) {
            System.out.println("Wrong Data given!");
        }
    }
}
