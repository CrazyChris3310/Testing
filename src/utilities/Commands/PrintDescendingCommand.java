package utilities.Commands;

import Dragon.Dragon;
import Input.Input;
import utilities.DragonCollection;

import java.util.ArrayList;

public class PrintDescendingCommand extends Command{


    public PrintDescendingCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        ArrayList<Dragon> temp = new ArrayList<>(drg.getCollection());
        temp.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        temp.forEach(System.out::println);
    }
}
