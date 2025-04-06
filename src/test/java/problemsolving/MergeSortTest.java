package problemsolving;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    @Test
    void MergeSort_1() {
        var sortedArray = MergeSort.mergeSort(new String[] {"11" , "20" , "30" , "100"});
        assertArrayEquals(new String[] {"100" , "11" , "20" , "30"} , sortedArray);
    }
}
