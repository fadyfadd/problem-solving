package problemsolving;

 import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCountTest {

    @Test
    void bitCount_1() {
        assertEquals(4 , (int)BitCount.bitCount(10));
    }

    @Test
    void bitCount_2() {
        assertEquals(6 , (int)BitCount.bitCount(50));
    }
}
