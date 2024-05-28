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

    @Test
    public void canBook__customerCantAfford() {
        bedAndBreakfast.book(customer2);
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(null);
    }

    @Test
    public void canBook__notEnoughCapacity() {
        bedAndBreakfast.book(customer);
        bedAndBreakfast.book(customer2);
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(customer);
    }


    @Test
    public void canCancel() {
        bedAndBreakfast.cancel(customer);
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(null);
    }

    @Test
    public void checkCapacity__true() {
        assertThat(bedAndBreakfast.hasCapacity()).isEqualTo(true);
    }

    @Test
    public void checkCapacity__false() {
        bedAndBreakfast.book(customer);
        assertThat(bedAndBreakfast.hasCapacity()).isEqualTo(false);
    }

    @Test
    public void canGetPrice() {
        assertThat(bedAndBreakfast.getPrice()).isEqualTo(20);
    }

    @Test
    public void canSetPrice() {
        bedAndBreakfast.setPrice(30);
        assertThat(bedAndBreakfast.getPrice()).isEqualTo(30);
    }

    @Test
    public void canGetCustomer__whenEmpty() {
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(null);
    }

    @Test
    public void canGetCustomer__whenNotEmpty() {
        bedAndBreakfast.book(customer);
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(customer);
    }

    @Test
    public void canSetCustomer() {
        Customer newCustomer = new Customer("Charlie", 40);
        bedAndBreakfast.setCustomer(newCustomer);
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(newCustomer);
    }



}
