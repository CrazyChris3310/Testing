public class X {

    private X() {}

    public static X createX() {
        System.out.println("The X Object is created");
        return new X();
    }
}
