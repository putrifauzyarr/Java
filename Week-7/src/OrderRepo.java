import java.util.*;

public class OrderRepo<T, U extends Number & Comparable<U>> {
    private List<Order<T, U>> orders = new ArrayList<>();

    public void add(Order<T, U> order) {
        orders.add(order);
    }

    public List<Order<T, U>> getOrders() {
        return orders;
    }

    // Calculate total 
    public static <T, U extends Number & Comparable<U>> 
    double calculateTotal(List<Order<T, U>> orders) {
        double total = 0;
        for (Order<T, U> order : orders) {
            total += order.getPrice().doubleValue();
        }
        return total;
    }

    // Find most expensive order 
    public static <T, U extends Number & Comparable<U>> 
    Order<T, U> findMax(List<Order<T, U>> orders) {
        if (orders.isEmpty()) {
            return null;
        }
        
        Order<T, U> max = orders.get(0);
        for (Order<T, U> order : orders) {
            if (order.getPrice().compareTo(max.getPrice()) > 0) {
                max = order;
            }
        }
        return max;
    }

        public void displayOrders() {
        for (Order<T, U> order : orders) {
            System.out.println(order);
        }
    }
}