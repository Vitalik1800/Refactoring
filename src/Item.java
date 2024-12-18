public class Item {

    public StringWrapper itemName;
    public IntegerWrapper daysRemainingBeforeExpiration;
    public IntegerWrapper itemQuality;

    public Item(String itemName, int daysRemainingBeforeExpiration, int itemQuality) {
        this.itemName = new StringWrapper(itemName);
        this.daysRemainingBeforeExpiration = new IntegerWrapper(daysRemainingBeforeExpiration);
        this.itemQuality = new IntegerWrapper(itemQuality);
    }

    @Override
    public String toString() {
        return this.itemName + ", " + this.daysRemainingBeforeExpiration + ", " + this.itemQuality;
    }
}
