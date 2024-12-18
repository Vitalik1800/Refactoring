import java.util.List;

public class ItemUpdater {

    public void updateAllItemsQuality(List<Item> items) {
        for (Item item : items) {
            if (!isLegendary(item)) {
                updateItemQuality(item);
                updateSellIn(item);
                handleExpiredItem(item);
            }
        }
    }

    private boolean isLegendary(Item item) {
        return item.itemData.itemName.equals("Sulfuras, Hand of Ragnaros");
    }

    private void updateItemQuality(Item item) {
        if (isSpecialItem(item)) {
            increaseQuality(item);
            handleSpecialCases(item);
        } else {
            decreaseQuality(item);
        }
    }

    private boolean isSpecialItem(Item item) {
        StringWrapper itemName = item.itemData.itemName;
        return itemName.equals("Aged Brie") || itemName.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQuality(Item item) {
        item.itemData.itemQuality.increment();
    }

    private void decreaseQuality(Item item) {
        item.itemData.itemQuality.decrement();
    }

    private void handleSpecialCases(Item item) {
        StringWrapper itemName = item.itemData.itemName;
        if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            IntegerWrapper daysRemainingWrapper = item.itemData.daysRemainingBeforeExpiration;
            int daysRemaining = daysRemainingWrapper.value;

            if (daysRemaining < 11) {
                increaseQuality(item);
            }
            if (daysRemaining < 6) {
                increaseQuality(item);
            }
        }
    }

    private void updateSellIn(Item item) {
        IntegerWrapper daysRemainingWrapper = item.itemData.daysRemainingBeforeExpiration;
        daysRemainingWrapper.decrement();
    }

    private void handleExpiredItem(Item item) {
        IntegerWrapper daysRemainingWrapper = item.itemData.daysRemainingBeforeExpiration;
        int daysRemaining = daysRemainingWrapper.value;

        if (daysRemaining < 0) {
            if (item.itemData.itemName.equals("Aged Brie")) {
                increaseQuality(item);
            } else if (item.itemData.itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.itemData.itemQuality = new IntegerWrapper(daysRemaining + 1);
            } else {
                decreaseQuality(item);
            }
        }
    }
}