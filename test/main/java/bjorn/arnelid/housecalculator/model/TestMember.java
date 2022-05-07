package bjorn.arnelid.housecalculator.model;

import bjorn.arnelid.housecalculator.model.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMember {
    @Test
    public void testUserName() {
        Member user = new Member("The Name");
        assertEquals(user.getName(), "The Name");
    }

    @Test
    public void testUserPay() {
        Member user = new Member("The Name");
        assertEquals(0, user.getPay());
        user.setPay(10000);
        assertEquals(10000, user.getPay());
    }

    @Test
    public void testUpdateUser() {
        Member user = new Member("A Name");
        Member updatedUser = new Member("Another Name");
        updatedUser.setPay(10000);
        user.update(updatedUser);
        assertEquals("Another Name", user.getName());
        assertEquals(10000, user.getPay());
    }
}
