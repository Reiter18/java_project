import java.util.Arrays;
import java.util.List;

public class OrderManagementTest {
    public static void main(String[] args) {
        // Создаем систему управления заказами
        OrderHashTable orderSystem = new OrderHashTable();
        
        // Создаем тестовые заказы
        List<String> products1 = Arrays.asList("iPhone 15", "AirPods", "Чехол");
        Order order1 = new Order(1001, products1, "ул. Ленина, 10", 125000.0);
        
        List<String> products2 = Arrays.asList("MacBook Pro", "Мышь Bluetooth");
        Order order2 = new Order(1002, products2, "пр. Мира, 25", 250000.0);
        
        List<String> products3 = Arrays.asList("iPad Air", "Apple Pencil", "Чехол");
        Order order3 = new Order(1003, products3, "ул. Садовая, 5", 85000.0);
        
        // Тестируем основные операции
        System.out.println("=== ТЕСТИРОВАНИЕ СИСТЕМЫ УПРАВЛЕНИЯ ЗАКАЗАМИ ===\n");
        
        // Добавление заказов
        orderSystem.put(1001, order1);
        orderSystem.put(1002, order2);
        orderSystem.put(1003, order3);
        
        System.out.println("После добавления заказов:");
        orderSystem.displayAllOrders();
        System.out.println("Общее количество заказов: " + orderSystem.size());
        System.out.println("Система пуста? " + orderSystem.isEmpty());
        
        // Поиск заказов
        System.out.println("\n=== ТЕСТ ПОИСКА ЗАКАЗОВ ===");
        Order foundOrder = orderSystem.get(1002);
        System.out.println("Найден заказ 1002: " + foundOrder);
        
        Order notFoundOrder = orderSystem.get(9999);
        System.out.println("Найден заказ 9999: " + notFoundOrder);
        
        // Обновление заказа
        System.out.println("\n=== ТЕСТ ОБНОВЛЕНИЯ ЗАКАЗА ===");
        List<String> updatedProducts = Arrays.asList("iPhone 15", "AirPods Pro", "Чехол", "Защитное стекло");
        Order updatedOrder = new Order(1001, updatedProducts, "ул. Ленина, 10", 140000.0);
        orderSystem.put(1001, updatedOrder);
        
        System.out.println("После обновления заказа 1001:");
        System.out.println(orderSystem.get(1001));
        
        // Обновление адреса доставки
        System.out.println("\n=== ТЕСТ ОБНОВЛЕНИЯ АДРЕСА ===");
        orderSystem.updateOrderAddress(1003, "ул. Новая, 15");
        System.out.println("После изменения адреса заказа 1003:");
        System.out.println(orderSystem.get(1003));
        
        // Поиск заказов по товару
        System.out.println("\n=== ТЕСТ ПОИСКА ПО ТОВАРУ ===");
        orderSystem.findOrdersByProduct("Чехол");
        
        // Удаление заказа
        System.out.println("\n=== ТЕСТ УДАЛЕНИЯ ЗАКАЗА ===");
        orderSystem.remove(1002);
        System.out.println("После удаления заказа 1002:");
        orderSystem.displayAllOrders();
        System.out.println("Общее количество заказов: " + orderSystem.size());
        
        // Тест коллизий
        System.out.println("\n=== ТЕСТ КОЛЛИЗИЙ ===");
        OrderHashTable collisionTable = new OrderHashTable(5);
        
        List<String> products4 = Arrays.asList("Товар A");
        List<String> products5 = Arrays.asList("Товар B");
        List<String> products6 = Arrays.asList("Товар C");
        
        Order order4 = new Order(1, products4, "Адрес 1", 1000.0);
        Order order5 = new Order(6, products5, "Адрес 2", 2000.0);  // Коллизия с 1
        Order order6 = new Order(11, products6, "Адрес 3", 3000.0); // Коллизия с 1 и 6
        
        collisionTable.put(1, order4);
        collisionTable.put(6, order5);
        collisionTable.put(11, order6);
        
        System.out.println("Заказы в таблице с коллизиями:");
        collisionTable.displayAllOrders();
        
        // Проверяем получение при коллизиях
        System.out.println("Заказ 1: " + collisionTable.get(1));
        System.out.println("Заказ 6: " + collisionTable.get(6));
        System.out.println("Заказ 11: " + collisionTable.get(11));
    }
}

