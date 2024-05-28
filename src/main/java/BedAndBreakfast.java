public class BedAndBreakfast implements Bookable {

    private int price;
    private Customer customer;

    public BedAndBreakfast(int price) {
        this.price = price;
        this.customer = null;
    }


    public void book(Customer customer) {
        if (customer.canAfford(this.price)) this.customer = customer;

        // Handle case for not being able to afford
//        TODO (Extension)
    }

    public void cancel(Customer customer) {
        customer.setWallet(this.price); // refund customer
        this.customer = null;
    }


    public boolean hasCapacity() {
        if (this.customer == null) return true;
        return false;
    }

//    Getters and setters
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }

}
