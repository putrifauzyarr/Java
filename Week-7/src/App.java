public class App {
    public static void main(String[] args) throws Exception {

        OrderRepo<String, Double> food = new OrderRepo<>();
        food.add(new Order<>("F1", 15.5));
        food.add(new Order<>("F2", 40.0));

        OrderRepo<Integer, Integer> electronics = new OrderRepo<>();
        electronics.add(new Order<>(11123, 3000000));
        electronics.add(new Order<>(11124, 150000));

        OrderRepo<String, Integer> service = new OrderRepo<>();
        service.add(new Order<>("S1", 50000));
        service.add(new Order<>("S2", 100000));

        System.out.println("Food Orders");
        food.displayOrders();
        System.out.println("Total: " + OrderRepo.calculateTotal(food.getOrders()));
        System.out.println("Most Expensive Order: " + OrderRepo.findMax(food.getOrders()));
        
        System.out.println("\nElectronics Orders");
        electronics.displayOrders();
        System.out.println("Total: " + OrderRepo.calculateTotal(electronics.getOrders()));
        System.out.println("Most Expensive Order: " + OrderRepo.findMax(electronics.getOrders()));

        System.out.println("\nService Orders");
        service.displayOrders();
        System.out.println("Total: " + OrderRepo.calculateTotal(service.getOrders()));
        System.out.println("Most Expensive Order: " + OrderRepo.findMax(service.getOrders()));
    }
}