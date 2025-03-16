package problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ValidateBasicArithmeticExpr {

    public static Boolean isNonValidEntry(String value) {
        if (isOperator(value) || isClosingSymbol(value) || isOpeningSymbol(value) || isNumeric(value))
            return false;

        return true;
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
        } catch (Throwable ex) {
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

    public static Boolean validateBasicArithmeticExpr(String input) {
        String[] value = splitExpression(input);

        Map<String, String> pairs = new HashMap<>();
        pairs.put(")", "(");
        pairs.put("}", "{");
        pairs.put("]", "[");

        if (value.length == 0)
            return false;

        if (isOperator(value[value.length - 1]))
            return false;

        var stack = new ArrayList<String>();

        for (int i = 0; i <= value.length - 1; i++) {
            if (value[i].equals("(") || value[i].equals("[") || value[i].equals("{")) {
                stack.add(value[i]);
            }

            if (value[i].equals(")") || value[i].equals("]") || value[i].equals("}")) {
                var openingPair = pairs.get(value[i]);
                if (stack.isEmpty()) {
                    return false;
                }
                var vl = stack.get(stack.size() - 1);
                stack.remove(vl);
                if (!vl.equals(openingPair)) {
                    return false;
                }

            }
        }
        if (!stack.isEmpty())
            return false;

        for (int i = 0; i <= value.length - 1; i++) {

            if (isNonValidEntry(value[i]))
                return false;

            if (i == 0) {
                if (!isNumeric(value[i]) && !value[i].equals("+") && value[i].equals("-") && !isOpeningSymbol(value[i]))
                    return false;
            } else {
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

                if (isOperator(value[i])) {
                    if (isOperator(value[i - 1]))
                        return false;
                }
            }
        }

        return true;
    }

    public static String[] splitExpression(String expression) {

        List<String> lst = new ArrayList<>();
        String currentNumeric = "";
        String currentNonNumeric = "";

        for (int i = 0; i <= expression.length() - 1; i++) {
            var ch = expression.substring(i, i + 1);

            if (isNumeric(ch)) {
                currentNumeric += ch;
                if (!currentNonNumeric.equals("")) {
                   lst.add(currentNonNumeric);
                }
                currentNonNumeric = "";
            }
            else if (
                    isOpeningSymbol(ch)
                    || isClosingSymbol(ch)
                    || isOperator(ch)) {
                if (!currentNumeric.equals("")) {
                    lst.add(currentNumeric);
                }
                if (!currentNonNumeric.equals("")) {
                    lst.add(currentNonNumeric);
                }
                currentNonNumeric = "";
                currentNumeric = "";
                lst.add(ch);
            }
            else  {
                currentNonNumeric += ch;
                if (!currentNumeric.equals("")) {
                    lst.add(currentNumeric);
                }
                currentNumeric = "";
            }
        }

        if (isNumeric(currentNumeric)) {
            lst.add(currentNumeric);
        }

        String[] res = new String[lst.size()];
        for (int i = 0; i <= lst.size() - 1; i++) {
            res[i] = lst.get(i);
        }

        return res;
    }

}
