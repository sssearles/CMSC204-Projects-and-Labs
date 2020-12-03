import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph = new Graph();

	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1, t2;
		boolean added = false;
		t1 = new Town(town1);
		t2 = new Town(town2);
		if (graph.addEdge(t1, t2, weight, roadName) != null) {
			added = true;
		}
		return added;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {

		Town t1, t2;
		t1 = new Town(town1);
		t2 = new Town(town2);

		return graph.getEdge(t1, t2).getName();
	}

	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {

		Town t1;
		t1 = new Town(v);

		return graph.addVertex(t1);
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Town t1;
		t1 = new Town(name);
		for (Town t: graph.vertexSet()) {
			if (t.equals(t1)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		Town t1;
		t1 = new Town(v);

		return graph.containsVertex(t1);
	}

	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {

		Town t1, t2;
		t1 = new Town(town1);
		t2 = new Town(town2);

		return graph.containsEdge(t1,  t2);
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> arrayList = new ArrayList<>();
		for(Road r: graph.edgeSet()) {
			arrayList.add(r.getName());
		}
		Collections.sort(arrayList);
		return arrayList;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1, t2;
		t1 = new Town(town1);
		t2 = new Town(town2);
		int weight = 0;
		String roadName = "";
		boolean deleted = false;

		for (Road r: graph.edgeSet()) {
			if (r.contains(t1) && r.contains(t2)) {
				weight = r.getWeight();
			}
			roadName = r.getName();
		}
		if (graph.removeEdge(t1, t2, weight, roadName) != null) {
			deleted = true;
		}
		return deleted;
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		Town t1;
		t1 = new Town(v);
		return graph.removeVertex(t1);
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> arrayList = new ArrayList<>();
		for(Town t: graph.vertexSet()) {
			arrayList.add(t.getName());
		}
		Collections.sort(arrayList);
		return arrayList;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1, t2;
		t1 = new Town(town1);
		t2 = new Town(town2);

		return graph.shortestPath(t1,t2);
	}

	/**
	 * This method populates the graph with all of the towns and roads from a file.
	 * @param selectedFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {

		Scanner input;
		if (selectedFile != null) {
			String[] line, roadText;
			String town1, town2;
			input = new Scanner(selectedFile);
			while(input.hasNext()) {
				line = input.nextLine().split(";");
				town1 = line[1];
				Town town1Town = new Town(town1);
				town2 = line[2];
				Town town2Town = new Town(town2);
				roadText = line[0].split(",");
				graph.addVertex(town1Town);
				graph.addVertex(town2Town);
				graph.addEdge(town1Town,  town2Town,  Integer.parseInt(roadText[1]), roadText[0]);
			}

		}


	}




}
