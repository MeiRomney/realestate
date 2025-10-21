package realestate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RealEstateTest {

    private RealEstate r1;
    private RealEstate r2;

    @BeforeEach
    void setUp() {
        r1 = new RealEstate("Budapest", 2000, 50, 2, Genre.FAMILYHOUSE);
        r2 = new RealEstate("Debrecen", 1500, 40, 1.5, Genre.CONDOMINIUM);
    }

    @Test
    void testMakeDiscount() {
        r1.makeDiscount(10); // 10% discount
        assertEquals(1800, r1.getPrice(), 0.01);
    }

    @Test
    void testGetTotalPrice() {
        // Budapest multiplier 1.30
        int expectedR1 = (int)(r1.getPrice() * r1.getSqm() * 1.30);
        assertEquals(expectedR1, r1.getTotalPrice());

        // Debrecen multiplier 1.20
        int expectedR2 = (int)(r2.getPrice() * r2.getSqm() * 1.20);
        assertEquals(expectedR2, r2.getTotalPrice());
    }

    @Test
    void testAverageSqmPerRoom() {
        assertEquals(25.0, r1.averageSqmPerRoom(), 0.01);
        assertEquals(26.6667, r2.averageSqmPerRoom(), 0.01);
    }

    @Test
    void testCompareTo() {
        assertTrue(r1.compareTo(r2) > 0); // r1.price > r2.price
        assertTrue(r2.compareTo(r1) < 0);
        RealEstate r3 = new RealEstate("Szeged", 2000, 55, 3, Genre.FAMILYHOUSE);
        assertEquals(0, r1.compareTo(r3)); // same price
    }

    @Test
    void testToStringContainsAllFields() {
        String s = r1.toString();
        assertTrue(s.contains("Budapest"));
        assertTrue(s.contains("2000"));
        assertTrue(s.contains("50"));
        assertTrue(s.contains("2"));
        assertTrue(s.contains("FAMILYHOUSE"));
    }
}
