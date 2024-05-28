import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerTest {

    Customer customer;

    @BeforeEach
    public void setUp(){
        customer = new Customer("Huso", 50);
    }

    @Test
    public void canBuy__EnoughMoney() {
        customer.buy(30);
        assertThat(customer.getWallet()).isEqualTo(20);
    }

    @Test
    public void canBuy__notEnoughMoney() {
        customer.buy(70);
        assertThat(customer.getWallet()).isEqualTo(50);
    }

    @Test
    public void canAfford__true() {
        assertThat(customer.canAfford(40)).isEqualTo(true);
    }

    @Test
    public void canAfford__false() {
        assertThat(customer.canAfford(70)).isEqualTo(false);
    }

    @Test
    public void canGetName() {
        assertThat(customer.getName()).isEqualTo("Huso");
    }

    @Test
    public void canSetName() {
        customer.setName("Adil");
        assertThat(customer.getName()).isEqualTo("Adil");
    }

    @Test
    public void canGetWallet() {
        assertThat(customer.getWallet()).isEqualTo(50);
    }

    @Test
    public void canSetWallet() {
        customer.setWallet(90);
        assertThat(customer.getWallet()).isEqualTo(140);
    }









}
