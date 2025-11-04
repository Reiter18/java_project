import java.util.Arrays;
import java.util.List;

public class OrderManagementTest {
    public static void main(String[] args) {
        OrderManagement orderSystem = new OrderManagement();
        
        System.out.println("=== ТЕСТИРОВАНИЕ ВСТРОЕННОГО HashMap ===\n");

        List<String> products1 = Arrays.asList("iPhone 15", "AirPods", "Чехол");
        Order order1 = new Order(1001, products1, "ул. Ленина, 10", 125000.0);
        
        List<String> products2 = Arrays.asList("MacBook Pro", "Мышь Bluetooth");
        Order order2 = new Order(1002, products2, "пр. Мира, 25", 250000.0);
        
        List<String> products3 = Arrays.asList("iPad Air", "Apple Pencil", "Чехол");
        Order order3 = new Order(1003, products3, "ул. Садовая, 5", 85000.0);

        System.out.println("1. ДОБАВЛЕНИЕ ЗАКАЗОВ:");
        orderSystem.addOrder(order1);
        orderSystem.addOrder(order2);
        orderSystem.addOrder(order3);
        
        System.out.println("Количество заказов: " + orderSystem.getOrderCount());
        System.out.println("Система пуста? " + orderSystem.isEmpty());

        System.out.println("\n2. ВСЕ ЗАКАЗЫ:");
        orderSystem.displayAllOrders();

        System.out.println("\n3. ПОИСК ЗАКАЗОВ:");
        Order foundOrder = orderSystem.getOrder(1002);
        System.out.println("Найден заказ: " + foundOrder);
        
        orderSystem.getOrder(9999); 

        System.out.println("\n4. ПРОВЕРКА СУЩЕСТВОВАНИЯ:");
        System.out.println("Заказ 1001 существует? " + orderSystem.containsOrder(1001));
        System.out.println("Заказ 9999 существует? " + orderSystem.containsOrder(9999));

        System.out.println("\n5. УДАЛЕНИЕ ЗАКАЗА:");
        orderSystem.removeOrder(1002);
        System.out.println("Количество заказов после удаления: " + orderSystem.getOrderCount());
        
        orderSystem.removeOrder(9999);

        System.out.println("\n6. ФИНАЛЬНОЕ СОСТОЯНИЕ:");
        orderSystem.displayAllOrders();

        System.out.println("\n7. ОЧИСТКА СИСТЕМЫ:");
        orderSystem.clearAllOrders();
        System.out.println("Количество заказов после очистки: " + orderSystem.getOrderCount());
        System.out.println("Система пуста? " + orderSystem.isEmpty());
    }
}