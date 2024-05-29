import java.util.ArrayList;
import java.util.List;

public class Train implements Bookable {

    private int price;
    private int capacity;
    private ArrayList<Customer> customers;

    public Train(int price, int capacity){
        this.price = price;
        this.capacity = capacity;
        this.customers = new ArrayList<>(capacity);
    }

    public void book(Customer customer) {
       if (customer.canAfford(this.price) && this.hasCapacity() ) {
           this.customers.add(customer);
           customer.buy(this.price);
       }
    }

    public void cancel(Customer customer) {
        customer.setWallet(this.price); // refund customer
        this.customers.remove(customer);

    }

    public boolean hasCapacity() {
        if (this.customers.size() < capacity) return true;
        return false;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    public ArrayList<Customer> getCustomer() {
        return this.customers;
    }

    public void setCustomer(Customer newCustomer) {
        this.customers.add(newCustomer);
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int newCapacity){
        this.capacity = newCapacity;
    }

}
