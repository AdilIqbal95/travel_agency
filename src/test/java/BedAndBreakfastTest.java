import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BedAndBreakfastTest {

    BedAndBreakfast bedAndBreakfast;
    Customer customer;
    Customer customer2;

    @BeforeEach
    public void setUp(){
        bedAndBreakfast = new BedAndBreakfast(20);
        customer = new Customer("Huso", 50);
        customer2 = new Customer("Adil", 15);
    }

    @Test
    public void canBook() {
        bedAndBreakfast.book(customer);
        Customer expectedResult = customer;
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(expectedResult);
    }


}
