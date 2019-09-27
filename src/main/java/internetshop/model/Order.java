package internetshop.model;

import internetshop.idstorage.OrderIdGenerator;

import java.util.List;

public class Order {
    private Long id;
    private List<Item> items;
    private User user;
    private double totalPrice;

    public Order(List<Item> items, User user) {
        id = OrderIdGenerator.generateId();
        this.items = items;
        this.user = user;
        totalPrice = items.stream().mapToDouble(Item::getPrice).sum();
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{"
                + "id=" + id + ", items=" + items + ", user="
                + user + ", totalPrice=" + totalPrice + '}';
    }
}
