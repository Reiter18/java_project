import java.util.HashMap;
import java.util.Map;

public class OrderManagement {
    private HashMap<Integer, Order> orderMap;

    public OrderManagement() {
        this.orderMap = new HashMap<>();
    }

    public void addOrder(Order order) {
        orderMap.put(order.getOrderId(), order);
        System.out.println("Заказ " + order.getOrderId() + " добавлен в систему");
    }

    public Order getOrder(int orderId) {
        Order order = orderMap.get(orderId);
        if (order == null) {
            System.out.println("Заказ " + orderId + " не найден");
        }
        return order;
    }

    public void removeOrder(int orderId) {
        Order removedOrder = orderMap.remove(orderId);
        if (removedOrder != null) {
            System.out.println("Заказ " + orderId + " удален из системы");
        } else {
            System.out.println("Заказ " + orderId + " не найден для удаления");
        }
    }

    public boolean containsOrder(int orderId) {
        return orderMap.containsKey(orderId);
    }

    public void displayAllOrders() {
        System.out.println("=== ВСЕ ЗАКАЗЫ В СИСТЕМЕ (HashMap) ===");
        if (orderMap.isEmpty()) {
            System.out.println("Система пуста");
            return;
        }
        
        for (Map.Entry<Integer, Order> entry : orderMap.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public int getOrderCount() {
        return orderMap.size();
    }

    public boolean isEmpty() {
        return orderMap.isEmpty();
    }

    public void clearAllOrders() {
        orderMap.clear();
        System.out.println("Все заказы удалены из системы");
    }
}