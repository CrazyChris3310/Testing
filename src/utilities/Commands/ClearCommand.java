package utilities.Commands;

import Input.Input;
import utilities.DragonCollection;

public class ClearCommand extends Command{


    public ClearCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        drg.clear();
    }
}
