package be.technifutur.musicManagement.exception;

public class ElementNotFoundException extends RuntimeException {

    private final Object id;
    private final Class<?> c;

    public ElementNotFoundException(Object id, Class<?> c) {
        super("Oops! Element id {" + id + "} not found.");
        this.id = id;
        this.c = c;
    }

    public Object getId() {
        return id;
    }

    public Class<?> getC() {
        return c;
    }

}
