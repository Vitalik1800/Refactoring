class GildedRose {

    Items items;

    public GildedRose(Items items) {
        this.items = items;
    }

    public void updateQuality() {
        items.updateQuality();
    }

}