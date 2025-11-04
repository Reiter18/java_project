public class HashTableTest {
    public static void main(String[] args) {
        // Создаем хэш-таблицу
        HashTable<String, Integer> hashTable = new HashTable<>();
        
        // Тестируем основные операции
        System.out.println("=== ТЕСТИРОВАНИЕ ХЭШ-ТАБЛИЦЫ ===");
        
        // Добавление элементов
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);
        hashTable.put("grape", 2);
        
        System.out.println("После добавления элементов:");
        hashTable.display();
        System.out.println("Размер: " + hashTable.size());
        System.out.println("Пустая? " + hashTable.isEmpty());
        
        // Получение элементов
        System.out.println("\n=== ТЕСТ ПОЛУЧЕНИЯ ===");
        System.out.println("apple: " + hashTable.get("apple"));
        System.out.println("banana: " + hashTable.get("banana"));
        System.out.println("mango: " + hashTable.get("mango")); // Не существует
        
        // Обновление элемента
        System.out.println("\n=== ТЕСТ ОБНОВЛЕНИЯ ===");
        hashTable.put("apple", 10);
        System.out.println("После обновления apple:");
        hashTable.display();
        
        // Удаление элемента
        System.out.println("\n=== ТЕСТ УДАЛЕНИЯ ===");
        hashTable.remove("banana");
        System.out.println("После удаления banana:");
        hashTable.display();
        System.out.println("Размер: " + hashTable.size());
        
        // Тест коллизий
        System.out.println("\n=== ТЕСТ КОЛЛИЗИЙ ===");
        HashTable<Integer, String> collisionTable = new HashTable<>(5);
        collisionTable.put(1, "one");
        collisionTable.put(6, "six"); // Должна быть коллизия с 1
        collisionTable.put(11, "eleven"); // Должна быть коллизия с 1 и 6
        
        System.out.println("Таблица с коллизиями:");
        collisionTable.display();
        
        // Проверяем получение при коллизиях
        System.out.println("Ключ 1: " + collisionTable.get(1));
        System.out.println("Ключ 6: " + collisionTable.get(6));
        System.out.println("Ключ 11: " + collisionTable.get(11));
    }
}