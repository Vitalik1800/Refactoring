public class Item {

    public StringWrapper name;
    public IntegerWrapper sellIn;
    public IntegerWrapper quality;

    public Item(String name, int sellIn, int quality) {
        this.name = new StringWrapper(name);
        this.sellIn = new IntegerWrapper(sellIn);
        this.quality = new IntegerWrapper(quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
