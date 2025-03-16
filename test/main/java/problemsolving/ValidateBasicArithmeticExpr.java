package problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateBasicArithmeticExpr {

    final static Map<String,String> pairs = new HashMap<>();

    public static Boolean nonValidEntry(String value) {
        if (isOperator(value) || isClosingSymbol(value) || isOpeningSymbol(value) || isNumeric(value))
            return true;

        return false;
    }

    public static Boolean isOperator(String value) {

        if (value.equals("+") || value.equals("-") || value.equals("/") || value.equals("*"))
            return true;

        return false;
    }

    public static Boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        }
        catch (Throwable ex) {
            return false;
        }

    }

    public static Boolean isClosingSymbol(String value) {
        if (value.equals(")") || value.equals("}") || value.equals("]"))
            return true;

        return false;
    }

    public static Boolean isOpeningSymbol(String value) {
        if (value.equals("(") || value.equals("{") || value.equals("["))
            return true;

        return false;
    }

    public static  Boolean validateBasicArithmeticExpr(String[] value) {

        if (value.length == 0)
            return false;

        if (isOperator(value[value.length -1]))
            return false;

        var stack = new ArrayList<String>();

        for (int i = 0 ; i <= value.length - 1; i++) {
            if (value[i].equals("(") || value[i].equals("[") || value[i].equals("{")) {
                stack.add(value[i]);
            }

            if (value[i].equals(")") || value[i].equals("]") || value[i].equals("}")) {
               var closingPair = pairs.get(value[i]);
               if (stack.isEmpty()) {
                   return false;
               }
               var vl = stack.get(stack.size() - 1);
               if (!vl.equals(closingPair)) {
                  return false;
               }

            }
        }
        if (!stack.isEmpty())
            return false;

        for (int i = 0 ; i <= value.length - 1; i++) {

            if (nonValidEntry(value[i]))
                return false;

            if (i == 0) {
                if (!isNumeric(value[i]) && !value[i].equals("+") && value[i].equals("-"))
                        return false;
            }
            else {
               if (isOpeningSymbol(value[i])) {
                   if (isNumeric(value[i - 1]))
                       return false;

                   if (isClosingSymbol(value[i - 1]))
                       return false;
               }

                if (isClosingSymbol(value[i])) {
                    if (isOperator(value[i - 1]))
                        return false;

                    if (isOpeningSymbol(value[i - 1]))
                        return false;
                }

                if (isNumeric(value[i])) {
                    if (isClosingSymbol(value[i - 1]))
                        return false;

                    if (isNumeric(value[i - 1]))
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String... args) {
        pairs.put("(" , ")");
        pairs.put("{" , "}");
        pairs.put("[" , "]");

        List<String> stk = new ArrayList<>();
        System.out.println("1+10" + " " + validateBasicArithmeticExpr(new String[] {"1" , "+" , "10"}).toString());
    }

}
