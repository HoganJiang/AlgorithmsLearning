package chapter10.exercise;

public class Edge {
    /**
     * Edge是一个有向边
     * weight: 表示边的权重
     * from: 指向自己的表
     * to: 指向的节点边
     */
    public Integer weight;
    public Node from;
    public Node to;

    public Edge(Integer weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
