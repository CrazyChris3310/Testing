package Dragon;

public class Location {
    private int x;
    private Long y; //Поле не может быть null
    private long z;


    public Location(int x, Long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}