package problemsolving;

import java.util.*;

public class StringsWithNoRepeat {

    public static List<String> stringsWithNoRepeat(String input) {

        int start = 0;
        String currentLongestString = "";
        List<String> output = new ArrayList<String>();

        Map<String, Integer> dic = new HashMap<>();

        while (start <= input.length() - 1) {
            var chr = input.substring(start , start + 1);
            if (!dic.containsKey(chr)) {
                currentLongestString = currentLongestString + chr;
                dic.put(chr , start);
                start += 1;
            }
            else {
                output.add(currentLongestString);
                start = dic.get(chr) + 1;
                currentLongestString = "";
                dic.clear();
            }
        }

        output.add(currentLongestString);

        return output;
    }
 }
