package problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringsWithNoRepeatTest {

    @Test
    void stringsWithNoRepeat_1() {
        var values = StringsWithNoRepeat.stringsWithNoRepeat("going to the beach");
        Assertions.assertTrue(values.size() == 7);
    }

    @Test
    void stringsWithNoRepeat_2() {
        var values = StringsWithNoRepeat.stringsWithNoRepeat("");
        Assertions.assertTrue(values.size() == 1);
    }

}
