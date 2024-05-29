import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrainTest {

    Train train;
    Customer customer;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    public void setUp(){
        train = new Train(10, 2);
        customer = new Customer("Huso", 50);
        customer2 = new Customer("Adil", 5);
        customer3 = new Customer("Bob", 40);
    }

    @Test
    public void canBook() {
        train.book(customer);
        assertThat(train.getCustomer().size()).isEqualTo(1);
    }

    @Test
    public void canBook__customerCantAfford() {
        train.book(customer2);
        assertThat(customer2.getWallet()).isEqualTo(5);
    }

    @Test
    public void canBook__notEnoughCapacity() {
        Customer customer4 = new Customer("Charlotte", 80);
        train.book(customer);
        train.book(customer3);
        train.book(customer4);
        assertThat(customer4.getWallet()).isEqualTo(80);
    }

    @Test
    public void canCancel() {
        train.book(customer);
        train.cancel(customer);
        assertThat(train.getCustomer().isEmpty()).isEqualTo(true);
        assertThat(customer.getWallet()).isEqualTo(50);
    }

    @Test
    public void checkCapacity__true() {
        assertThat(train.hasCapacity()).isEqualTo(true);
    }

    @Test
    public void checkCapacity__false() {
        train.book(customer);
        train.book(customer3);
        assertThat(train.hasCapacity()).isEqualTo(false);
    }

    @Test
    public void canGetPrice() {
        assertThat(train.getPrice()).isEqualTo(10);
    }

    @Test
    public void canSetPrice() {
        train.setPrice(30);
        assertThat(train.getPrice()).isEqualTo(30);
    }

    @Test
    public void canGetCustomer() {
        assertThat(train.getCustomer().isEmpty()).isEqualTo(true);
    }

    @Test
    public void canGetCustomer__byIndex() {
        train.setCustomer(customer);
        assertThat(train.getCustomer().get(0)).isEqualTo(customer);
    }

    @Test
    public void canSetCustomer() {
        train.setCustomer(customer);
        assertThat(train.getCustomer().size()).isEqualTo(1);
    }

    @Test
    public void canGetCapacity() {
        assertThat(train.getCapacity()).isEqualTo(2);
    }

    @Test
    public void canSetCapacity() {
        train.setCapacity(10);
        assertThat(train.getCapacity()).isEqualTo(10);
    }


}
