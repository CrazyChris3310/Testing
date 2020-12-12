public class X {

    private X() {
        System.out.println("In the X constructor");
    }

    public static X createX() {
        X f = new X();
        System.out.println("The X Object is created");
        return f;
    }
}
