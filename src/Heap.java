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


public class Heap {

    private Node[] heapArray;
    private int maxSize; // size of array
    private int currentSize;
    public int initPath;
// -----------------------------------------------------------
// constructor

    public Heap(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];  // create array
    }
// -----------------------------------------------------------

    public boolean insert(int key) {

        if (currentSize == maxSize) // if array is full,
        {
            return false; // failure
        }

        Node newNode = new Node(key, currentSize, currentSize); // make a new node
        if (currentSize == initPath) {
            newNode.path = initPath + " ";
        }

        heapArray[currentSize] = newNode; // put it at the end
        trickleUp(currentSize++); // trickle it up
        return true; // success

    } // end insert()
// -----------------------------------------------------------

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey() > bottom.getKey()) {

            heapArray[index] = heapArray[parent]; // move node down

            //change the parent's index
            heapArray[parent].index = index;

            index = parent; // move index up
            parent = (parent - 1) / 2; // parent <- its parent
        } // end while
        heapArray[index] = bottom;
        //change the new node's index
        heapArray[index].index = index;
    } // end trickleUp()
// -----------------------------------------------------------
// delete item with min key

    public Node remove() { // (assumes non-empty list)
        Node root = heapArray[0]; // save the root
        heapArray[0] = heapArray[--currentSize]; // root <- last
        trickleDown(0); // trickle down the root
        return root; // return removed node
    } // end remove()
// -----------------------------------------------------------

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index]; // save root
        while (index < currentSize / 2) // while node has at
        { // least one child,
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
// find larger child

            if (rightChild < currentSize && heapArray[leftChild].getKey() > heapArray[rightChild].getKey()) // (rightChild exists?)
            {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
// top >= largerChild?
            if (top.getKey() <= heapArray[largerChild].getKey()) {
                break;
            }
// shift child up
            heapArray[index] = heapArray[largerChild];
            heapArray[index].index = index;
            index = largerChild; // go down
        } // end while
        heapArray[index] = top; // index <- root
        heapArray[index].index = index;
    } // end trickleDown()
// -----------------------------------------------------------

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey(); // remember old
        heapArray[index].setKey(newValue); // change to new
        if (oldValue > newValue) // if raised,
        {
            trickleUp(index); // trickle it up
        } else // if lowered,
        {
            trickleDown(index); // trickle it down
        }
        return true;
    } // end change()
// -----------------------------------------------------------

    public int searchIndex(int Oindex2) {
        for (int i = 0; i < currentSize; ++i) {
            if (heapArray[i].Oindex == Oindex2) {
                return heapArray[i].index;
            }
        }
        return -1;
    }
// -----------------------------------------------------------

    public void relax(Node u, int i, int weight) {
        int ind = searchIndex(i);

        if (ind == -1) {
            return;
        }
        if (ind != -1 && heapArray[ind].getKey() > weight) {
            this.change(ind, weight);
            ind = searchIndex(i);
            if (heapArray[ind].neighbors != null && weight < heapArray[ind].neighbors.getKey()) {
                heapArray[ind].neighbors = u;
            } else {
                heapArray[ind].neighbors = u;
            }
        }
    }
// -----------------------------------------------------------

    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        } else {
            return false;
        }
    }
// -----------------------------------------------------------
}
