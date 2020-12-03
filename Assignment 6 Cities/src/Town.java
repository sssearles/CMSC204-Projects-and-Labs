
public class Town implements Comparable<Town> {

	/**
	 * Name of the town
	 */
	protected String name;
	
	/**
	 * This constructor requires the town's name.
	 * @param name
	 */
	public Town(String name) {
		this.name = name;
	}
	
	/**
	 * Copy Constructor creates an instance of Town
	 * @param templateTown instance of Town
	 */
	public Town(Town templateTown) {
		this(templateTown.name); 
	}
	
	/**
	 * Returns the name of the Town
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This methods compares the town names to see if they are equal.
	 * @param town another town to be compared
	 * @return positive number if the names are equal, negative number
	 * if they are not equal.
	 */
	@Override
	public int compareTo(Town town) {
		return this.name.compareTo(town.name);
	}
	
	/**
	 * This method returns a string name of the town.
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * This method returns the hashcode for the name of the town.
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * Returns true if the town names are equal and returns
	 * false if they are not.
	 */
	@Override
	public boolean equals(Object obj) {
		Town town = (Town)obj;
		return this.name.compareTo(town.name) == 0; 
	}

}
