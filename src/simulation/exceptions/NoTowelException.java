package simulation.exceptions;
public class NoTowelException extends RuntimeException {
    public NoTowelException(String message) {
        super(message+" не может найти полотенце");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
