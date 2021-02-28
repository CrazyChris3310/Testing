package utilities.Commands;

import Input.Input;
import utilities.DragonCollection;

public class HistoryCommand extends Command{


    public HistoryCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        drg.showHistory();
    }
}
