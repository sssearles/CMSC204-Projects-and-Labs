
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * This class is a Data Structure class that implements GraphInterface.
 * The vertices are towns and the edges are roads. Within this class is a 
 * method called shortestPath that finds the shortes path from a given source 
 * town to a destination town. It uses the Dijjkstra Shortest Path algorithm.
 * @author Susan Searles
 * CMSC 204 with Professor Alexander
 * Due December 2, 2020
 *
 */
public class Graph implements GraphInterface<Town, Road> {

	final int noEdge = Integer.MAX_VALUE;
	final int noPath = Integer.MAX_VALUE;

	private Set<Town> towns = new HashSet<>();
	private Set<Road> roads = new HashSet<>();
	private ArrayList <String> shortestPath = new ArrayList<>();
	private Town destination;
	private int endTown;

	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road road = null;

		for (Road r : roads) {
			if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
				road = r;
			}
		}
		return road;
	}

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException ();
		}

		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(road);
		return road;
	}

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town town) {

		if (town == null) {
			throw new NullPointerException();
		}

		if (!towns.contains(town)) {
			towns.add(town);
			return true;
		}
		else return false;
	}


    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {

		for (Road r: roads) {
			if (r.contains(sourceVertex) && r.contains(destinationVertex)) {
				return true;
			}
		}
		return false;
	}

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town town) {

		for (Town t : towns) {
			if(t.getName().equals(town.getName())) {
				return true;
			}
		}
		return false;
	}

    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {

		return roads;
	}

    /**
     * This method returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edges = new HashSet<>();
		for (Road r: roads) {
			if (r.contains(vertex)) {
				edges.add(r);
			}
		}
		return edges;
	}

    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		Set<Road> temp = new HashSet<>();
		Road road = null;
		for (Road r: roads) {
			if (r.contains(destinationVertex) && r.contains(sourceVertex)
					&& (weight > -1) && description != null)
				road = r;
		}
		if (roads.remove(road)) {
			return road;
		}
		else {
			return null;
		}
	}

    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town town) {
		return towns.remove(town);
	}

    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {

		return towns;
	}

    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */  
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		destination = destinationVertex;
		dijkstraShortestPath(sourceVertex);
		String shortest = "";

		for (int i = 0; i < shortestPath.size()-1; i++) {
			
			Town source = new Town(shortestPath.get(i));
			Town destination = new Town(shortestPath.get(i+1));
			Road road = getEdge(source,destination);
			if (road == null) {
				break;
			}

			shortest += source+" via "+road.getName()+" to "+destination+" "+road.getWeight()+" mi;";
		}
		shortestPath.clear();
		if(!shortest.contains(destinationVertex.getName())) {
			return shortestPath;
		}
		for(String leg : shortest.split(";")) {
			shortestPath.add(leg);
		}

		return shortestPath;
	}

	   /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * 
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		
		shortestPath.clear();
		Town[] allTowns = new Town[towns.size()];
		int index = 0;
		
		for (Town t: towns) {
			
			allTowns[index] = new Town(t);
			index++;
		}
		
		int[][] adjacencyMatrix = new int[towns.size()][towns.size()];
		
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				if (i == j || !containsEdge(allTowns[i], allTowns[j])) {
					adjacencyMatrix[i][j] = 0;
					
				} else {
					int weight = getEdge(allTowns[i], allTowns[j]).getWeight();
					adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = weight;
				}
			}
		}
		int startTown = 0; 
		for (Town t: allTowns) {

			if (!t.equals(sourceVertex)) {
				startTown++;
			} else {
				break;
			}
		}

		endTown = 0;
		for (Town t: allTowns) {
			if (!t.equals(destination)) {
				endTown++;
			} else {
				break;
			}
		}

		int numTowns = adjacencyMatrix[0].length;
		int[] smallestWeights = new int[numTowns];

		boolean[] added = new boolean[numTowns];

		for (int townIndex = 0; townIndex < numTowns; townIndex++) {

			smallestWeights[townIndex] = noEdge;
			added[townIndex] = false;
		}
		smallestWeights[startTown] = 0;
		int[] minLengthsPath = new int[numTowns];
		minLengthsPath[startTown] = -1;

		for (int i = 1; i < numTowns; i++) {

			int nearestTown = -1;
			int smallestWeight = noEdge;
			for (int townIndex = 0; townIndex < numTowns; townIndex++) {

				if (!added[townIndex] && smallestWeights[townIndex] < smallestWeight) {
					nearestTown = townIndex;
					smallestWeight = smallestWeights[townIndex];
				}
			}

			added[nearestTown] = true;

			for (int townIndex = 0; townIndex < numTowns; townIndex++) {

				int roadDistance = adjacencyMatrix[nearestTown][townIndex];

				if (roadDistance > 0 && ((smallestWeight + roadDistance)< smallestWeights[townIndex])) {

					minLengthsPath[townIndex] = nearestTown;
					smallestWeights[townIndex] = smallestWeight + roadDistance;
				}
			}
		}
		addToPathArrayList(endTown, minLengthsPath);
	}

	/**
	 * This method checks the vertices connected to a given source vertex and finds the 
	 * one with the minimum length. Then adds the name of the vertex to the shortestPath
	 * arrayList.
	 * @param sourceVertex
	 * @param minLengthsPath
	 */
	private void addToPathArrayList(int sourceVertex, int[] minLengthsPath) {

		if (sourceVertex == -1) {
			return;
		}

		addToPathArrayList(minLengthsPath[sourceVertex], minLengthsPath);

		int townIndex = 0;

		for (Town t: towns) {

			if (townIndex == sourceVertex) {

				shortestPath.add(t.getName());
			}

			townIndex++;
		}
	}


}

