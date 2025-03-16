package problemsolving.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class DijkstraQueue {
    private List<PriorityItem> nodes = new ArrayList<PriorityItem>();

    public boolean contains() {
        return nodes.size() > 0;
    }

    public void put(PriorityItem item) {

        nodes.add(item);
        nodes.sort(new Comparator<PriorityItem>() {
            @Override
            public int compare(PriorityItem o1, PriorityItem o2) {

                if (o1.weight > o2.weight)
                    return 1;
                else if (o1.weight == o2.weight)
                    return 0;

                return -1;
            }
        });

    }

    public PriorityItem getPriorityNode() {

        var node =  nodes.get(0);
        nodes.remove(0);
        return node;

    }
}