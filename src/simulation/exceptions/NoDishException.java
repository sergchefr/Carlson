package simulation.exceptions;
public class NoDishException extends RuntimeException {
    public NoDishException() {
        super("no clear dishes");
    }
}
