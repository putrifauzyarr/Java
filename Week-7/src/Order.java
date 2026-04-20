public class Order<T, U extends Number & Comparable<U>> {
    private T Id;
    private U price;

    public Order (T a, U b) {
        this.Id = a;
        this.price = b;
    }

    public T getId () {
        return this.Id;
    }

    public U getPrice () {
        return this.price;
    }

    public String toString () {
        return "Id: " + this.Id + ", Price: " + this.price;
    }
}