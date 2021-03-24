
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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

public class Prim {


    public Prim(StringBuilder output, Vertex vertexList[], int adjMat[][],ArrayList<Edge>allEdge) {
        prim_min_heap(adjMat, 0,vertexList.length , output,allEdge);

    }
   
    public static void prim_min_heap(int[][] adjMat, int sorceV, int numOfVert, StringBuilder s, ArrayList<Edge>allEdge) {
       
        int solSize = 0;
// create a new heap
        Heap hm = new Heap(numOfVert);
// crate array to save the path       
        Node solSet[] = new Node[numOfVert];
        //choose the source
        int ind = 0;
        hm.initPath = ind;

        //creating the tree
        for (int i = 0; i < numOfVert; i++) {
            if (i != ind) {
                hm.insert(Integer.MAX_VALUE);
            }
            if (i == ind) {
                hm.insert(0);
            }
        }
        while (!hm.isEmpty()) {
            Node u = hm.remove();
            //add the vertex to the solution set
            solSet[solSize++] = u;
            for (int i = 0; i < numOfVert; ++i) {
                if (adjMat[u.Oindex][i] != 0) {
                    int adjVert = adjMat[u.Oindex][i];
                    hm.relax(u, i, adjVert);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < numOfVert; ++i) {
            //if(solSet[i].neighbors!=null)
            sum += solSet[i].getKey();
        }
        s.append("\nTotal weight of MST by Prim's algorithm: " + (double) sum);
        
        s.append("\nThe edges in the tree are:\n");
        System.out.println(s);
        for (int i = 0; i < numOfVert; ++i) {
            if (solSet[i].neighbors != null) {
                String s1=("Edges from " + solSet[i].neighbors.Oindex + " to " + solSet[i].Oindex + " has weight: " + (double) solSet[i].getKey());
                s.append(s1+"\n");
                System.out.println(s1);
            }
        }
      
        //print mst
           // printMST(resultSet,numOfV);
        }
        
        
        
        

    }


