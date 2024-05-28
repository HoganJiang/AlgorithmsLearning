package chapter10.exercise;

import java.util.ArrayList;

public class Node {

    /**
     * id 表示节点的值
     * in 表示节点的直接入度
     * out 表示节点的直接出度
     * next 表示节点的直接指向的邻居
     * edge 表示节点的直接指出的边
     */
    public Integer id;
    public Integer in;
    public Integer out;
    public ArrayList<Node> next;
    public ArrayList<Edge> edge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public ArrayList<Node> getNext() {
        return next;
    }

    public void setNext(ArrayList<Node> next) {
        this.next = next;
    }

    public ArrayList<Edge> getEdge() {
        return edge;
    }

    public void setEdge(ArrayList<Edge> edge) {
        this.edge = edge;
    }

    public Node(Integer id){
        this.id = id;
        this.in = 0;
        this.out = 0;
        this.next = new ArrayList<>();
        this.edge = new ArrayList<>();
    }

}
