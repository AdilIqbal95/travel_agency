public class Customer {

    private String name;
    private int wallet;

    public Customer(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public void buy(int amount) {
        if (amount <= this.wallet) {
            this.wallet -= amount;
        } else {
            System.out.println("not enough money");
        }
    }

    public boolean canAfford(int product) {
        if (product <= this.wallet) {
            return true;
        } else {
            return false;
        }
    }

//    Getters and setters

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getWallet() {
        return this.wallet;
    }

    public void setWallet(int newAmount) {
        this.wallet += newAmount;
    }

}
