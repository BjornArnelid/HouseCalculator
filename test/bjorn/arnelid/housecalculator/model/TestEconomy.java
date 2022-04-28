package bjorn.arnelid.housecalculator.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEconomy {
    @Test
    public void testTotalIncome() {
        Economy economy = new Economy(0);
        Member user1 = new Member("User 1");
        user1.setPay(10000);
        Member user2 = new Member("User 2");
        user2.setPay(30000);
        economy.addMember(user1);
        economy.addMember(user2);

        assertEquals(40000, economy.getIncome());
    }

    @Test
    public void getMembers() {
        Economy economy = new Economy(0);
        Member user1 = new Member("User 1");
        economy.addMember(user1);

        assertEquals(user1, economy.getMembers().get(0));
    }

    @Test
    public void calculateToSpend() {
        Economy economy = new Economy(0);
        Member user1 = new Member("User 1");
        user1.setPay(10000);
        Member user2 = new Member("User 2");
        user2.setPay(30000);
        economy.addMember(user1);
        economy.addMember(user2);

        assertEquals(10000, economy.getToSpend());
    }

    @Test
    public void calculateStandardTax() {
        Economy economy = new Economy(30);
        economy.addMember(new Member("Test Member", "30000"));

        assertEquals(21000, economy.getNetIncome());
    }

    @Test
    public void noTaxLowIncome() {
        Economy economy = new Economy(30);
        economy.addMember(new Member("Test Member", "20000"));

        assertEquals(20000, economy.getNetIncome());
    }
}
