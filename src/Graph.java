//============================
// MEMBER 1 : 
// NAME : Ahmed ALmutairi
// ID : 1740898
//: Task 2 (Member 1 & 2): Implement Kruskal's algorithm with a Union and Find of edges (Weighted quick-union).
//Email:Ahmedfahad3x@gmail.com
//============================
// MEMBER 2 : 
// NAME : Omar Othman Labban
// ID : 1740639
//: Task 1 (Member 1 & 2): Implement Prim's algorithm with a min heap.
//Email:olabban0002@stu.kau.edu.sa
//============================
// MEMBER 3 : 
// NAME : Ahmed Hedaya
// ID : 1743728
//: Task 3 (Member 3): Compare the runnning time of Prim's algorithm vs. Kruskal's algorithm (union by size) + Junit test + generate Javadoc file after documentation of the the project.
//Task 4 (Member 3): Write one page of your observations for the running times of Prim's algorithm vs. Kruskal's algorithm.
//Email:Ahmedfahad3x@gmail.com
//============================


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Ahmed
 */
public class Graph //Class to implement graph
{

    private final int MAX_VERTS = 4040;
    private Vertex vertexList[];// Array of vertices as objects of class Vertex
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices
    private boolean connect=true;
    private Queue<Integer> queue = new LinkedList<>();
     ArrayList<Edge>allEdge  =new ArrayList();

    public ArrayList<Edge> getAllEdge() {
        return allEdge;
    }
    /**
     *
     * @return
     */
    public Vertex[] getVertexList() {
        return vertexList;
    }

    
    /**
     *
     * @return
     */
    public int[][] getAdjMat() {
          
        return adjMat;
    }

    /**
     *
     * @return
     */
    public String printpath(){
        StringBuilder output = new StringBuilder();
         for (int i = 0; i < nVerts; i++) {
            output.append(i+": ");
             for (int j = 0; j < nVerts; j++) {
                 if (adjMat[i][j]>0) {
                     output.append(i+"-"+j+" "+adjMat[i][j]+"  ");
                 }
             }
             output.append("\n");
    }
        return output.toString();
    }
// -----------------------------------------------------------

    /**
     *
     * @param NumberOfVertex
     */
    public Graph(int NumberOfVertex) // constructor
    {
        adjMat = new int[NumberOfVertex+1][NumberOfVertex+1];
        vertexList = new Vertex[NumberOfVertex];
    } // end constructor
// -----------------------------------------------------------

    /**
     *
     * @param lab
     */
    public void addVertex(char lab) {
        if (nVerts != MAX_VERTS) {
            vertexList[nVerts++] = new Vertex(lab);
        } else {
            System.out.println("You can't add Vertex ");
        }
//Write statement(s) here to add new vertex

    }
// -----------------------------------------------------------

    public void addEdge(int start, int end, int Weigted) {
        adjMat[start][end] = Weigted;
         allEdge.add(new  Edge( start , end, Weigted));
       adjMat[end][start] = Weigted;
//Write statement(s) here to add new edge for undirected graph
    }
// ------------------------------------------------------------

    public Vertex getVertex(int v) {
        return vertexList[v];
    }

    /**
     *
     * @return
     */
    public String displayVertices() {   // 
        String Adjacency = "Adjacent Vertices of every vertex:\n\n";
        for (int i = 0; i < vertexList.length && vertexList[i] != null; i++) {
            Adjacency = Adjacency + "VERTEX: " + i + " {" + vertexList[i].getLabel() + "}  - VISIT: " + vertexList[i].isWasVisited() + " - ADJACENCY:";

            for (int j = 0; j < vertexList.length; j++) {
                if (adjMat[i][j] >= 1) {
                    Adjacency = Adjacency + j + ",";
                }
            }
            Adjacency = Adjacency.substring(0, Adjacency.length() - 1);
            Adjacency = Adjacency + "\n";
        }
        return Adjacency;

    }

// ------------------------------------------------------------

