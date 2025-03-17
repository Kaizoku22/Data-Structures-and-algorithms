public class PrimsAlgo {
    int minKey(int key[], Boolean visited[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < visited.length; v++)
            if (visited[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[parent[i]][i]);
    }
    public void algorithm(Graph graph){
        int size = graph.matrix.length;
        //initializing array for keeping minimum spanning tree
        int parent[] = new int[size];
        //initializing array for keeping track of visited vertices
        Boolean visited[] = new Boolean[size];
        //initializing array for keeping track of weights of edges to choose from
        int key[] = new int[size];
        //initializing all values for key to infinite and visited values to false
        for(int i=0;i<size;i++){
            key[i]= Integer.MAX_VALUE;
            visited[i] = false;
        }
        key[0]=0;
        parent[0]=-1;

        for (int count=0;count < size;count++){
            int u = minKey(key,visited);
            visited[u]=true;

            for (int v = 0;v<size;v++){
                if(graph.matrix[u][v] !=0 && visited[v] == false && graph.matrix[u][v] <key[v]){
                    parent[v] = u;
                    key[v]= graph.matrix[u][v];
                }
            }
        }

        printMST(parent, graph.matrix);
    }
}
