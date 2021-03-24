
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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




public class Kruskals_algorithm implements UnionFind{

    
    
    Graph graph=new Graph(20);
    int set[]=new int[graph.getVertexList().length];
    private Map<Integer, Integer> parent = new HashMap();
  
    
    
        public Kruskals_algorithm(Graph graph,StringBuilder s) {
        this.graph=graph;
        Kruskals( s);
    }
	// perform MakeSet operation
	public void makeset(int Vertex)
	{
	parent.put(Vertex, Vertex);     
	}

	// Find the root of the set in which element k belongs
	public int Find(int Vertex)
	{
		// if k is root
		if (parent.get(Vertex) == Vertex)
			return Vertex;

		// recur for parent until we find root
		return Find(parent.get(Vertex));
	}

	// Perform Union of two subsets
	public void union(int Vertex1, int Vertex2)
	{
		// find root of the sets in which elements
		// x and y belongs
		int x = Find(Vertex1);
		int y = Find(Vertex2);

		parent.put(x, y);
	}
        
    
     public void Kruskals(StringBuilder s) {
         int size=graph.allEdge.size();
         double Total_weight=0;
        for (int i = 0; i < graph.getVertexList().length; i++) {
            makeset(i);
        }
        
           graph.allEdge.sort(Comparator.comparingInt(o ->(int)o.getWeigted()));
         
         
          ArrayList<Edge> mst = new ArrayList<>();
                  
         for (int i = 0; i < size; i++) {
             Edge edge = graph.allEdge.get(i);
               
                int x_set = Find( edge.getSource());
                int y_set = Find( edge.getTarget());

             if (x_set != y_set) {
                 Total_weight=Total_weight+edge.getWeigted();
                  mst.add(edge);
                    union(x_set,y_set);
             }
         }
        
            printGraph(mst,Total_weight,s);
        
    }
     public void printGraph(ArrayList<Edge> edgeList,double Total_weight,StringBuilder s){
         String s1=("\nTotal weight of MST by Kruskal's algorithm: "+(double)Total_weight+"\nThe edges in the tree are:\n");
         System.out.println(s1);
         s.append(s1+"\n");
            for (int i = 0; i <edgeList.size() ; i++) {
                Edge edge = edgeList.get(i);
                 s1="Edge from " + edge.getSource() +
                        " to " + edge.getTarget() +
                        " has weight " +(double) edge.getWeigted();
                s.append(s1+"\n");
                System.out.println(s1);
            }
        }

}
