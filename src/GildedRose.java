class GildedRose {

    private final ItemCollection itemCollection;
    private ItemUpdater itemUpdater;

    public GildedRose(ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
        this.itemUpdater = new ItemUpdater();
    }

    public void updateQuality() {
        itemUpdater.updateAllItemsQuality(itemCollection.getItems());
    }

}