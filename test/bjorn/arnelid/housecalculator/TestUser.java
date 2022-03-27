package bjorn.arnelid.housecalculator;

import bjorn.arnelid.housecalculator.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestUser {
    @Test
    public void testUserName() {
        User user = new User("The Name");
        assertEquals(user.getName(), "The Name");
    }

    @Test
    public void testUserPay() {
        User user = new User("The Name");
        assertEquals(0, user.getPay());
        user.setPay(10000);
        assertEquals(10000, user.getPay());
    }
}
