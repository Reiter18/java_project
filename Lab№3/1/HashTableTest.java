public class HashTableTest {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        
        System.out.println("=== ТЕСТИРОВАНИЕ ХЭШ-ТАБЛИЦЫ ===");
        
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);
        hashTable.put("grape", 2);
        
        System.out.println("После добавления элементов:");
        hashTable.display();
        System.out.println("Размер: " + hashTable.size());
        System.out.println("Пустая? " + hashTable.isEmpty());
        
        System.out.println("\n=== ТЕСТ ПОЛУЧЕНИЯ ===");
        System.out.println("apple: " + hashTable.get("apple"));
        System.out.println("banana: " + hashTable.get("banana"));
        System.out.println("mango: " + hashTable.get("mango")); 
        
        System.out.println("\n=== ТЕСТ ОБНОВЛЕНИЯ ===");
        hashTable.put("apple", 10);
        System.out.println("После обновления apple:");
        hashTable.display();
        
        System.out.println("\n=== ТЕСТ УДАЛЕНИЯ ===");
        hashTable.remove("banana");
        System.out.println("После удаления banana:");
        hashTable.display();
        System.out.println("Размер: " + hashTable.size());
        
        // Тест коллизий
        System.out.println("\n=== ТЕСТ КОЛЛИЗИЙ ===");
        HashTable<Integer, String> collisionTable = new HashTable<>(5);
        collisionTable.put(1, "one");
        collisionTable.put(6, "six"); 
        collisionTable.put(11, "eleven"); 
        
        System.out.println("Таблица с коллизиями:");
        collisionTable.display();
        
        System.out.println("Ключ 1: " + collisionTable.get(1));
        System.out.println("Ключ 6: " + collisionTable.get(6));
        System.out.println("Ключ 11: " + collisionTable.get(11));
    }
}