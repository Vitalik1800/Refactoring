import java.util.ArrayList;
import java.util.List;

public class ItemCollection {
    public final List<Item> items;

    // Конструктор для ініціалізації
    public ItemCollection() {
        this.items = new ArrayList<>();
    }

    // Додавання елементів без getter
    public void addItem(Item item) {
        items.add(item);
    }

    // Створюємо власну строкову репрезентацію колекції
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}
