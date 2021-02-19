import Dragon.Color;
import Dragon.Country;
import Dragon.DragonType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileInput extends Input {

    public FileInput(String path) throws FileNotFoundException {
        sc = new Scanner(new FileInputStream(path));
    }

    public String inputDragonName() throws WrongInputFormatException{
        String dragName = sc.nextLine();
        if (dragName.equals("") || dragName.equals("\n"))
            throw new WrongInputFormatException();
        return dragName;
    }

    public Long inputXCord() throws WrongInputFormatException{
        String temp = sc.nextLine();
        long cordX;

        if (temp.matches("-[1-9]\\d*|0|[12]\\d{0,2}|30[012]"))
            return Long.parseLong(temp);

        throw new WrongInputFormatException();
    }

    public float inputYCord() throws WrongInputFormatException{
        float cordY;

        if (sc.hasNextFloat()) {
            cordY = sc.nextFloat();
            if (sc.nextLine().equals(""))
                return cordY;
        }

        throw new WrongInputFormatException();
    }

    public int inputAge() throws WrongInputFormatException{
        int dragAge;
        String temp = sc.nextLine();
        if (temp.matches("[1-9]\\d*"))
            return Integer.parseInt(temp);

        throw new WrongInputFormatException();
    }

    public String inputDescription() {
        String description;
        description = sc.nextLine();
        if (description.equals(""))
            description = null;
        return  description;
    }

    public Long inputWingspan() throws WrongInputFormatException{
        String temp;

        temp = sc.nextLine();
        if (temp.matches("\\d*")) {
            if (temp.equals(""))
                return null;
            else
                return Long.parseLong(temp);
        }

        throw new WrongInputFormatException();
    }

    public DragonType inputType() throws WrongInputFormatException{
        String temp = sc.nextLine();
        DragonType type;

        if (temp.toUpperCase().matches("AIR|UNDERGROUND|FIRE|WATER"))
            return DragonType.valueOf(temp.toUpperCase());

        throw new WrongInputFormatException();
    }

    public String inputKillerName() throws WrongInputFormatException{
        String personName = sc.nextLine();
        if (personName.equals("") || personName.equals("\n"))
            throw new WrongInputFormatException();
        return personName;
    }

    public String inputKilBirthday() throws WrongInputFormatException{
        String date = sc.nextLine();
        if (date.matches("\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) " +
                "(0[0-9]|1[0-9]|2[0-4]):([0-5]\\d):([0-5]\\d)"))
            return date;

        throw new WrongInputFormatException();
    }

    public Color inputKilEyeColor() throws WrongInputFormatException{
        String temp;
        Color eye;

        temp = sc.nextLine();
        if (temp.toUpperCase().matches("WHITE|RED|ORANGE|YELLOW|GREEN|BLACK")) {
            return Color.valueOf(temp.toUpperCase());
        }

        throw new WrongInputFormatException();
    }

    public Color inputKilHairColor() throws WrongInputFormatException{
        String temp;
        Color hair;

        temp = sc.nextLine();
        if (temp.toUpperCase().matches("WHITE|RED|ORANGE|YELLOW|GREEN|BLACK")) {
            return Color.valueOf(temp.toUpperCase());
        }

    throw new WrongInputFormatException();

    }

    public long inputKilZLoc() throws WrongInputFormatException{
        long locZ;

        if (sc.hasNextLong()) {
            locZ = sc.nextLong();
            if (sc.nextLine().equals(""))
                return locZ;
        }

        throw new WrongInputFormatException();
    }

    public Long inputKilYLoc() throws WrongInputFormatException{
        long locY;

        if(sc.hasNextLong()) {
            locY = sc.nextLong();
            if (sc.nextLine().equals(""))
                return locY;
        }

        throw new WrongInputFormatException();
    }

    public int inputKilXLoc() throws WrongInputFormatException{
        int locX;

        if (sc.hasNextInt()) {
            locX = sc.nextInt();
            if (sc.nextLine().equals(""))
                return locX;
        }

        throw new WrongInputFormatException();
    }

    public Country inputKilNation() throws WrongInputFormatException{
        String temp = sc.nextLine();
        if (temp.toUpperCase().matches("ITALY|USA|VATICAN|NORTH|KOREA|INDIA"))
            return Country.valueOf(temp.toUpperCase());

        throw new WrongInputFormatException();
    }

    public boolean needKiller() throws WrongInputFormatException{
        String ans = sc.nextLine();
        if (ans.matches("y|n"))
            switch(ans) {
                case "y": return true;
                case "n": return false;
            }
        throw new WrongInputFormatException();

    }

}
