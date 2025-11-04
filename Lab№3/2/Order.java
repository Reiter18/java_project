import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Order {
    private int orderId;
    private List<String> products;
    private String deliveryAddress;
    private double totalCost;

    public Order(int orderId, List<String> products, String deliveryAddress, double totalCost) {
        this.orderId = orderId;
        this.products = new ArrayList<>(products);
        this.deliveryAddress = deliveryAddress;
        this.totalCost = totalCost;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<String> getProducts() {
        return new ArrayList<>(products);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setProducts(List<String> products) {
        this.products = new ArrayList<>(products);
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", products=" + products +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}