package bjorn.arnelid.housecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Economy {
    private static final int TAX_FLOOR = 20431;
    private static final int GOVT_TAX_FLOOR = 46242;
    private static final int GOVT_TAX = 20;
    private final ArrayList<Member> members = new ArrayList<>();
    private final int taxPercentage;

    public Economy(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public int getIncome() {
        return members.stream().mapToInt(Member::getPay).sum();
    }

    public int getToSpend() {
        return (int) Math.round(0.25 * getNetIncome());
    }

    public List<Member> getMembers() {
        return members;
    }

    public int getNetIncome() {
        int netIncome = 0;
        for (Member member : members) {
            netIncome += member.getPay() - calculateTax(member.getPay());
        }
        return netIncome;
    }

    private int calculateTax(int pay) {
        if (pay < TAX_FLOOR) {
            return 0;
        } else if (pay > GOVT_TAX_FLOOR) {
            int normalTax = pay * taxPercentage / 100;
            int governmentTax = (pay - GOVT_TAX_FLOOR) * GOVT_TAX / 100;
            return normalTax + governmentTax;
        }
        return pay * taxPercentage / 100;
    }
}
