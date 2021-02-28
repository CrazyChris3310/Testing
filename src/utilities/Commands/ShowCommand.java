package utilities.Commands;

import Input.Input;
import utilities.DragonCollection;

public class ShowCommand extends Command{


    public ShowCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        drg.getCollection().forEach(System.out::println);
    }

}
