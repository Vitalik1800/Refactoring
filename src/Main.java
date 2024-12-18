public class Main {
    public static void main(String[] args) {
        Items items = new Items();
        items.addItem(new Item("Aged Brie", 10, 20));
        items.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30));
        items.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.addItem(new Item("Regular Item", 15, 25));

        // Створення об'єкта GildedRose
        GildedRose app = new GildedRose(items);

        // До оновлення
        System.out.println("Before update:");
        System.out.println(items);

        // Оновлення якості
        app.updateQuality();

        // Після оновлення
        System.out.println("After update:");
        System.out.println(items);
    }
}
