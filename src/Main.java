public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item("Aged Brie", 10, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Regular Item", 15, 25)
        };

        // Створення об'єкта GildedRose
        GildedRose app = new GildedRose(items);

        // До оновлення
        System.out.println("Before update:");
        printItems(items);

        // Оновлення якості
        app.updateQuality();

        // Після оновлення
        System.out.println("After update:");
        printItems(items);
    }

    private static void printItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
