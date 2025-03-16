package problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateBasicArithmeticExprTest {

    @Test
    void splitExpression() {
        var result = ValidateBasicArithmeticExpr.splitExpression("(1+10+aaaa+[]+ccccc/3");
        var expected =   new String[] {"(" , "1" , "+" , "10" , "+" , "aaaa" , "+" , "[" , "]" , "+" ,  "ccccc" , "/" , "3"};
        Assertions.assertArrayEquals(result , expected );

    }

    @Test
    void validateBasicArithmeticExpr() {
       Assertions.assertTrue(ValidateBasicArithmeticExpr.validateBasicArithmeticExpr(("{1+10/(5+8)}")));
    }
}
