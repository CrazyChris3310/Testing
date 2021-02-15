import java.util.NoSuchElementException;

public class WrongIdFormatException extends IdException{

    WrongIdFormatException(String s) {
        super(s);
    }

}
