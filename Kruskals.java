import java.util.ArrayList;

public class Kruskals {

    public ArrayList<Integer> sortEdges(int matrix[][],int size){
        ArrayList<Integer> edges = new ArrayList<Integer>();
        for (int i = 0;i<size;i++){
            for (int j = 0;j<size;j++){
                if(matrix[i][j] != 0){
                    edges.add(matrix[i][j]);
                }
            }
        }
        edges.sort(null);
        return edges;
    }
    public void printEdges(ArrayList<Integer> edges){
        for( Integer edge : edges){
            System.out.print(edge + " ");
        }
    }

    public void printMST(int[] edges,Graph graph){
        System.out.println("Edge \tWeight");
        for(int i =0 ;i<edges.length;i++){
            if(edges[i]!=Integer.MAX_VALUE){
                System.out.println(i + "-->" + edges[i] +'\t'+ graph.matrix[i][edges[i]]);
            }
        }
    }
    public void algorithm(Graph graph){
        int size = graph.matrix.length;
        int[] disjointed = new int[size];
        for (int i=0;i<size;i++){
            disjointed[i] = Integer.MAX_VALUE;
        }

        ArrayList<Integer> sortedEdges = sortEdges(graph.matrix,size);
        for(Integer edge : sortedEdges){
            for (int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if(graph.matrix[i][j] == edge){
                        if(disjointed[i]==Integer.MAX_VALUE){
                            disjointed[i]=j;
                        }
                    }
                }
            }
        }
        System.out.println("Disjointed set :");
        for (Integer edge : disjointed){
            System.out.print(edge+ ", ");
        }
        System.out.println();
        printMST(disjointed,graph);
    }

}
