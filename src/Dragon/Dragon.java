package Dragon;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

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
    }

    //Manually
    public Dragon(String name, Coordinates coordinates, int age, String description,
                  Long wingspan, DragonType type, Person killer) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWingspan(Long wingspan) {
        this.wingspan = wingspan;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setKiller(Person killer) {
        this.killer = killer;
    }

    public String getName() {
        return name;
    }

    private ZonedDateTime defineDateTime(String dt) {
        return ZonedDateTime.parse(dt.replace(" +", "+").replace(" -", "-")
                .replace(" ", "T"));
    }


    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", wingspan=" + wingspan +
                ", type=" + type +
                ", killer=" + killer +
                '}';
    }
}
