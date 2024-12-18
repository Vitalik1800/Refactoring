public class Item {

    public StringWrapper itemName;
    public IntegerWrapper daysRemainingBeforeExpiration;
    public IntegerWrapper itemQuality;

    public Item(String itemName, int daysRemainingBeforeExpiration, int itemQuality) {
        this.itemName = new StringWrapper(itemName);
        this.daysRemainingBeforeExpiration = new IntegerWrapper(daysRemainingBeforeExpiration);
        this.itemQuality = new IntegerWrapper(itemQuality);
    }

    public StringWrapper getItemName() {
        return itemName;
    }

    public IntegerWrapper getDaysRemainingBeforeExpiration() {
        return daysRemainingBeforeExpiration;
    }

    public void setDaysRemainingBeforeExpiration(IntegerWrapper daysRemainingBeforeExpiration) {
        this.daysRemainingBeforeExpiration = daysRemainingBeforeExpiration;
    }

    public IntegerWrapper getItemQuality() {
        return itemQuality;
    }

    public void setItemQuality(IntegerWrapper itemQuality) {
        this.itemQuality = itemQuality;
    }


    @Override
    public String toString() {
        return "Item: " + this.itemName + ", Days Remaining: " + this.daysRemainingBeforeExpiration + ", Quality: " + this.itemQuality;
    }
}



