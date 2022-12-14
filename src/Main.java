import java.util.*;

class Graph {
    private final int quantityNodes;

    /* Array of LinkedLists to store adjacent nodes */
    private final LinkedList<Integer>[] adjNodes;

    /* Graph constructor */
    Graph(int quantityNodes) {
        this.quantityNodes = quantityNodes;
        adjNodes = new LinkedList[quantityNodes];
        for (int i = 0; i < quantityNodes; ++i) {
            adjNodes[i] = new LinkedList<>();
        }
    }

    /* Function to add an edge into the graph */
    void addEdge(int sourceNode, int destinationNode) {
        /* Adds nodeOne to nodeTwo's list */
        adjNodes[sourceNode].add(destinationNode);
    }

    /* Utility function used by DFS */
    void DFSUtil(int sourceNode, boolean[] visited) {
        /* Mark current node visited and print it */
        visited[sourceNode] = true;
        System.out.print(sourceNode + " ");

        /* Recur for all the nodes adjacent to this node */
        for (int nextNodeID : adjNodes[sourceNode]) {
            //            System.out.println("nextNodeID: " + nextNodeID);
            /* If next node is not visited, call DFSUtil with new parameters */
            if (!visited[nextNodeID]) {
                DFSUtil(nextNodeID, visited);
            }
        }
    }

    /* Recursive DFS function, uses DFSUtil() */
    void DFS(int sourceNode) {
        /* Mark all vertices unvisited */
        boolean visited[] = new boolean[quantityNodes];

        /* Recursive helper, prints DFS */
        DFSUtil(sourceNode, visited);
    }

    /* Driver */
    public static void main(String args[]) {
        Graph g = new Graph(15);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 6);
        g.addEdge(2, 7);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 4);
        g.addEdge(5, 8);
        g.addEdge(5, 9);
        g.addEdge(5, 10);
        g.addEdge(6, 7);
        g.addEdge(6, 11);
        g.addEdge(6, 12);
        g.addEdge(7, 1);
        g.addEdge(7, 11);
        g.addEdge(8, 10);
        g.addEdge(9, 10);
        g.addEdge(9, 13);
        g.addEdge(10, 14);
        g.addEdge(11, 12);
        g.addEdge(12, 13);
        g.addEdge(13, 5);
        g.addEdge(13, 6);
        g.addEdge(14, 3);

        int sourceNode = 0;

        System.out.println("Calling DFS, source node: " + sourceNode);
        g.DFS(sourceNode);
    }
}