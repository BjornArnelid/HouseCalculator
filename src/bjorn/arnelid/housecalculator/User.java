package bjorn.arnelid.housecalculator;

public class User {
    private String name = "";
    private int pay = 0;

    public User(String name) {
        this.name = name;
    }

    public User(String name, String incomeText) {
        this.name = name;
        this.pay = Integer.parseInt(incomeText);
    }

    public User() {

    }

    public String getName() {
        return this.name;
    }

    // TODO Calculate according to
    //  https://www.skatteverket.se/privat/skatter/arbeteochinkomst/sabeskattasdinlon.4.54a3d27615036ac09f316ce.html
    public int getPay() {
        return this.pay;
    }

    public void setPay(int ammount) {
        this.pay = ammount;
    }

    public void update(User user) {
        this.name = user.getName();
        this.pay = user.getPay();
    }
}
