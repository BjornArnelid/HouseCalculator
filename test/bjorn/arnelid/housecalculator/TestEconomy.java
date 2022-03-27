package bjorn.arnelid.housecalculator;

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
        User user1 = new User("User 1");
        user1.setPay(10000);
        User user2 = new User("User 2");
        user2.setPay(30000);
        economy.addUser(user1);
        economy.addUser(user2);
        return economy;
    }

    @Test
    public void getDisposableIncome() {
        Economy economy = getEconomy();
        assertEquals(10000, economy.getDisposableIncome());
    }
}
