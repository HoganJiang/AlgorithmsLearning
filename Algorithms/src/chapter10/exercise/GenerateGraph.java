package chapter10.exercise;

public class GenerateGraph {

    public static Graph generateGraph(Integer[][] arr){
        Graph graph = new Graph();
        for(int i = 0; i < arr.length; i++){
            Integer weight = arr[i][0];
            Integer from = arr[i][1];
            Integer to = arr[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            fromNode.out++;
            fromNode.next.add(toNode);
            Edge edge = new Edge(weight,fromNode,toNode);
            fromNode.edge.add(edge);
            toNode.in++;
            graph.edges.add(edge);
        }
        return graph;
    }

}
