package Dragon;

public class Coordinates {
    private Long x; //Максимальное значение поля: 302, Поле не может быть null
    private float y;

    public Coordinates(Long x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}