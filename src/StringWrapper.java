public class StringWrapper {

    private final String value;

    public StringWrapper(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
