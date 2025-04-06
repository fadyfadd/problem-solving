package problemsolving;

import java.util.Arrays;

public class MergeSort {

    public static String[] merge(String[] arr1, String[] arr2) {
        
        int i = 0;
        int j = 0;
        int k = 0;

        var result = new String[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) > 0) {
                result[k] = arr2[j];
                j++;
                k++;
            } else {
                result[k] = arr1[i];
                i++;
                k++;
            }
        }
        while (i < arr1.length) {

            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {

            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static String[] mergeSort(String[] arr) {

        if (arr.length <= 1)
            return arr;

        var mid = (int) Math.floor(arr.length / 2);
        var l = Arrays.stream(arr, 0, mid).toArray(String[]::new);
        var left = mergeSort(l);
        var r = Arrays.stream(arr, mid, arr.length).toArray(String[]::new);
        var right = mergeSort(r);
        return merge(left , right);
        
    }

}

 


