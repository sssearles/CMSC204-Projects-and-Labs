import java.io.IOException;
import java.util.LinkedList;

/**
 * This class implements a hash table with buckets, creating an array
 * of linked lists of CourseDBElements. Each CDE has a hash code that
 * is generated from the crn. It adds CDEs to the data structure. If a
 * linked list doesn't exist, it creates one and adds it to the hash
 * table. If a linked list already exists for a given bucket, the CDE 
 * is added to the existing linked list. 
 * @author 13015
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	protected LinkedList<CourseDBElement>[] hashTable;
	protected int tableSize;

	/**
	 * This constructor is for testing purposes and has two args per the instructions. 
	 * It takes an int for the size of the hash table and a string "Testing" 
	 * @param testing the string "Testing" 
	 * @param size
	 */
	@SuppressWarnings("unchecked") 
	public CourseDBStructure(String testing, int size) {
		tableSize = size;
		hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
	}

	/** This constructor takes in an int that is the estimated size of
	 *  the hash table. Professor Alexander said to make that 20.
	 * @param size the chosen size of the hash table
	 */
	@SuppressWarnings("unchecked") 
	public CourseDBStructure(int size) {
		tableSize = size;
		hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
	}

	/**
	 * Getter for the tableSize value.
	 */
	@Override
	public int getTableSize() {
		return tableSize;

	}

	/**
	 * This method adds an element to a bucket's LinkedList
	 * in the hashTable. If no linked list exists, one is 
	 * created.
	 */
	@Override
	public void add(CourseDBElement element) {
		CourseDBElement temp = new CourseDBElement(element.getId(), element.getCRN(), element.getCredits(), element.getRoom(), element.getInstructor());

		// Calculate the hash code
		int hash = Math.abs(element.hashCode()) % tableSize;

		LinkedList<CourseDBElement> cdeList = hashTable[hash];
		if (cdeList==null)
		{
			// Create new linked list if there are no elements at this index
			hashTable[hash] = new LinkedList<CourseDBElement>();
		}

		// Add the element
		hashTable[hash].add(temp);
	}

	/**
	 * This method retrieves a course based on its CRN.
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		for (int index = 0; index < tableSize; index++ ) {
			if (hashTable[index] != null) {
				for (CourseDBElement cde : hashTable[index]) {
					if (cde.getCRN() == crn) {
						return cde;
					}
				}
			}

		}
		// Search the bucket

		throw new IOException("Course CRN " + crn + " is not in database");
	}
}
