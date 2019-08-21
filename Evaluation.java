

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Evaluation {
	
	// Initialise the maps
	private static Set<String> verticesSet = new HashSet<>();

	public static void main(String[] args) {
		
		// Input the file
		String path = "resources/graphs/";
		String fileName = "L1.csv";
		
		// Initialise the graph type
		String implementationType;
		//implementationType = "adjlist";
		implementationType = "incmat";
		
		// Initialise the experiment factors
		Integer repeats = 1;
		Double[] results = new Double[repeats];
		double timeElapsed = 0;
		
		AssociationGraph graph = Evaluation.readFile(path + fileName, implementationType);
		
		for (int i = 0; i < repeats; i++) {
			
	        long startTime = System.nanoTime();
	        
	        Evaluation.removeVertices(graph, 1);
	        
	        long endTime = System.nanoTime();
	        
	        timeElapsed = (endTime - startTime) / Math.pow(10, 9);
	        
	        results[i] = timeElapsed;
		}
		
		double average = Evaluation.findAverage(results);
		
        System.out.println("The average time elapsed (secs): " + average);
		
	}
	
	public static void removeVertices(AssociationGraph graph, int numberToRemove) {
		
		// Initialise the variables
		int vertices = verticesSet.size();
		
		// Generate a random target vertex
		Random v = new Random();
		List<Integer> intTarPointer = v.ints(0, verticesSet.size()).distinct().limit(numberToRemove).boxed().collect(Collectors.toList());
	
		String[] strVertArray = new String[verticesSet.size()];
		strVertArray = verticesSet.toArray(strVertArray);
		
		for (Integer pointer : intTarPointer) {
			String strTarLabel = strVertArray[pointer];
			graph.removeVertex(strTarLabel);
		}
	}
	
	public static double findAverage(Double[] results) {
		
		double sum = 0.0;
		double length = (double) results.length;
		
		for (double value : results) {
			sum += value;
		}
		
		double average = sum / length;
		
		// Return the average
		return average;
	}
	
	
	public static AssociationGraph readFile(String inputFilename, String implementationType) {
		
		// Initialise the graph
		AssociationGraph graph = null;
		switch(implementationType) {
		case "adjlist":
			graph = new AdjList();
			System.out.println("Graph is adjlist");
			break;
		case "incmat":
			graph = new IncidenceMatrix();
			System.out.println("Graph is incmat");
			break;
		default:
			System.err.println("Unknown implmementation type.");
	}

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
		    		
		    		//System.out.println("Target label: " + tarLabel);
					intWeight = Integer.parseInt(strWeight);
					
					// Add the tokens to the graph
					verticesSet.add(strSrcLabel);
					graph.addVertex(strSrcLabel);
					graph.addVertex(strTarLabel);
					graph.addEdge(strSrcLabel, strTarLabel, intWeight);
					
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
		
		// Return the graph
		return graph;
	}

}
