public class ItemData {
    public final StringWrapper itemName;
    public final IntegerWrapper daysRemainingBeforeExpiration;
    public IntegerWrapper itemQuality;

    // Конструктор для ініціалізації
    public ItemData(StringWrapper itemName, IntegerWrapper daysRemainingBeforeExpiration, IntegerWrapper itemQuality) {
        this.itemName = itemName;
        this.daysRemainingBeforeExpiration = daysRemainingBeforeExpiration;
        this.itemQuality = itemQuality;
    }

    // Всі поля тепер доступні через ініціалізацію в конструкторі, без використання getter/setter.
}
