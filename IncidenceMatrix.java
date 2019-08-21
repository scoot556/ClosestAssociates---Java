import java.io.*;
import java.util.*;


/**
 * Incident matrix implementation for the AssociationGraph interface.
 *
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2019.
 */
public class IncidenceMatrix extends AbstractAssocGraph
{
	
	// Initialise the variables
	private String[][] incidenceMatrix;
	private int m = 8;
	private int n = 20;
	private static int vertices;
	
    
	/**
	 * Constructs an empty graph of dimension m x n.
	 */
    public IncidenceMatrix() {
    	// Implement me!
    	this.incidenceMatrix = new String[m + 1][n + 1]; // Vertices are in col 0
    													 // Edges are in row 0
    } // end of IncidentMatrix()


    public static void main(String[] args) {
    	
    	// Create the incidence matrix
    	IncidenceMatrix myIncidenceMatrix = new IncidenceMatrix();
    	
    	IncidenceMatrix.test1(myIncidenceMatrix);
    	
    	//IncidenceMatrix.test2(myIncidenceMatrix);
    	
    }
    
    public static void test1(IncidenceMatrix myIncidenceMatrix) {
    	
    	// Add vertices
    	myIncidenceMatrix.addVertex("A");
    	myIncidenceMatrix.addVertex("B");
    	myIncidenceMatrix.addVertex("C");
    	myIncidenceMatrix.addVertex("D");
    	myIncidenceMatrix.addVertex("E");
    	myIncidenceMatrix.addVertex("F");
    	myIncidenceMatrix.addVertex("G");
    	myIncidenceMatrix.addVertex("H");
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Add the edges
    	myIncidenceMatrix.addEdge("A", "B", 1);
    	myIncidenceMatrix.addEdge("B", "C", 2);
    	myIncidenceMatrix.addEdge("D", "B", 3);
    	myIncidenceMatrix.addEdge("C", "E", 5);
    	myIncidenceMatrix.addEdge("E", "F", 6);
    	myIncidenceMatrix.addEdge("C", "G", 7);
    	myIncidenceMatrix.addEdge("G", "E", 7);
    	myIncidenceMatrix.addEdge("G", "H", 4);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Update the edge weight
    	System.out.println("Updating edge weights...");
    	myIncidenceMatrix.updateWeightEdge("G", "H", 5);
    	myIncidenceMatrix.updateWeightEdge("A", "B", 10);
    	myIncidenceMatrix.updateWeightEdge("D", "B", 9);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Get the n nearest out neighbours
    	System.out.println("Getting out nearest neighbours...");
    	List<MyPair> neighboursOut = myIncidenceMatrix.outNearestNeighbours(-1, "B");
    	myIncidenceMatrix.printNeighbours("B", neighboursOut);
    	
    	// Get the n nearest in neighbours
    	System.out.println("Getting in nearest neighbours...");
    	List<MyPair> neighboursIn = myIncidenceMatrix.inNearestNeighbours(-1, "F");
    	myIncidenceMatrix.printNeighbours("F", neighboursIn);
    	
    	// Get the n nearest out neighbours
    	System.out.println("Getting out nearest neighbours...");
    	neighboursOut = myIncidenceMatrix.outNearestNeighbours(-1, "C");
    	myIncidenceMatrix.printNeighbours("C", neighboursOut);
    	
    	// Get the n nearest out neighbours
    	System.out.println("Getting out nearest neighbours...");
    	neighboursOut = myIncidenceMatrix.outNearestNeighbours(1, "C");
    	myIncidenceMatrix.printNeighbours("C", neighboursOut);
    	
    	// Get edge weights
    	System.out.println("Getting the edge weights...");
    	System.out.println(myIncidenceMatrix.getEdgeWeight("A", "B"));
    	System.out.println(myIncidenceMatrix.getEdgeWeight("D", "A"));
    	
    	// Remove vertex
    	System.out.println("Removing vertices...");
    	myIncidenceMatrix.removeVertex("J");
    	myIncidenceMatrix.removeVertex("A");
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Update the edge weight
    	System.out.println("Updating edge weights...");
    	myIncidenceMatrix.updateWeightEdge("B", "C", 0);
    	myIncidenceMatrix.updateWeightEdge("E", "F", 0);
    	myIncidenceMatrix.updateWeightEdge("F", "E", 0);

    	// Adding a vertex
    	System.out.println("Adding vertex...");
    	myIncidenceMatrix.addVertex("J");

    	// Create the print writer
    	PrintWriter os = new PrintWriter(System.out);
    	

    	// Print the incidence matrix edges
    	System.out.println("The edges are ...");
    	myIncidenceMatrix.printEdges(os);
    	
    	// Print the incidence matrix vertices
    	System.out.println("Getting the vertices...");
    	myIncidenceMatrix.printVertices(os);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Close the PrintWriter
    	os.flush();
    	os.close();
    }
    
    
    public static void test2(IncidenceMatrix myIncidenceMatrix) {
    	
    	// Add vertices
    	myIncidenceMatrix.addVertex("A");
    	myIncidenceMatrix.addVertex("B");
    	myIncidenceMatrix.addVertex("C");
    	myIncidenceMatrix.addVertex("D");
    	myIncidenceMatrix.addVertex("E");
    	myIncidenceMatrix.addVertex("F");
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Add the edges
    	myIncidenceMatrix.addEdge("A", "B", 1);
    	myIncidenceMatrix.addEdge("C", "B", 1);
    	myIncidenceMatrix.addEdge("B", "D", 1);
    	myIncidenceMatrix.addEdge("A", "E", 3);
    	myIncidenceMatrix.addEdge("D", "C", 5);
    	myIncidenceMatrix.addEdge("F", "A", 2);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Get the n nearest out neighbours
    	System.out.println("Getting out nearest neighbours...");
    	List<MyPair> neighboursOut = myIncidenceMatrix.outNearestNeighbours(-1, "A");
    	myIncidenceMatrix.printNeighbours("A", neighboursOut);
    	
    	// Get the n nearest in neighbours
    	System.out.println("Getting in nearest neighbours...");
    	List<MyPair> neighboursIn = myIncidenceMatrix.inNearestNeighbours(-1, "F");
    	myIncidenceMatrix.printNeighbours("F", neighboursIn);

    	// Get edge weights
    	System.out.println("Getting the edge weights...");
    	System.out.println(myIncidenceMatrix.getEdgeWeight("C", "B"));
    	System.out.println(myIncidenceMatrix.getEdgeWeight("B", "C"));
    	System.out.println(myIncidenceMatrix.getEdgeWeight("A", "E"));
    	
    	// Update the edge weight
    	System.out.println("Updating edge weights...");
    	myIncidenceMatrix.updateWeightEdge("C", "B", 4);
    	myIncidenceMatrix.updateWeightEdge("A", "B", 0);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    	
    	// Remove vertex
    	System.out.println("Removing vertices...");
    	myIncidenceMatrix.removeVertex("D");
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());


