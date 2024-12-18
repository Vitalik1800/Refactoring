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
        return item.name.equals("Sulfuras, Hand of Ragnaros");
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
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQuality(Item item) {
        if(item.quality < 50){
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if(item.quality > 0){
            item.quality--;
        }
    }

    private void handleSpecialCases(Item item) {
        if(!item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            return;
        }

        if(item.sellIn < 11){
            increaseQuality(item);
        }
        if(item.sellIn < 6){
            increaseQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn--;
    }

    private void handleExpiredItem(Item item) {
        if(item.sellIn >= 0){
            return;
        }

        if(item.name.equals("Aged Brie")){
            increaseQuality(item);
            return;
        }

        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            item.quality = 0;
            return;
        }

        decreaseQuality(item);
    }


}