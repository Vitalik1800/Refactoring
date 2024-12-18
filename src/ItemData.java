public class ItemData {
    private StringWrapper itemName;
    private IntegerWrapper daysRemainingBeforeExpiration;
    private IntegerWrapper itemQuality;

    public ItemData(StringWrapper itemName, IntegerWrapper daysRemainingBeforeExpiration, IntegerWrapper itemQuality) {
        this.itemName = itemName;
        this.daysRemainingBeforeExpiration = daysRemainingBeforeExpiration;
        this.itemQuality = itemQuality;
    }

    public StringWrapper getItemName() {
        return itemName;
    }

    public IntegerWrapper getDaysRemainingBeforeExpiration() {
        return daysRemainingBeforeExpiration;
    }

    public IntegerWrapper getItemQuality() {
        return itemQuality;
    }

    public void setDaysRemainingBeforeExpiration(IntegerWrapper daysRemainingBeforeExpiration) {
        this.daysRemainingBeforeExpiration = daysRemainingBeforeExpiration;
    }

    public void setItemQuality(IntegerWrapper itemQuality) {
        this.itemQuality = itemQuality;
    }
}
