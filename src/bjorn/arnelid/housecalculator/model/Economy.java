package bjorn.arnelid.housecalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Economy {
    ArrayList<Member> members = new ArrayList<>();
    private int taxPercentage;

    public Economy(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public int getIncome() {
        return members.stream().collect(Collectors.summingInt(Member::getPay));
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
            int tax = member.getPay() * taxPercentage / 100;
            netIncome += member.getPay() - tax;
        }
        return netIncome;
    }
}
