public class X {

    private X() {
        System.out.println("In the X constructor");
    }

    public static X createX() {
        System.out.println("The X Object is created");
        System.out.println("folk");
        return new X();
    }
}
