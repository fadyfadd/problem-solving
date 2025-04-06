package problemsolving;
import problemsolving.common.Node;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {

    private static void _findAllPaths(List<Node> currentPath, List<List<Node>> paths, Node currentNode) {

        if (currentNode == null) {
            return;
        }

        currentPath.add(currentNode);

        if (currentNode.left == null && currentNode.right == null) {
            paths.add(new ArrayList<Node>(currentPath));
        } else {
            _findAllPaths(currentPath, paths, currentNode.left);
            _findAllPaths(currentPath, paths, currentNode.right);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static List<List<Node>> findAllPaths(Node head) {
        List<List<Node>> paths = new ArrayList<>();
        List<Node> currentPath = new ArrayList<>();
        _findAllPaths(currentPath, paths, head);
        return paths;
    }

}
