import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TravelAgentTest {

    Customer customer;
    Customer customer2;
    Train train;

    @BeforeEach
    public void setUp(){
        train = new Train(10, 2);
        customer = new Customer("Huso", 50);
        customer2 = new Customer("Adil", 5);
    }

    @Test
    public void canBook() {
        train.book(customer);
        Customer expectedResult = customer;
        assertThat(train.getCustomer(0)).isEqualTo(expectedResult);
    }

    @Test
    public void canBook__customerCantAfford() {
        train.book(customer2);
        assertThat(train.getCustomer(0)).isEqualTo(null);
    }

}
