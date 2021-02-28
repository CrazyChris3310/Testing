package utilities.Commands;

import Dragon.Dragon;
import Exceptions.IdException;
import Exceptions.WrongInputFormatException;
import Input.Input;
import utilities.DragonCollection;

/**
 * Command "update".
 */
public class UpdateIdCommand extends Command{

    public UpdateIdCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    /**
     * Method inputs id and then changes fields of dragon with given id to new ones.
     */
    @Override
    public void execute() {
        Long id;
        try {
            id = input.inputId();
            drg.removeFromQueue(id);
            Dragon dragon = input.inputDragon();
            dragon.setId(id);
            drg.add(dragon);
        } catch (IdException e) {
            System.out.println(e);
        } catch (WrongInputFormatException e) {
            System.out.println("Wrong Data given!");
        }
    }
}
