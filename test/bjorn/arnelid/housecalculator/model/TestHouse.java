package bjorn.arnelid.housecalculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHouse {
    @Test
    public void getLeaseEmpty() {
        House house = new House();
        assertEquals(0, house.getLease());
    }

    @Test
    public void testGetLease() {
        House house = new House();
        house.setLease(5000);
        assertEquals(5000, house.getLease());
    }
}
