import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TravelAgentTest {

    Customer customer;
    Customer customer2;
    Train train;
    TravelAgent travelAgent;

    @BeforeEach
    public void setUp(){
        travelAgent = new TravelAgent();
        train = new Train(10, 2);
        customer = new Customer("Huso", 50);
        customer2 = new Customer("Adil", 5);
    }

    @Test
    public void canMakeBooking() {
        travelAgent.makeBooking(train,customer);
        assertThat(customer.getWallet()).isEqualTo(40);
    }

    @Test
    public void canMakeBooking__customerCantAfford() {
        travelAgent.makeBooking(train,customer2);;
        assertThat(customer2.getWallet()).isEqualTo(5);
    }

    @Test
    public void canCancelBooking() {
        travelAgent.makeBooking(train,customer);
        travelAgent.cancelBooking(train,customer);
        assertThat(customer.getWallet()).isEqualTo(50);
    }



}
