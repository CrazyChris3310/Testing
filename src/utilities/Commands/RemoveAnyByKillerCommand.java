package utilities.Commands;

import Dragon.Dragon;
import Dragon.Person;
import Exceptions.NoSuchKillerException;
import Exceptions.WrongInputFormatException;
import Input.Input;
import utilities.DragonCollection;

public class RemoveAnyByKillerCommand extends Command{


    public RemoveAnyByKillerCommand(DragonCollection collection, Input input) {
        super(collection, input);
    }

    @Override
    public void execute() {
        Person killer;
        try {
            input.nextLine();
            killer = input.inputKiller();
        } catch (WrongInputFormatException e) {
            System.out.println("Wrong data!");
            return;
        }

        try {
            drg.removeByKiller(killer);
        } catch (NoSuchKillerException e) {
            System.out.println("No such killer in the collection");
        }

    }
}
