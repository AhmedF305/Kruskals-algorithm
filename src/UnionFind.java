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

public interface UnionFind {

    public void makeset(int v);
    public int Find(int v);
    public void union(int  x,int  y);
}
