public class GildedRose {

    private final ItemCollection itemCollection;
    private final ItemUpdater itemUpdater;

    public GildedRose(ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
        this.itemUpdater = new ItemUpdater();
    }

    public void updateQuality() {
        itemUpdater.updateAllItemsQuality(itemCollection.items);
    }
}
