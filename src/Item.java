public class Item {
    private ItemData itemData;

    public Item(String itemName, int daysRemainingBeforeExpiration, int itemQuality) {
        this.itemData = new ItemData(new StringWrapper(itemName), new IntegerWrapper(daysRemainingBeforeExpiration), new IntegerWrapper(itemQuality));
    }

    public StringWrapper getItemName() {
        return itemData.getItemName();
    }

    public IntegerWrapper getDaysRemainingBeforeExpiration() {
        return itemData.getDaysRemainingBeforeExpiration();
    }

    public IntegerWrapper getItemQuality() {
        return itemData.getItemQuality();
    }

    public void setDaysRemainingBeforeExpiration(IntegerWrapper daysRemainingBeforeExpiration) {
        itemData.setDaysRemainingBeforeExpiration(daysRemainingBeforeExpiration);
    }

    public void setItemQuality(IntegerWrapper itemQuality) {
        itemData.setItemQuality(itemQuality);
    }

    @Override
    public String toString() {
        return "Item: " + this.getItemName() + ", DaysRemaining: " + this.getDaysRemainingBeforeExpiration() + ", Quality: " + this.getItemQuality();
    }
}