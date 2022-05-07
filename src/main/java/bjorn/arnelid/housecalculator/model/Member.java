package bjorn.arnelid.housecalculator.model;

public class Member {
    private String name = "";
    private int pay = 0;

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, String incomeText) {
        this.name = name;
        this.pay = Integer.parseInt(incomeText);
    }

    public Member() {

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

    public void update(Member user) {
        this.name = user.getName();
        this.pay = user.getPay();
    }
}
