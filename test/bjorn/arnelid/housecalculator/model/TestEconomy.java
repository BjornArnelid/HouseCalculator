package bjorn.arnelid.housecalculator.model;

import bjorn.arnelid.housecalculator.model.Economy;
import bjorn.arnelid.housecalculator.model.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEconomy {
    @Test
    public void testTotalIncome() {
        Economy economy = getEconomy();
        assertEquals(40000, economy.getIncome());
    }

    private Economy getEconomy() {
        Economy economy = new Economy();
        Member user1 = new Member("User 1");
        user1.setPay(10000);
        Member user2 = new Member("User 2");
        user2.setPay(30000);
        economy.addMember(user1);
        economy.addMember(user2);
        return economy;
    }

    @Test
    public void getMembers() {
        Economy economy = new Economy();
        Member user1 = new Member("User 1");
        economy.addMember(user1);
        assertEquals(user1, economy.getMembers().get(0));
    }

    @Test
    public void getDisposableIncome() {
        Economy economy = getEconomy();
        assertEquals(10000, economy.getToSpend());
    }
}
