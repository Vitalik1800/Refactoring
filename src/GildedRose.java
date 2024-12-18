class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {
            if(isLegendary(item)){
                continue;
            }
            updateItemQuality(item);
            updateSellIn(item);
            handleExpiredItem(item);
        }
    }

    private boolean isLegendary(Item item) {
        return item.name.getValue().equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateItemQuality(Item item) {
        if(isSpecialItem(item)){
            increaseQuality(item);
            handleSpecialCases(item);
            return;
        }
        decreaseQuality(item);
    }

    private boolean isSpecialItem(Item item) {
        return item.name.getValue().equals("Aged Brie") || item.name.getValue().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQuality(Item item) {
        if(item.quality.getValue() < 50){
            item.quality.setValue(item.quality.getValue() + 1);
        }
    }

    private void decreaseQuality(Item item) {
        if(item.quality.getValue() > 0){
            item.quality.setValue(item.quality.getValue() - 1);
        }
    }

    private void handleSpecialCases(Item item) {
        if(!item.name.getValue().equals("Backstage passes to a TAFKAL80ETC concert")){
            return;
        }

        if(item.sellIn.getValue() < 11){
            increaseQuality(item);
        }
        if(item.sellIn.getValue() < 6){
            increaseQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn.setValue(item.sellIn.getValue() - 1);
    }

    private void handleExpiredItem(Item item) {
        if(item.sellIn.getValue() >= 0){
            return;
        }

        if(item.name.getValue().equals("Aged Brie")){
            increaseQuality(item);
            return;
        }

        if(item.name.getValue().equals("Backstage passes to a TAFKAL80ETC concert")){
            item.quality.setValue(0);
            return;
        }

        decreaseQuality(item);
    }
}