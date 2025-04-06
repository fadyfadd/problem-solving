package problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problemsolving.common.Utilities;

public class MultiplyMatrixTest {

    @Test
    public void multiplyMatrix_1() {

        long[][] m1 = {{1,2,3} , {4,5,8}};
        long[][] m2 = {{2 , 1} , {2,8} , {2,7}};

        var result = MultiplyMatrix.multiplyMatrix(m1 , m2);

        Assertions.assertEquals( 12L , result[0][0]);
        Assertions.assertEquals( 38L , result[0][1]);
        Assertions.assertEquals( 34L , result[1][0]);
        Assertions.assertEquals( 100L , result[1][1]);

    }

}
