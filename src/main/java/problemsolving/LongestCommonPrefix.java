package problemsolving;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] data) {
        Arrays.sort(data);
        var firstValue = data[0];
        var lastValue = data[data.length - 1];
        String output = "";
        int i = 0;

        while (i < firstValue.length() && i < lastValue.length() && firstValue.substring(i , i+1).equals(lastValue.substring(i , i+1))) {
            output = output + firstValue.substring(i , i+1);
            i++;
        }

        return output;
    }
}
