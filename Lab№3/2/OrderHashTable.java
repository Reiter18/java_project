import java.util.LinkedList;

public class OrderHashTable {
    private static class Entry {
        int key;
        Order value;
        
        Entry(int key, Order value) {
            this.key = key;
            this.value = value;
        }
        
        public int getKey() {
            return key;
        }
        
        public Order getValue() {
            return value;
        }
        
        public void setValue(Order value) {
            this.value = value;
        }
    }
    
    private LinkedList<Entry>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    
    @SuppressWarnings("unchecked")
    public OrderHashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }
    
    @SuppressWarnings("unchecked")
    public OrderHashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }
    
    private int hash(int key) {
        return Math.abs(key) % table.length;
    }
    
    // Добавление заказа
    public void put(int orderId, Order order) {
        int index = hash(orderId);
        
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        
        // Проверяем, существует ли уже заказ с таким ID
        for (Entry entry : table[index]) {
            if (entry.getKey() == orderId) {
                entry.setValue(order);
                return;
            }
        }
        
        // Добавляем новую запись
        table[index].add(new Entry(orderId, order));
        size++;
    }
    
    // Получение заказа по ID
    public Order get(int orderId) {
        int index = hash(orderId);
        
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (entry.getKey() == orderId) {
                    return entry.getValue();
                }
            }
        }
        
        return null;
    }
    
    // Удаление заказа по ID
    public void remove(int orderId) {
        int index = hash(orderId);
        
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (entry.getKey() == orderId) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Метод для изменения статуса заказа (дополнительная функциональность)
    public void updateOrderAddress(int orderId, String newAddress) {
        Order order = get(orderId);
        if (order != null) {
            order.setDeliveryAddress(newAddress);
        }
    }
    
    // Отображение всех заказов
    public void displayAllOrders() {
        System.out.println("=== ВСЕ ЗАКАЗЫ В СИСТЕМЕ ===");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry entry : table[i]) {
                    System.out.println(entry.getValue());
                }
            }
        }
    }
    
    // Поиск заказов по товару
    public void findOrdersByProduct(String productName) {
        System.out.println("=== ЗАКАЗЫ С ТОВАРОМ: " + productName + " ===");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry entry : table[i]) {
                    Order order = entry.getValue();
                    if (order.getProducts().contains(productName)) {
                        System.out.println(order);
                    }
                }
            }
        }
    }
}