package utilities.Commands;

import Input.Input;
import utilities.DragonCollection;

public class RemoveFirstCommand extends Command{


    public RemoveFirstCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        drg.removeFirst();
    }
}
