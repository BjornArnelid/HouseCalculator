package bjorn.arnelid.housecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testUpdateUser() {
        User user = new User("A Name");
        User updatedUser = new User("Another Name");
        updatedUser.setPay(10000);
        user.update(updatedUser);
        assertEquals("Another Name", user.getName());
        assertEquals(10000, user.getPay());
    }
}
