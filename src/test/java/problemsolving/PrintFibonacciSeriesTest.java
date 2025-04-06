package problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PrintFibonacciSeriesTest {

    @Test
    public void printFibonacciSeries_1() {
        var result = (Object[])(PrintFibonacciSeries.printFibonacciSeries(10L)).toArray();
       assertArrayEquals(new Object[] {1L , 1L , 2L , 3L , 5L , 8L , 13L , 21L , 34L , 55L} ,  result);
    }

}
