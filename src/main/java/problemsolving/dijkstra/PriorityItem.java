package problemsolving.dijkstra;

class PriorityItem {
    String item;
    Long weight;

    public PriorityItem(String item, Long weight) {
        this.item = item;
        this.weight = weight;
    }
}