package giovannilongo.PROGETTO.U5S1L5120124.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Element with id " + id + " not found");
    }
}
