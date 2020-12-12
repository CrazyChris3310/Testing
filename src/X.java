public class X {

    private X() {
        System.out.println("In the X constructor");
    }

    public static X createX() {
        X f = new X();
        return f;
    }
}