    /**
     *
     * @return
     */
    public String displayGraph() {
        return displayGraph(adjMat);

    }

    private String displayGraph(int[][] adjmat) {

        StringBuilder output = new StringBuilder();
        output.append("Adjacency Matrix: \n\n");

        String str1 = "";
        output.append("  ");
        for (int i = 0; i < vertexList.length; i++) {
            str1 = String.format("%3d", i);//Display the first row "Labels"
            output.append(str1);
        }
        output.append("\n");

        for (int i = 0; i < vertexList.length; i++) {
            output.append(i); // Display the first column "Labels"

            for (int j = 0; j < vertexList.length; j++) {
                str1 = String.format("%3d", adjmat[i][j]);
                output.append(str1);
            }
            output.append("\n");
        }
        return output.toString();
    }

    /**
     *
     * @return
     */
    public String dfs() {
//        DFS();

        return DepthFirst();
    }

    private String DepthFirst() // Depth First search
    {
        StringBuilder s = new StringBuilder();
        s.append("\nDFS traversal: ");

        Stack stack = new Stack();
        
        
        vertexList[0].setWasVisited(true);
        stack.push(0);
        s.append(stack.peek()+" ");

        while (!stack.isEmpty()) {
            
            
            for (int i = 0; i < adjMat.length; i++) {
                
                for (int j = 0; j < adjMat.length; j++) {
                    
                    
                    if (!vertexList[j].isWasVisited()) {
                        if (adjMat[i][j] > 0) {
                            stack.push(j);
                            s.append(stack.peek()+" ");
                            vertexList[j].setWasVisited(true);
                            i = j;
                            j = -1;

                        }
                    }
                }
                
                    
                i = (int) stack.pop()-2;
                
                
                if(stack.isEmpty()){
                    i=connect();
                    if(i==-1)
                        break;
                    else{
                        stack.push(i);
                        vertexList[i].setWasVisited(true);
                        s.append(stack.peek()+" ");
                        i--;
                    }
                }
                
            }

        }

        return s.toString();
    }
    
    /**
     *
     * @return
     */
    public int connect(){
        for (int i = 0; i < vertexList.length; i++) {
            if (!vertexList[i].isWasVisited()) {
                connect = false;
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @return
     */
    public String BreadthFirst()
    {
        StringBuilder s = new StringBuilder();
        s.append("\nBFS traversal: ");
        // the next code to make all vertex unvisited becase i used dfs before
        for (Vertex vertexList1 : vertexList) {
            vertexList1.setWasVisited(false);
        }
        //vertex 0(a) as visited
        vertexList[0].setWasVisited(true);
        //Insert this vertex into the queue
        queue.add(0);
        //while queue is not empty, do the following
        while (!queue.isEmpty()) {
            //Inside this  for loop, write the statements to change the status 
            //'wasVisited" of these adjacent vertices to 'true', display these 
            //vertices and insert them into the queue
            for (int i = 0; i < adjMat[queue.peek()].length; i++) {
                if (adjMat[queue.peek()][i] > 0 && !vertexList[i].isWasVisited()) {
                    vertexList[i].setWasVisited(true);
                    queue.add(i);
                }
            }
            // print and remove from the queue
            s.append(queue.remove());
            if (!queue.isEmpty()) {
                s.append(",");
            }

            // check if the graph is connected or not.
            if (queue.isEmpty()) {
                // getAdjUnvisitedVertex() will return the index of unvisited vertex or -1
                int IndexForUnvisited = connect();
                if (IndexForUnvisited != -1) {
                    // if there is unvisited vertex puch it to the stack and make it visited and print it 
                    vertexList[IndexForUnvisited].setWasVisited(true);
                    s.append(",");
                    queue.add(IndexForUnvisited);
                }
            }
        }
        String S = s.toString();
        return S;
    }

    /**
     *
     * @return
     */
    public String connectivityOfGraph(){
        if(connect==true){
            return "\nGraph is connected.";
        }else{
            return "\nGraph is not connected.";
        }
    }

}// End of Graph class
