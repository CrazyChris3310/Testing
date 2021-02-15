import java.util.NoSuchElementException;

public class NoSuchIdException extends IdException{

    NoSuchIdException(String s) {
        super(s);
    }
}
