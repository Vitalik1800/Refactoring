import java.util.*;

public class ItemCollection {
    private List<Item> items;

    public ItemCollection() {
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
        String itemName = item.itemName.getValue();
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
        String itemName = item.itemName.getValue();
        return itemName.equals("Aged Brie") || itemName.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQuality(Item item) {
        int quality = item.itemQuality.getValue();
        if(quality < 50){
            item.itemQuality.setValue(quality + 1);
        }
    }

    private void decreaseQuality(Item item) {
        int quality = item.itemQuality.getValue();
        if(quality > 0){
            item.itemQuality.setValue(quality - 1);
        }
    }

    private void handleSpecialCases(Item item) {
        String itemName = item.itemName.getValue();
        if(!itemName.equals("Backstage passes to a TAFKAL80ETC concert")){
            return;
        }

        if(item.daysRemainingBeforeExpiration.getValue() < 11){
            increaseQuality(item);
        }
        if(item.daysRemainingBeforeExpiration.getValue() < 6){
            increaseQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        int daysRemainingBeforeExpiration = item.daysRemainingBeforeExpiration.getValue();
        item.daysRemainingBeforeExpiration.setValue(daysRemainingBeforeExpiration - 1);
    }

    private void handleExpiredItem(Item item) {
        if(item.daysRemainingBeforeExpiration.getValue() >= 0){
            return;
        }

        String itemName = item.itemName.getValue();
        if(itemName.equals("Aged Brie")){
            increaseQuality(item);
            return;
        }

        if(itemName.equals("Backstage passes to a TAFKAL80ETC concert")){
            item.itemQuality.setValue(0);
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
