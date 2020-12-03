
public class Road implements Comparable<Road> {

	// Instantiate fields for the Road
	protected Town source;
	protected Town destination;
	protected int weight;
	protected String name;
	
	/**
	 * This constructor creates an instance of Road 
	 * @param source town of origin
	 * @param destination town of destination
	 * @param weight length of road in miles
	 * @param name road name
	 * 
	 * 	 */
	public Road (Town source, Town destination, int weight, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}
	
	public Road (Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		int weight = 1;
	}
	
	/**
	 * This method compares the road names to see if they are the same.
	 */
	@Override
	public int compareTo(Road road) {
		return this.name.compareTo(road.name);
	}
	
	/**
	 * If the road is connected to a given town, this method returns true.
	 * if the road is not connected, it returns false.
	 * @param town vertex of the graph
	 * @return true if the road (edge) is connected to the given town (vertex)
	 */
	public boolean contains(Town town) {
		return source.getName().equals(town.getName()) || 
				destination.getName().equals(town.getName());
	}
	
	/**
	 * This method returns a string with the name of the road, the 
	 * length in miles, and the source and destination towns.
	 */
	public String toString() {
		return 	name + "," + weight + "," + source + ";" + destination;
	}
	
	/**
	 * This method checks to see if two roads are the same.
	 * Returns true if the ends of the road are the same as the ends
	 * of this road
	 */
	public boolean equals(Object r) {
		Road road = (Road)r;
		return ((this.source.equals(road.source) && 
				this.destination.equals(road.destination) ||
				(this.source.equals(road.destination) && 
				this.destination.equals(road.source))));
	}
	
	/**
	 * This method returns the name of the town (vertex)
	 * @return name of town
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the name of the road (edge)
	 * @return destination town
	 */
	public Town getDestination() {
		return destination;
	}
	
	/**
	 * This method returns the name of the source town 
	 * @return source town
	 */
	public Town getSource() {
		return source;
	}

	/**
	 * This method returns the length of the road in miles
	 * @return weight length of the road in miles
	 */
	public int getWeight() {
		return weight;
	}

}
