package Dragon;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле не может быть null
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле не может быть null

    //Manually
    public Person(String n, String time, Color eye, Color hair, Country country, Location loc) {
        name = n;
        eyeColor = eye;
        birthday = LocalDateTime.parse(time.replace(" ", "T"));
        hairColor = hair;
        nationality = country;
        location = loc;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public Country getNationality() {
        return nationality;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        return "name: '" + name + "'\n" +
                "birthday: " + fmt.format(birthday) + "\n" +
                "eyeColor: " + eyeColor + "\n" +
                "hairColor: " + hairColor + "\n" +
                "nationality: " + nationality + "\n" +
                "location: " + location;
    }
}