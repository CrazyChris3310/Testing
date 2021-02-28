package utilities.Commands;

import Input.Input;
import utilities.DragonCollection;

import java.time.format.DateTimeFormatter;

public class InfoCommand extends Command{


    public InfoCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        System.out.println("Type of elements: Dragon");
        System.out.println("Size = " + drg.getSize());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss");
        System.out.println("Initialization date: " + fmt.format(drg.getInitDate()));
        System.out.println();
    }
}
