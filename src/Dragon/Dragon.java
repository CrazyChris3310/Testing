package Dragon;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Class {@code Dragon} defines a dragon with its characteristics
 */
public class Dragon{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int age; //Значение поля должно быть больше 0
    private String description; //Поле может быть null
    private Long wingspan; //Значение поля должно быть больше 0, Поле может быть null
    private DragonType type; //Поле может быть null
    private Person killer; //Поле может быть null

    private static Long nextDragonId = 1L;


    //From file
    public Dragon(Long id, String name, Coordinates coordinates, String creationTime, int age, String description,
                  Long wingspan, DragonType type, Person killer) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = defineDateTime(creationTime);
        this.age = age;
        this.description = description;
        this.wingspan = wingspan;
        this.type = type;
        this.killer = killer;
        if (id >= nextDragonId)
            nextDragonId = id + 1;
    }

    //Manually
    public Dragon(String name, Coordinates coordinates, int age, String description,
                  Long wingspan, DragonType type, Person killer) {
        this.id = nextDragonId++;
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.description = description;
        this.wingspan = wingspan;
        this.type = type;
        this.killer = killer;
        this.creationDate = ZonedDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public Person getKiller() {
        return killer;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public DragonType getType() {
        return type;
    }

    public Long getWingspan() {
        return wingspan;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private ZonedDateTime defineDateTime(String dt) {
        return ZonedDateTime.parse(dt.replace(" +", "+").replace(" -", "-")
                .replace(" ", "T"));
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss xxxxx");
        return  "id: " + id + "\n" +
                "name: '" + name + "'\n" +
                "coordinates: " + coordinates + "\n" +
                "creationDate: " + fmt.format(creationDate) + "\n" +
                "age: " + age + "\n" +
                "description: '" + description + "'\n" +
                "wingspan: " + wingspan + "\n" +
                "type: " + type + "\n" +
                "killer: " + killer + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dragon dragon = (Dragon) o;
        return age == dragon.age &&
                id.equals(dragon.id) &&
                name.equals(dragon.name) &&
                coordinates.equals(dragon.coordinates) &&
                creationDate.equals(dragon.creationDate) &&
                Objects.equals(description, dragon.description) &&
                Objects.equals(wingspan, dragon.wingspan) &&
                type == dragon.type &&
                Objects.equals(killer, dragon.killer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, age, description, wingspan, type, killer);
    }
}
