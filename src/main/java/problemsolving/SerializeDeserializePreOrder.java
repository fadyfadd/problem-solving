package problemsolving;
import problemsolving.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SerializeDeserializePreOrder {

    private static void _serialize(Node node, List<String> output) {

        if (node == null) {
            output.add("/");
            return;
        }


        output.add(node.data);
        _serialize(node.left, output);
        _serialize(node.right, output);
    }

    public static List<String> serialize(Node list) {
        List<String> output = new ArrayList<>();
        _serialize(list, output);
        return output;
    }

    private static Node _deserialize(List<String> list, int[] i) {
        if (Objects.equals(list.get(i[0]), "/")) {
            i[0]++;
            return null;
        }

        Node node = new Node(list.get(i[0]));
        i[0]++;

        node.left = _deserialize(list, i);
        node.right = _deserialize(list, i);

        return node;

    }

    public static Node deserialize(List<String> list) {
        int[] i = {0};
        return _deserialize(list, i);
    }

}