    	// Adding a vertex
    	System.out.println("Adding vertex...");
    	myIncidenceMatrix.addVertex("G");

    	// Create the print writer
    	PrintWriter os = new PrintWriter(System.out);
    	
    	// Print the incidence matrix vertices
    	System.out.println("Getting the vertices...");
    	myIncidenceMatrix.printVertices(os);
    	
    	// Print the incidence matrix
    	//myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());

    	// Print the incidence matrix edges
    	System.out.println("The edges are ...");
    	myIncidenceMatrix.printEdges(os);
    	
    	// Print the incidence matrix
    	myIncidenceMatrix.printMatrix(myIncidenceMatrix.getIncidenceMatrix());
    }
    
    
    public void addVertex(String vertLabel) {
        // Implement me!
    	
    	// Check if the vertex is a duplicate
    	if (checkDuplicate(vertLabel)) {
    		return;
    	}
    	
    	// Add the vertex into col 0
    	int row = 0;
    	for (int r = 1; r < m + 1; r++) {
    		if (incidenceMatrix[r][0] == null) {
    			row = r;
    			break;
    		}
    	}
    	incidenceMatrix[row][0] = vertLabel;
    	vertices++;
    	
    	// Check if the incidenceMatrix needs to be resized
    	if (vertices == m) {
    		resizeMatrix(10);
    	}
    	
    } // end of addVertex()


    public void addEdge(String srcLabel, String tarLabel, int weight) {
        // Implement me!
    	int srcRow = findVertex(srcLabel);
    	int tarRow = findVertex(tarLabel);
    	
    	if (srcRow > 0 && tarRow > 0) {
    		int edgeCol = findEdge(srcLabel, tarLabel);
    		
    		if (edgeCol == 0) {
    			//System.out.println("The edge does not exist and will be created!");
    			edgeCol = findNextEmptyEdge();
    			incidenceMatrix[0][edgeCol] = createEdgeLabel(srcLabel, tarLabel);
        		incidenceMatrix[srcRow][edgeCol] = "" + weight;
        		incidenceMatrix[tarRow][edgeCol] = "" + (-weight);
    		} else {
    			System.out.println("The edge already exists and will need to be updated!");
    			return;
    		}
    		

    	} else {
    		System.out.println("Either the source vertex or target vertex do not exist!");
    	}
    } // end of addEdge()


	public int getEdgeWeight(String srcLabel, String tarLabel) {
		// Implement me!
		
		// Initialise the variables
		int row = findVertex(srcLabel);
		int col = findEdge(srcLabel, tarLabel);
		
		if (row > 0 && col > 0) {
			return Integer.parseInt(incidenceMatrix[row][col]);
		}

		// update return value
		return EDGE_NOT_EXIST;
	} // end of existEdge()


	public void updateWeightEdge(String srcLabel, String tarLabel, int weight) {
        // Implement me!
	   	int srcRow = findVertex(srcLabel);
    	int tarRow = findVertex(tarLabel);
    	
    	if (srcRow > 0 && tarRow > 0) {
    		int edgeCol = findEdge(srcLabel, tarLabel);
    		incidenceMatrix[srcRow][edgeCol] = "" + weight;
    		incidenceMatrix[tarRow][edgeCol] = "" + (-weight);
    	} else {
    		System.out.println("Either the src or tar do not exist!");
    	}
		
    } // end of updateWeightEdge()


    public void removeVertex(String vertLabel) {
        // Implement me!
    	
    	//System.out.println("Deleting row: " + vertLabel);
    	
    	// Initialise the variables
    	String[][] tempIncidenceMatrix = new String[m][n + 1];
    	int[] edges = findAllEdges(vertLabel);
    	int r2 = 0;
    	int c2 = 0;
    	
    	// Remove the vertex
    	int row = findVertex(vertLabel);
    	if (row == 0) {
    		System.out.println("The vertex: " + vertLabel + " does not exist!");
    		return;
    	}
    	
    	for (int r = 0; r < m + 1; r++) {
    		if (r == 0) {
    			r2 = 0;
    		}

    		if (r != row) {
	    		c2 = 0;
	    		for (int c = 0; c < n + 1; c++) {
	    			if (c == 0 || !IncidenceMatrix.itemInArray(c, edges)) {
			    		tempIncidenceMatrix[r2][c2] = incidenceMatrix[r][c];
		    			c2++;
	    			} else {
	    				//System.out.println("Deleting column: " + c);
	    			}
	    		}
	    		r2++;
    		}
    	}
    	
    	m = m - 1;
    	//n = c2 - 1;
    	
    	//System.out.println("The temporary matrix is: ");
    	//IncidenceMatrix.printMatrix(tempIncidenceMatrix);
 
    	incidenceMatrix = tempIncidenceMatrix;
    	
    	
    	//System.out.println("The incidence matrix is: ");
    	//IncidenceMatrix.printMatrix(incidenceMatrix);
    	
    } // end of removeVertex()


	public List<MyPair> inNearestNeighbours(int k, String vertLabel) {
        
		// Initialise the neighbours list
		List<MyPair> neighbours = new ArrayList<MyPair>();
		
		neighbours = nearestNeighbours(k, vertLabel, true);
		
		// Return the neighbours
		return neighbours;
		
	}
	

    public List<MyPair> outNearestNeighbours(int k, String vertLabel) {
        
    	// Initialise the list
    	List<MyPair> neighbours = new ArrayList<MyPair>();

        // Implement me!
    	neighbours = nearestNeighbours(k, vertLabel, false);
		
		// Return the neighbours
        return neighbours;
        
    } // end of outNearestNeighbours()
	
	public List<MyPair> nearestNeighbours(int k, String vertLabel, Boolean in) {

        // Implement me!
		
		// Initialise the neighbours list
		List<MyPair> neighbours = new ArrayList<MyPair>();
        
       	// Initialise the variables
    	int columns = incidenceMatrix[0].length;
    	//System.out.println("Number of columns is: " + columns);
    	
    	int rows = incidenceMatrix.length;
    	//System.out.println("Number of rows is: " + rows);
    	
    	// Find the vertex
    	int row = findVertex(vertLabel);
    	//System.out.println("The row being examined for: " + vertLabel + " is " + row);
    	
    	// Loop through the columns
       	for (int c = 1; c < columns; c++) {
       		if (incidenceMatrix[row][c] != null) {
       			//System.out.println("The string value of weight is: " + incidenceMatrix[row][c]);
       			int weight = Integer.parseInt(incidenceMatrix[row][c]);
       			if (in == true) {
       				weight = - weight;
       			}
       			//System.out.println("The integer value of weight is: " + weight);
       			if (weight > 0) {
       				//System.out.println("The in weight for: " + vertLabel + " is: " + weight);
       				String edge = incidenceMatrix[0][c];
       				//System.out.println("The edge is: " + edge);
       				String otherVertex = getOtherVertex(vertLabel, edge);
       				//System.out.println("The other vertex is: " + otherVertex);
       				MyPair myPair = new MyPair(otherVertex, weight);
       				neighbours.add(myPair);
       			}
       		}
       	}
       	
       	// Print the unsorted neighbours
       	//System.out.println("The unsorted neighbours are =========");
       	//printNeighbours(vertLabel, neighbours);
       	
       	// Sort the neighbours
       	neighbours = sortNeighbours(neighbours);
       	
       	// Sub list the list
       	if (k > 0 && k <= neighbours.size()) {
       		//System.out.println("k is: " + k + " size is: " + neighbours.size());
       		neighbours = neighbours.subList(0, k);
       	}
       	
       	// Print the sorted and shortened neighbours
       	//System.out.println("The sorted neighbours are =========");
       	//printNeighbours(vertLabel, neighbours);

        return neighbours;
    } // end of inNearestNeighbours()


	public void printVertices(PrintWriter os) {
        // Implement me!
    	
    	//System.out.println("The vertices are ...");
    	
    	String output = "";
    	
    	// Loop through the rows
    	for (int r = 1; r < m + 1; r++) {
    		if (incidenceMatrix[r][0] != null) {
    			output += incidenceMatrix[r][0] + " ";

    		} else {
    			break;
    		}
    	}
    	
		os.print(output); // TODO get os working
		os.flush();
		//os.close();
    	
    	//System.out.println(output);
    	
    	
    } // end of printVertices()


    public void printEdges(PrintWriter os) {
        // Implement me!

    	String output = "";
    	
       	for (int r = 1; r < m + 1; r++) {
	    	for (int c = 1; c < n + 1; c++) {
	       		if (incidenceMatrix[r][c] != null) {
	       			String vertex = incidenceMatrix[r][0];
	       			String edge = incidenceMatrix[0][c];
	       			String otherVertex = getOtherVertex(vertex, edge);
	       			String weight = incidenceMatrix[r][c];
	       			//System.out.println("row: " + r + " col: " + c + " weight: " + weight);
	       			int intWeight = Integer.valueOf(weight);
	       			if (intWeight > 0) {
	       				output +=  vertex + " " + otherVertex + " " + weight + "\n";
	       			}
	       		} 
	    	}
       	}
       	
		os.print(output); // TODO get os working
    	os.flush();
    	//os.close();
       	
    	//System.out.println(output);
       	
    } // end of printEdges()
    

    public static void printMatrix(String[][] matrix) {
    	
    	int columns = matrix[0].length;
    	//System.out.println("Number of columns is: " + columns);
    	
    	int rows = matrix.length;
    	//System.out.println("Number of rows is: " + rows);
    	
    	// Print the header col numbers
    	for (int col = 0; col < columns; col++) {
    		if (col > 0 && matrix[0][col] == null) {
    			break;
    		}
    		System.out.printf("%5s", col);
    	}
        
    	// Print the rows and columns
    	for (int r = 0; r < rows; r++) {
    		if (r > 0 && matrix[r][0] == null) {
    			break;
    		}
        	System.out.printf("%n");
	       	for (int c = 0; c < columns; c++) {
	    		if (c > 0 && matrix[0][c] == null) {
	    			break;
	    		}
	       		String output = matrix[r][c];
	       		if (output == null || output == "") {
	       			output = "" + 0;
	       		}
		    		System.out.printf("%5s", output);
		//    		os.write(incidenceMatrix[0][c]); // TODO get os working
		//    		os.flush();
		//    		os.close();

	    	}
	     // Print the header row numbers
	       	System.out.printf("%5s", r);
        }
    	// Print a blank line
    	System.out.printf("%n");
    	
    } // end of printMatrix()
    
    
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

	public static boolean itemInArray(int c, int[] edges) {
    	
    	// Initialise the variables
    	boolean found = false;
    	
       	// Loop through the array
    	for (int edge : edges) {
    		if (c == edge) {
    			found = true;
    			return found;
    		}
    	}
    	
    	// Return the result if duplicate not found
    	return found;
    }
    
    public boolean checkDuplicate(String vertex) {
    	
    	// Initialise the variables
    	boolean duplicate = false;
    	
       	// Loop through the vertices
    	for (int r = 1; r < m + 1; r++) {
    		if (incidenceMatrix[r][0] != null) {
	    		if (incidenceMatrix[r][0].equals(vertex)) {
	    			System.out.println("The vertex: " + vertex + " is a duplicate!");
	    			return true;
	    		} 
    		}
    	}
    	
    	// Return the result if duplicate not found
    	return duplicate;
    }
    
    
    public String getOtherVertex(String knownVertex, String edge) {
    	
    	// Initialise the variables
    	String vertex1 = edge.substring(0, 1);
    	//System.out.println("Vertex1 is: " + vertex1);
    	String vertex2 = edge.substring(1, 2);
    	//System.out.println("Vertex2 is: " + vertex2);
    	
    	if (knownVertex.equals(vertex1)) {
    		return vertex2;
    	} else {
    		return vertex1;
    	}
    }
    
    public int findVertex(String vertex) {
    	
    	// Initialise the variables
    	int row = 0;
    	
       	// Loop through the vertices
    	for (int r = 1; r < m + 1; r++) {
    		if (incidenceMatrix[r][0] != null) {
	    		if (incidenceMatrix[r][0].equals(vertex)) {
	    			row = r;
	    			//System.out.println("The vertex: " + vertex + " row number is: " + row);
	    			return row;
	    		} 
    		}
    	}
    	// Return the row number
    	return row;
    }
    
    public String createEdgeLabel(String srcLabel, String tarLabel) {
    	
    	// Initialise the variables
    	char srcChar = srcLabel.charAt(0);
    	char tarChar = tarLabel.charAt(0);
    	String edgeLabel = "";
    	if (srcChar < tarChar) {
    		edgeLabel = srcLabel + tarLabel;
    	} else {
    		edgeLabel = tarLabel + srcLabel;
    	}
    	
    	// Return the edge label
    	return edgeLabel;
    }
    
    public int findEdge(String srcLabel, String tarLabel) {
    	
    	// Initialise the variables
    	int col = 0;
    	char srcChar = srcLabel.charAt(0);
    	char tarChar = tarLabel.charAt(0);
    	String edge = "";
    	if (srcChar < tarChar) {
    		edge = srcLabel + tarLabel;
    	} else {
    		edge = tarLabel + srcLabel;
    	}
    	
       	// Loop through the vertices
    	for (int c = 1; c < n + 1; c++) {
    		if (incidenceMatrix[0][c] != null) {
	    		if (incidenceMatrix[0][c].equals(edge)) {
	    			col = c;
	    			//System.out.println("The edge: " + edge + " col number is: " + col);
	    			return col;
	    		} 
    		}
    	}
    	// Return the col number
    	//System.out.println("The edge: " + edge + " was not found!");
    	return col;
    }
    
    
    public int[] findAllEdges(String vertex) {
    	
    	// Initialise the variables
    	int[] allEdges = new int[n + 1];
    	int item = 0;
    	
       	// Loop through the vertices
    	for (int c = 1; c < n + 1; c++) {
    		if (incidenceMatrix[0][c] != null) {	
	    		if (incidenceMatrix[0][c].contains(vertex)) {
	    			int edge = c;
	    			allEdges[item] = edge;
	    			item++;
	    		} 
    		}
    	}
    	// Return the col number
    	//System.out.println("All edges ========= ");
    	for (int edge : allEdges) {
    		//System.out.println("Edge is: " + edge);
    	}
    	return allEdges;
    }
    
    
    public int findNextEmptyEdge() {
    	
    	// Initialise the variables
    	int emptyEdge = 0;
    	
       	// Loop through the vertices
    	for (int c = 1; c < n + 1; c++) {
    		if (incidenceMatrix[0][c] == null) {	
    			emptyEdge = c;
    			break;
    		}
    	}
    	return emptyEdge;
    }
    
    public void resizeMatrix(int factor) {
    	
    	//System.out.println("Resizing the matrix ....");
    	
    	// Create the temporary matrix
    	String[][] tempMatrix = new String[m * factor + 1][n * factor + 1];
    	
    	// Populate the temporary matrix with the existing values
    	for (int r = 0; r < m + 1; r++) {
    		for (int c = 0; c < n + 1; c++) {
    			tempMatrix[r][c] = incidenceMatrix[r][c];
    		}
    	}
    	
    	// Set the new incidence matrix
    	incidenceMatrix = tempMatrix;
    	m = m * factor;
    	n = n * factor;
    	
    	//System.out.println("The matrix has been resized to: " + m + "x" + n);
    	
    }

	public String[][] getIncidenceMatrix() {
		return incidenceMatrix;
	}

	public void setIncidenceMatrix(String[][] incidenceMatrix) {
		this.incidenceMatrix = incidenceMatrix;
	}

} // end of class IncidenceMatrix
