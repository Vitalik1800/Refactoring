public class IntegerWrapper {

    public int value;

    public IntegerWrapper(int value) {
        this.value = value;
    }

    public void increment() {
        if (value < 50) {
            value++;
        }
    }

    public void decrement() {
        if (value > 0) {
            value--;
        }
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
