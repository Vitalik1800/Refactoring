import java.util.*;

public class Items {
    private List<Item> items;

    public Items() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateQuality(){
        for(Item item : items){
            if(isLegendary(item)){
                continue;
            }
            updateItemQuality(item);
            updateSellIn(item);
            handleExpiredItem(item);
        }
    }

    private boolean isLegendary(Item item) {
        String itemName = item.name.getValue();
        return itemName.equals("Sulfuras, Hand of Ragnaros");
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
        String itemName = item.name.getValue();
        return itemName.equals("Aged Brie") || itemName.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQuality(Item item) {
        int quality = item.quality.getValue();
        if(quality < 50){
            item.quality.setValue(quality + 1);
        }
    }

    private void decreaseQuality(Item item) {
        int quality = item.quality.getValue();
        if(quality > 0){
            item.quality.setValue(quality - 1);
        }
    }

    private void handleSpecialCases(Item item) {
        String itemName = item.name.getValue();
        if(!itemName.equals("Backstage passes to a TAFKAL80ETC concert")){
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
        int sellIn = item.sellIn.getValue();
        item.sellIn.setValue(sellIn - 1);
    }

    private void handleExpiredItem(Item item) {
        if(item.sellIn.getValue() >= 0){
            return;
        }

        String itemName = item.name.getValue();
        if(itemName.equals("Aged Brie")){
            increaseQuality(item);
            return;
        }

        if(itemName.equals("Backstage passes to a TAFKAL80ETC concert")){
            item.quality.setValue(0);
            return;
        }

        decreaseQuality(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Item item : items){
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
