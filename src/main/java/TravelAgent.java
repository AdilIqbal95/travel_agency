public class TravelAgent {


    public TravelAgent() {

    }


    public void makeBooking(Bookable bookable, Customer customer) {
        if (bookable.hasCapacity() && customer.canAfford(bookable.getPrice())) {
            customer.buy(bookable.getPrice());
        }

    }

    public void cancelBooking(Bookable bookable, Customer customer) {
        bookable.cancel(customer);
    }


}
