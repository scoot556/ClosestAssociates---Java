package generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GraphGenerator {
	
	// Initialise the maps
	private Map<String, Map<String, String>> graphMapMap = new HashMap<>();
	private Set<String> verticesSet = new HashSet<>();

	public static void main(String[] args) {
		
		// Initialise the file name
		String inputFilename = "resources/assocGraph.csv";
		
		// Initialise the class
		GraphGenerator graphGenerator = new GraphGenerator();
		
		// Read the file
		graphGenerator.readFile(inputFilename);
		
		// Get the graph details
		graphGenerator.getGraphDetails();
		
		// Add edges
		graphGenerator.addEdges(200);
		
		// Get the graph details
		graphGenerator.getGraphDetails();
		
		// Output the file
		String path = "resources/graphs/";
		String fileName = "H3.csv";
		graphGenerator.outputFile(path + fileName);
		
	}
	
	public void readFile(String inputFilename) {

		// if file specified, then load file
		if (inputFilename != null) {

			try {
				BufferedReader reader = new BufferedReader(new FileReader(inputFilename));

		    	String line;
		    	String delimiter = ",";
		    	String[] tokens;
		    	String strSrcLabel, strTarLabel, strWeight;
				int intSrcLabel, intTarLabel, intWeight;
				int edges = 0;
				
				System.out.println("Reading the file ...");

		    	while ((line = reader.readLine()) != null) {
		    		tokens = line.split(delimiter);
		    		strSrcLabel = tokens[0];
		    		//System.out.println("Source label: " + srcLabel);
		    		strTarLabel = tokens[1];
		    		strWeight = tokens[2];
		    		
		    		// Add the vertices to the set
		    		verticesSet.add(strSrcLabel);
		    		verticesSet.add(strTarLabel);
		    		
		    		//System.out.println("Target label: " + tarLabel);
					intWeight = Integer.parseInt(strWeight);

					Map<String, String> graphMap = new HashMap<>();
					graphMap.put(strTarLabel, strWeight);
					graphMapMap.put(strSrcLabel, graphMap);
					
		    		edges++;
		    	}
		    	
		    	System.out.println("File read!");

			}
			catch (FileNotFoundException ex) {
				System.err.println("File " + inputFilename + " not found.");
			}
			catch(IOException ex) {
				System.err.println("Cannot open file " + inputFilename);
			}
		}
	}
	
	public void getGraphDetails() {
		
    	int vertices = verticesSet.size();
    	double dblverts = (double) vertices;
    	
    	int intEdges = 0;
    	for (Map.Entry<String, Map<String, String>> graphMapEntry : graphMapMap.entrySet()) {
    		//System.out.println(graphMapEntry.getKey() + "," + graphMapEntry.getValue());
    			Map<String, String> graphMap = graphMapEntry.getValue();
    			for (Map.Entry<String, String> edges : graphMap.entrySet()) {
    				//System.out.println(graphMapEntry.getKey() + "," + edges.getKey() + "," + edges.getValue());
    				intEdges++;
    			}
    	}
    	
    	// Calculate the metrics
    	double dblEdges = (double) intEdges;
    	double density = 100.0 * dblEdges / (dblverts * dblverts);
    	System.out.printf("\nThe file has been read with %2d vertices and %2d edges.", vertices, intEdges);
    	System.out.println("\nDouble vertices: " + dblverts + " double edges: " + dblEdges + " double density: " + String.format("%.2f", density) + "%");
	}
	
	public void addEdges(int edgesToAdd) {
		
    	
    	int intEdges = 0;
    	for (Map.Entry<String, Map<String, String>> graphMapEntry : graphMapMap.entrySet()) {
    		//System.out.println(graphMapEntry.getKey() + "," + graphMapEntry.getValue());
    			Map<String, String> graphMap = graphMapEntry.getValue();
    			
    			for (int i = 0; i < edgesToAdd; i++) {
	    				
	    			// Generate a random weight
	    			Random r = new Random();
	    			int intWeight = r.ints(1, 1, 11).findFirst().getAsInt();
	    			String strWeight = String.valueOf(intWeight);
	    			
	    			// Generate a random target vertex
	    			Random v = new Random();
	    			int intTarPointer = v.ints(1, 0, verticesSet.size()).findFirst().getAsInt();
	    			
	    			String[] strVertArray = new String[verticesSet.size()];
	    			strVertArray = verticesSet.toArray(strVertArray);
	    			String strTarLabel = strVertArray[intTarPointer];
	    			
	    			
	    			String strSrcLabel = graphMapEntry.getKey();
	    			
	    			
	    			int intSrcLabel = Integer.parseInt(strSrcLabel);
	    			
	    			//Map<String, String> edge = new HashMap<>();
	    			graphMap.put(strTarLabel, strWeight);
	    			
//	    			
//	    			System.out.println("The source label is: " + strSrcLabel 
//	    					+ " The target label is: " + strTarLabel
//	    					+ " The random weight is: " + strWeight);
//	    			
	    			
//	    			for (Map.Entry<String, String> edges : graphMap.entrySet()) {
//	    				//System.out.println(graphMapEntry.getKey() + "," + edges.getKey() + "," + edges.getValue());
//	    				intEdges++;
//	    			}
    			
    			}
    	}
		
	}
	
	public void outputFile(String outputFileName) {
		

		// construct in and output streams/writers/readers, then process each operation.
		try {
			BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));

			// vertices output location
			PrintWriter verticesOutWriter = new PrintWriter(System.out, true);
			if (outputFileName != null) {
				System.out.println("Outputting the map to: " + outputFileName);
				verticesOutWriter = new PrintWriter(new FileWriter(outputFileName), true);
			}
			
	    	for (Map.Entry<String, Map<String, String>> graphMapEntry : graphMapMap.entrySet()) {
	    		//System.out.println(graphMapEntry.getKey() + "," + graphMapEntry.getValue());
	    		String strSrcLabel = graphMapEntry.getKey();
	    			Map<String, String> graphMap = graphMapEntry.getValue();
	    			for (Map.Entry<String, String> edges : graphMap.entrySet()) {
	    				String strTarLabel = edges.getKey();
	    				String strWeight = edges.getValue();
	    				//System.out.println(graphMapEntry.getKey() + "," + edges.getKey() + "," + edges.getValue());
	    				verticesOutWriter.println(strSrcLabel + "," + strTarLabel + "," + strWeight);
	    			}
	    	}
	    	
	    	System.out.println("Map successefully written!");

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

}
