package utilities.Commands;

import Exceptions.IdException;
import Input.Input;
import utilities.DragonCollection;

public class RemoveByIdCommand extends Command{


    public RemoveByIdCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        Long id;
        try {
            id = input.inputId();
            drg.removeFromQueue(id);
        } catch (IdException e) {
            System.out.println(e);
        }
    }
}
