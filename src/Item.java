public class Item {
    public final ItemData itemData;

    // Конструктор для ініціалізації
    public Item(String itemName, int daysRemainingBeforeExpiration, int itemQuality) {
        this.itemData = new ItemData(new StringWrapper(itemName), new IntegerWrapper(daysRemainingBeforeExpiration), new IntegerWrapper(itemQuality));
    }

    // Замість getter/setter, доступ до полів здійснюється через об'єкти itemData.
    public String toString() {
        return "Item: " + itemData.itemName + ", DaysRemaining: " + itemData.daysRemainingBeforeExpiration + ", Quality: " + itemData.itemQuality;
    }
}
