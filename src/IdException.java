public class IdException extends Exception{
    IdException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
