import java.io.*;
import java.util.*;

/**
 * Adjacency list implementation for the AssociationGraph interface.
 *
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2019.
 */
public class AdjList extends AbstractAssocGraph
{

	// Initialise the variables
	private Map<String, Integer> indexMap = new HashMap<>();  // Label to index
	private Map<Integer, String> reverseMap = new HashMap<>(); // Index to label
	private MyPair[][] adjList;
	private int m = 20;
	private int n = 20;
	private static int vertices = 0;
	
    /**
	 * Contructs empty graph.
	 */
    public AdjList() {
    	 // Implement me!
    	this.adjList = new MyPair[m][];

    } // end of AdjList()
    

    public static void main(String[] args) {
    	
    	// Create the adjacency list
    	AdjList myAdjList = new AdjList();
    	
    	//AdjList.test1(myAdjList);
    	
    	AdjList.test2(myAdjList);
    	
    }
    
    
    public static void test1(AdjList myAdjList) {
    	
    	// Create the print writer
    	PrintWriter os = new PrintWriter(System.out);
    	
    	// Add vertices
    	myAdjList.addVertex("A");
    	myAdjList.addVertex("B");
    	myAdjList.addVertex("C");
    	myAdjList.addVertex("D");
    	myAdjList.addVertex("E");
    	myAdjList.addVertex("F");
    	myAdjList.addVertex("G");
    	myAdjList.addVertex("H");
    	
    	// Print the adjacency list vertices
//    	System.out.println("The vertices are ...");
//    	myAdjList.printVertices(os);
    	
    	// Add the edges
    	myAdjList.addEdge("A", "B", 1);
    	myAdjList.addEdge("B", "C", 2);
    	myAdjList.addEdge("D", "B", 3);
    	myAdjList.addEdge("D", "A", 8);
    	myAdjList.addEdge("C", "E", 5);
    	myAdjList.addEdge("E", "F", 6);
    	myAdjList.addEdge("C", "G", 7);
    	myAdjList.addEdge("G", "E", 7);
    	myAdjList.addEdge("G", "H", 4);
    	
    	// Print the number of vertices
    	System.out.println("\nThe number of vertices is: " + myAdjList.getVertices());
  	
    	// Print the adjacency list edges
    	System.out.println("\nThe edges are ...");
    	myAdjList.printEdges(os);
    	
    	// Get edge weights
    	System.out.println("Getting the edge weights...");
    	System.out.println(myAdjList.getEdgeWeight("A", "B"));
    	System.out.println(myAdjList.getEdgeWeight("D", "A"));
    	

    	// Update the edge weight
    	System.out.println("\nUpdating edge weights...");
    	myAdjList.updateWeightEdge("G", "H", 5);
    	myAdjList.updateWeightEdge("A", "B", 10);
    	myAdjList.updateWeightEdge("D", "B", 9);
    	myAdjList.updateWeightEdge("J", "K", 9);
    	myAdjList.updateWeightEdge("A", "K", 9);
    	
    	// Print the adjacency list edges
    	System.out.println("\nThe edges are ...");
    	myAdjList.printEdges(os);
   	
    	// Get the n nearest out neighbours
    	System.out.println("Getting out nearest neighbours...");
    	List<MyPair> neighboursOut = myAdjList.outNearestNeighbours(-1, "B");
    	myAdjList.printNeighbours("B", neighboursOut);
    	
    	// Get the n nearest in neighbours
    	System.out.println("Getting in nearest neighbours...");
    	List<MyPair> neighboursIn = myAdjList.inNearestNeighbours(-1, "F");
    	myAdjList.printNeighbours("F", neighboursIn);
    	
    	// Get the n nearest in neighbours
    	System.out.println("Getting in nearest neighbours...");
    	List<MyPair> neighboursIn2 = myAdjList.inNearestNeighbours(2, "B");
    	myAdjList.printNeighbours("B", neighboursIn2);
    	
    	// Get the n nearest out neighbours
    	System.out.println("Getting out nearest neighbours...");
    	neighboursOut = myAdjList.outNearestNeighbours(-1, "C");
    	myAdjList.printNeighbours("C", neighboursOut);
   	
    	// Get the n nearest out neighbours
    	System.out.println("Getting out nearest neighbours...");
    	neighboursOut = myAdjList.outNearestNeighbours(1, "C");
    	myAdjList.printNeighbours("C", neighboursOut);
    	
    	// Remove vertex
    	System.out.println("Removing vertices...");
    	myAdjList.removeVertex("J");
    	myAdjList.removeVertex("A");
    	
    	// Print the adjacency list edges
    	System.out.println("\nThe edges are ...");
    	myAdjList.printEdges(os);
  	
    	// Update the edge weight
    	System.out.println("Updating edge weights...");
    	myAdjList.updateWeightEdge("B", "C", 0);
    	myAdjList.updateWeightEdge("E", "F", 0);
    	myAdjList.updateWeightEdge("F", "E", 0);

    	// Adding a vertex
    	System.out.println("Adding vertex...");
    	myAdjList.addVertex("J");
    	
    	// Print the adjacency list edges
    	System.out.println("\nThe vertices are ...");
    	myAdjList.printVertices(os);
    	System.out.println("\nThe edges are ...");
    	myAdjList.printEdges(os);

    }
    
    
    public static void test2(AdjList myAdjList) {
    	
    	// Add vertices
    	myAdjList.addVertex("A");
    	myAdjList.addVertex("B");
    	myAdjList.addVertex("C");
    	myAdjList.addVertex("D");
    	myAdjList.addVertex("E");
    	myAdjList.addVertex("F");
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Add the edges
    	myAdjList.addEdge("A", "B", 1);
    	myAdjList.addEdge("C", "B", 1);
    	myAdjList.addEdge("B", "D", 1);
    	myAdjList.addEdge("A", "E", 3);
    	myAdjList.addEdge("D", "C", 5);
    	myAdjList.addEdge("F", "A", 2);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Get the n nearest out neighbours
    	System.out.println("Getting out nearest neighbours...");
    	List<MyPair> neighboursOut = myAdjList.outNearestNeighbours(-1, "A");
    	myAdjList.printNeighbours("A", neighboursOut);
    	
    	// Get the n nearest in neighbours
    	System.out.println("Getting in nearest neighbours...");
    	List<MyPair> neighboursIn = myAdjList.inNearestNeighbours(-1, "F");
    	myAdjList.printNeighbours("F", neighboursIn);

    	// Get edge weights
    	System.out.println("Getting the edge weights...");
    	System.out.println(myAdjList.getEdgeWeight("C", "B"));
    	System.out.println(myAdjList.getEdgeWeight("B", "C"));
    	System.out.println(myAdjList.getEdgeWeight("A", "E"));
    	
    	// Update the edge weight
    	System.out.println("Updating edge weights...");
    	myAdjList.updateWeightEdge("C", "B", 4);
    	myAdjList.updateWeightEdge("A", "B", 0);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Remove vertex
    	System.out.println("Removing vertices...");
    	myAdjList.removeVertex("D");
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());


