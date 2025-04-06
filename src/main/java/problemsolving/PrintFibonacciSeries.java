package problemsolving;

import java.util.ArrayList;
import java.util.List;

public class PrintFibonacciSeries {

    public static List<Long> printFibonacciSeries(Long n) {

        List<Long> output = new ArrayList();

        if (n <= 0)
            throw new RuntimeException("should be positive");

        output.add(1L);

        if (n == 1)
            return output;

        output.add(1L);

        var n1 = 1;
        var n2 = 1;
        var sum = n1 + n2;

        for (int i = 1; i <= n - 2; i++) {
            output.add((long) sum);

            n1 = n2;
            n2 = sum;
            sum = n1 + n2;
        }

        return output;
    }

}
