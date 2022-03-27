package bjorn.arnelid.housecalculator;

public class User {
    private final String name;
    private int pay = 0;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPay() {
        return this.pay;
    }

    public void setPay(int ammount) {
        this.pay = ammount;
    }
}