    	// Adding a vertex
    	System.out.println("Adding vertex...");
    	myAdjList.addVertex("G");

    	// Create the print writer
    	PrintWriter os = new PrintWriter(System.out);
    	
    	// Print the incidence matrix vertices
    	System.out.println("Getting the vertices...");
    	myAdjList.printVertices(os);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());

    	// Print the incidence matrix edges
    	System.out.println("The edges are ...");
    	myAdjList.printEdges(os);

    }
    

    public void addVertex(String vertLabel) {
        // Implement me!
    	
    	// Check if the vertex is a duplicate
    	if (checkDuplicate(vertLabel)) {
    		return;
    	}
    	
    	MyPair[] edges = new MyPair[n];
    	
    	adjList[vertices] = edges;
    	indexMap.put(vertLabel, vertices);
    	reverseMap.put(vertices, vertLabel);
    	vertices++;
    	
    	// Check if the adjacency list needs to be resized
    	if (vertices == m) {
    		resizeAdjList(10);
    	}
    	
    } // end of addVertex()


    public void addEdge(String srcLabel, String tarLabel, int weight) {
        // Implement me!
    	
    	int intSrc = indexMap.get(srcLabel);
    	
    	MyPair[] edges = adjList[intSrc];
    	
    	for (int i = 0; i < edges.length; i++) {
    		if (edges[i] == null) {
    			edges[i] = new MyPair(tarLabel, weight);
    			break;
    		}
    	}
    	
    	//printEdges(intSrc);
    	
    } // end of addEdge()


    public int getEdgeWeight(String srcLabel, String tarLabel) {
    	// Implement me!
    	
    	int vertex = indexMap.get(srcLabel);
    	
    	MyPair[] edges = adjList[vertex];
    	
    	// Loop through the edges
    	for (int edge = 0; edge < edges.length; edge++) {
    		if (edges[edge] != null) {
    			MyPair myPair = edges[edge];
    			if (myPair.getKey().equals(tarLabel)) {
    				return myPair.getValue();
    			}
    		}
    	}

    	// update return value
		return EDGE_NOT_EXIST;
    } // end of existEdge()


    public void updateWeightEdge(String srcLabel, String tarLabel, int weight) {
        // Implement me!
    	
    	// Initialise variables
    	int vertex = 0;
    	
    	if (indexMap.containsKey(srcLabel)) {
    		vertex = indexMap.get(srcLabel);
    	} else {
    		System.out.printf("\nThe source label %1s does not exist!", srcLabel);
    		return;
    	}
    	
    	MyPair[] edges = adjList[vertex];
    	
    	// Loop through the edges
    	for (int edge = 0; edge < edges.length; edge++) {
    		if (edges[edge] != null) {
    			MyPair myPair = edges[edge];
    			if (myPair.getKey().equals(tarLabel)) {
    				myPair = new MyPair(tarLabel, weight);
    				edges[edge] = myPair;
    				//System.out.println("Found the edge to update!");
    				return;
    			}
    		}
    	}
    	System.out.printf("\nThe target label %1s was not found!", tarLabel);
    	
    } // end of updateWeightEdge()


    public void removeVertex(String vertLabel) {
        // Implement me!
    	
    	// Initialise variables
    	int vertex = 0;
    	
    	if (indexMap.containsKey(vertLabel)) {
    		vertex = indexMap.get(vertLabel);
    	} else {
    		System.out.printf("\nThe vertex label %1s does not exist!", vertLabel);
    		return;
    	}
    	
    	adjList[vertex] = null;
    	indexMap.remove(vertLabel);
    	
    	// Loop through the other vertices and remove reference to deleted vertex
    	for (int v = 0; v < vertices; v++) {
    		MyPair[] edges = adjList[v];
    		if (edges != null) {
    			for (int edge = 0; edge < edges.length; edge++) {
    				if (edges[edge] != null) {
    					MyPair myPair = edges[edge];
    					if (myPair.getKey().equals(vertLabel)) {
    						edges[edge] = null;
    					}
    				}
    			}
    		}
    	}
    } // end of removeVertex()


    public List<MyPair> inNearestNeighbours(int k, String vertLabel) {
        List<MyPair> neighbours = new ArrayList<MyPair>();

        // Implement me!
        
    	int vertex = 0;
    	
    	if (indexMap.containsKey(vertLabel)) {
    		vertex = indexMap.get(vertLabel);
    	} else {
    		System.out.printf("\nThe vertex label %1s does not exist!", vertLabel);
    		return neighbours;
    	}
    	
    	// Loop over the vertices
    	for (int v = 0; v < vertices; v++) {
    		if (v != vertex) {
    			MyPair[] edges = adjList[v];
    			// Loop over the vertices
    			for (int edge = 0; edge < edges.length; edge++) {
    				if (edges[edge] != null) {
    					MyPair myPair = edges[edge];
    					if (myPair.getKey().equals(vertLabel)) {
    						MyPair tempMyPair = new MyPair(reverseMap.get(v), myPair.getValue());
    						neighbours.add(tempMyPair);
    					}
    					
    				}
    			}
    		}
    	}
    	
    	
       	// Sort the neighbours
       	neighbours = sortNeighbours(neighbours);
       	
       	// Sub list the list
       	if (k > 0 && k <= neighbours.size()) {
       		//System.out.println("k is: " + k + " size is: " + neighbours.size());
       		neighbours = neighbours.subList(0, k);
       	}

        
        return neighbours;
    } // end of inNearestNeighbours()


    public List<MyPair> outNearestNeighbours(int k, String vertLabel) {
        List<MyPair> neighbours = new ArrayList<MyPair>();
        
        // Implement me!
        
    	int vertex = 0;
    	
    	if (indexMap.containsKey(vertLabel)) {
    		vertex = indexMap.get(vertLabel);
    	} else {
    		System.out.printf("\nThe vertex label %1s does not exist!", vertLabel);
    		return neighbours;
    	}
    	
    	MyPair[] edges = adjList[vertex];
    	
    	// Loop over the edges
    	for (int edge = 0; edge < edges.length; edge++) {
    		if (edges[edge] != null) {
    			MyPair myPair = edges[edge];
    			neighbours.add(myPair);
    		}
    	}
    	
       	// Sort the neighbours
       	neighbours = sortNeighbours(neighbours);
       	
       	// Sub list the list
       	if (k > 0 && k <= neighbours.size()) {
       		//System.out.println("k is: " + k + " size is: " + neighbours.size());
       		neighbours = neighbours.subList(0, k);
       	}

        return neighbours;
    } // end of outNearestNeighbours()
    
    public void printVertices(PrintWriter os) {
        // Implement me!
    	
    	String output = "";
    	
    	for (String vertex : indexMap.keySet()) {
    		output += vertex + " ";
    	}
    	
    	
		os.print(output); // TODO get os working
		os.flush();
		//os.close();
    	
    	//System.out.println(output);
    	
    } // end of printVertices()


    public void printEdges(PrintWriter os) {
        // Implement me!
    	
    	String output = "";
    	
    	for (int vertex = 0; vertex < vertices; vertex++) {
    		output += getEdges(vertex);
    	}
    	
       	
		os.print(output); // TODO get os working
    	os.flush();
    	//os.close();
    	//System.out.println("");
    	
    } // end of printEdges()
    

    public String getEdges(int vertex) {
        // Implement me!
    	
    	MyPair[] edges = adjList[vertex];
    	
    	String output = "";

    	if (edges == null) {
    		return "";
    	}
    	
    	//System.out.printf("The edges for %3s are: ", reverseMap.get(vertex));
    	for (int i = 0; i < edges.length; i++) {
    		if (edges[i] != null && edges[i].getValue() != 0) {
    			output += reverseMap.get(vertex) + " " + edges[i].getKey() + " " 
    					+ edges[i].getValue() + "\n";
    		}
    	}
    	
    	// Return the output
    	return output;
    	
    } // end of printEdges()
    
    public MyPair[][] getAdjList(){
    	return adjList;
    }
    
    public void resizeAdjList(int factor) {
    	
    	System.out.println("Resizing the adjacency list ....");
    	
    	// Create the adjacency list
    	MyPair[][] tempAdjList = new MyPair[m * factor + 1][n * factor + 1];
    	
    	// Populate the temporary adjacency list with the existing values
    	for (int vertex = 0; vertex < m; vertex++) {
    		MyPair[] edges = adjList[vertex];
    		MyPair[] tempEdges = new MyPair[edges.length];
    		for (int edge = 0; edge < edges.length; edge++) {
    			if (edges[edge] != null) {
    				tempEdges[edge] = new MyPair(edges[edge].getKey(), edges[edge].getValue());
    			}
    		}
    		tempAdjList[vertex] = tempEdges;
    	}
    	
    	// Set the new incidence matrix
    	adjList = tempAdjList;
    	m = m * factor;
    	n = n * factor;
    	
    	System.out.println("The adjacency list has been resized to: " + m + "x" + n);
    	
    }
    
   public boolean checkDuplicate(String vertex) {
    	
    	// Initialise the variables
    	boolean duplicate = false;
    	
    	if (indexMap.containsKey(vertex)) {
    		System.out.println("A duplicate has been found for: " + vertex);
    		return true;
    	}
    	
    	
    	// Return the result if duplicate not found
    	return duplicate;
    	
   }
   
   private void printNeighbours(String vertex, List<MyPair> neighbours) {
   	
   	String output = vertex + " ";
		
   	// Loop through the list and print
   	for (MyPair myPair : neighbours) {
   		output += "(" + myPair.getKey() + "," + myPair.getValue() + ") ";
   	}
   	
   	System.out.println(output);
	}
   
   
   
   private List<MyPair> sortNeighbours(List<MyPair> neighbours) {
   	
   	// Based on a selection sort
		
   	// Loop through the list and sort
       for (int i = 0; i < neighbours.size() - 1; i++) {
           for (int j = i + 1; j < neighbours.size(); j++) {
               // check if we need to swap
               if (neighbours.get(j).getValue() > neighbours.get(i).getValue()) {
                   MyPair temp = neighbours.get(j);
                   neighbours.set(j, neighbours.get(i));
                   neighbours.set(i, temp);
               }
           }
       }
   	
   	// Return the sorted list
   	return neighbours;
	}


    public static int getVertices() {
    	return vertices;
    }


	protected class Node {
    	public Node() {

    	}
    }
} // end of class AdjList
