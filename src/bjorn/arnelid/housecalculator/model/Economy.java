package bjorn.arnelid.housecalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Economy {
    ArrayList<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }

    public int getIncome() {
        return members.stream().collect(Collectors.summingInt(Member::getPay));
    }

    public int getToSpend() {
        return (int) Math.round(0.25 * getIncome());
    }

    public List<Member> getMembers() {
        return members;
    }
}
