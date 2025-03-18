import java.util.ArrayList;

public class Main {
    public static void main(String[]args){
        Graph graph = new Graph(5);
        graph.addNode(new Node("A"));
        graph.addNode(new Node("B"));
        graph.addNode(new Node("C"));
        graph.addNode(new Node("D"));
        graph.addNode(new Node("E"));

        graph.addEdge(0,1,3);
        graph.addEdge(1,2,5);
        graph.addEdge(2,3,1);
        graph.addEdge(2,4,7);
        graph.addEdge(4,0,3);
        graph.addEdge(4,2,7);

        graph.print();
        PrimsAlgo primsAlgo = new PrimsAlgo();
        primsAlgo.algorithm(graph);

        Kruskals kruskals = new Kruskals();
        kruskals.algorithm(graph);
    }
}
