package problemsolving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problemsolving.common.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllTreePathsTest {

    @Test
    void findAllPaths() {

        Node root = new Node("10");
        root.left = new Node("8");
        root.right = new Node("2");
        root.left.left = new Node("3");
        root.left.right = new Node("5");
        root.right.left = new Node("2");

        var output = FindAllTreePaths.findAllPaths(root);

        assertEquals( output.get(0).get(0).data , "10");
        assertEquals( output.get(0).get(1).data , "8");
        assertEquals( output.get(0).get(2).data , "3");

        assertEquals( output.get(1).get(0).data , "10");
        assertEquals( output.get(1).get(1).data , "8");
        assertEquals( output.get(1).get(2).data , "5");

        assertEquals( output.get(2).get(0).data , "10");
        assertEquals( output.get(2).get(1).data , "2");
        assertEquals( output.get(2).get(2).data , "2");

    }

}
