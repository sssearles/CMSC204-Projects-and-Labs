
/**
 *  This class implements Comparable and consists of five attributes--
 *  the CourseID, CRN, number of credits, room number, and instructor name
 *  It is normally referred to as a CDE.
 * @author Susan Searles
 * CMSC 204, Dr. Robert Alexander
 * Due Wednesday, October 28, 2020
 *
 */
public class CourseDBElement implements Comparable {

	private String id = "";
	private int	crn = 0;
	private int credits = 0;
	private String room = "";
	private String instructor = "";
	
	// No-arg constructor
	/**
	 * No-arg constructor
	 */
	public CourseDBElement() {
		
	}
	
	// Constructor
	/**
	 * This is a constructor with all the attributes of an element
	 * @param id course code from the MC catalog
	 * @param crn unique reference number for each section of the course
	 * @param credits number of credits earned for the course
	 * @param room where the course is held (or REMOTE/Distance-Learning)
	 * @param instructor name of the instructor for the course
	 */
	public CourseDBElement(String id, int crn, int credits, String room, String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.room = room;
		this.instructor = instructor;
	}
	
	// Coerce the crn to a string and create the hashCode for the CRN
	/**
	 * This method casts the crn as a string and returns the hash code
	 */
	public int hashCode() {;
		return (""+crn).hashCode();
	}
	
	/**
	 *  ToString method to convert an element into a string for the display method
	 */
	public String toString() {
		String courseString = "\nCourse:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:"+room;
		return courseString;
	}
	
	// Create getters for each field.
	/**
	 * Getter for the course id
	 * @return id String of the course
	 */
	public String getId() {
		return id;
	}
	/**
	 * Getter for the course crn
	 * @return id int of the course
	 */
	public int getCRN() {
		return crn;
	}
	/**
	 * Getter for the course credits
	 * @return credits for the course
	 */
	public int getCredits() {
		return credits;
	}
	
	/**
	 * Getter for the course room 
	 * @return room of the course
	 */
	public String getRoom() {
		return room;
	}
	
	/**
	 * Getter for the course instructor
	 * @return instructor of the course
	 */
	public String getInstructor() {
		return instructor;
	}
	
	// Create setters for each field.
	
	/**
	 * Sets the id value
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the crn value
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	/**
	 * Sets the credits value
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	/**
	 * Sets the room value
	 * @param room
	 */
	public void setRoom(String room) {
		this.room = room;
	}
	
	/**
	 * Sets the instructor value
	 * @param instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * Method that compares two elements based on the crn
	 * and returns a positive, negative, or 0 value for
	 * using Comparable
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		
		return this.crn - element.crn;
	}
	
	/**
	 * Equals method that compares two elements based on their
	 * String representation.
	 */
	@Override
	public boolean equals(Object element) {
		if (this.toString().equals(element.toString())){
			return true;
		} else return false;
	}
	
	
}
