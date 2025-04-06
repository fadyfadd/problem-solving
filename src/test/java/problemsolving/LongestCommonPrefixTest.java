package problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix_1() {
        String[] arr = { "floor", "flower",
                "flora", "fly" };
        var longuestCommonPrefix = LongestCommonPrefix.longestCommonPrefix((arr));
         assertEquals("fl" , longuestCommonPrefix);
    }

}
