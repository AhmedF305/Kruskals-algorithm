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


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;


public class AddGraph //Main Class
{
      
      
    
    public static void main(String[] args) throws FileNotFoundException {
       
        
        File IFile = new File("input.txt");//we made object 
        if (!IFile.exists()) {
            System.out.println("The file dosen't exists");
        }
        //ReadForIF = Read For input file
        Scanner input = new Scanner(IFile);
        
        // print the output in file output.txt
        File OFile = new File("output.txt");
        PrintWriter Output = new PrintWriter(OFile);
        StringBuilder  s=new StringBuilder();
         
        //Read number of vertex from file 
        int NumberOfVertex = input.nextInt();
        //Read number of edges from file 
        int NumberOfEdges = input.nextInt();
        // Create new graph object 
        Graph graph = new Graph(NumberOfVertex);
        char lab = 'a';
        for (int i = 0; i < NumberOfVertex; i++) {
             //generate random character
            graph.addVertex(lab++);// add the Vertex in to the graph
            graph.getVertex(i).setWasVisited(false);
        }
        // ---------------------------------------------
        for (int i = 0; i < NumberOfEdges; i++) {
            int source = input.nextInt();
            int target = input.nextInt();
            // check if the graph is weighted or not
            
                // if it is weighted read the weight from the file 
                int Weigted = input.nextInt();
                graph.addEdge(source, target, Weigted);
        }
         //Prim_algorithm
        long startTime = System.nanoTime();
        Prim  p=new Prim(s,graph.getVertexList(),graph.getAdjMat(),graph.getAllEdge());
        long endTime = System.nanoTime();
        long TotalTime_for_prim_algorithm=(endTime - startTime);
        String s1=("\nRunning Time of Prim’s algorithm using Min-Heap as Min-Priority Queue is "+TotalTime_for_prim_algorithm+"\nNano seconds.\n");
         s.append(s1+"\n");
        System.out.println(s1);
      
        //Kruskals_algorithm
        
           startTime = System.nanoTime();
       Kruskals_algorithm k =new Kruskals_algorithm(graph,s);
          endTime = System.nanoTime();
          long TotalTime_for_Kruskals_algorithm=(endTime - startTime);
         s1=("\nRunning Time of Kruskal’s algorithm using Union-Find approach is "+TotalTime_for_Kruskals_algorithm+"\nNano seconds.");
         s.append(s1+"\n");
        System.out.println(s1);
         Output.append(s);
        Output.close();
        

            

    } // end main()

} // end class AddGraph
