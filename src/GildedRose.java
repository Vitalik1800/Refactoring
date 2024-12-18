class GildedRose {

    ItemCollection itemCollection;

    public GildedRose(ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
    }

    public void updateQuality() {
        itemCollection.updateQuality();
    }

}