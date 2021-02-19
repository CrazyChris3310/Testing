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

    public int getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    @Override
    public String toString() {
        return  String.format("x = %d, y = %d, z = %d", x, y, z);
    }
}