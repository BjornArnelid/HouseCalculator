package bjorn.arnelid.housecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Economy {
    private static final int TAX_FLOOR = 20431;
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
            int tax = member.getPay() > TAX_FLOOR ? member.getPay() * taxPercentage / 100 : 0;
            netIncome += member.getPay() - tax;
        }
        return netIncome;
    }
}
