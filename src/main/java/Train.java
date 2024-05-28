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

    @Override
    public void book(Customer customer) {
        if (customer.canAfford(this.price) && this.capacity != 0 ) this.customers.add(customer);
        // Handle case for not being able to afford
        //        TODO (Extension)
    }


    @Override
    public void cancel(Customer customer) {
        customer.setWallet(this.price); // refund customer
        this.customers.remove(customer);

    }

    @Override
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

    public Customer getCustomer(int customerNumber) {
        return this.customers.get(customerNumber);
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
