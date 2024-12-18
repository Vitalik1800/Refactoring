public class Main {
    public static void main(String[] args) {
        ItemCollection itemCollection = new ItemCollection();
        itemCollection.addItem(new Item("Aged Brie", 10, 20));
        itemCollection.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30));
        itemCollection.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        itemCollection.addItem(new Item("Regular Item", 15, 25));

        // Створення об'єкта GildedRose
        GildedRose app = new GildedRose(itemCollection);

        // До оновлення
        System.out.println("Before update:");
        System.out.println(itemCollection);

        // Оновлення якості
        app.updateQuality();

        // Після оновлення
        System.out.println("After update:");
        System.out.println(itemCollection);
    }
}
