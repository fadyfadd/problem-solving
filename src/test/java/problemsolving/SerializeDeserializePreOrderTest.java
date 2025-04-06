package problemsolving;

import org.junit.jupiter.api.Test;
import problemsolving.common.Node;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializeDeserializePreOrderTest {

    @Test
    void serialize_1() {
        Node root = new Node("10");
        root.left = new Node("20");
        root.right = new Node("30");
        root.left.left = new Node("40");
        root.left.right = new Node("60");

        var nodeList = SerializeDeserializePreOrder.serialize(root);
        var res = nodeList.stream().collect(Collectors.joining(","));
        assertEquals("10,20,40,/,/,60,/,/,30,/,/" , res);

    }

    @Test
    void deserialize_1() {
        String input = "10,20,40,/,/,60,/,/,30,/,/";
        var list = Arrays.stream(input.split(",")).toList();
        var output = SerializeDeserializePreOrder.deserialize(list);
        var stringifiesOutput = SerializeDeserializePreOrder.serialize(output).stream().collect(Collectors.joining(","));
         assertEquals(stringifiesOutput , input);

    }

}
