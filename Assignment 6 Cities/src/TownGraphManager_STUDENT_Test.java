import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[12];
		  
		  town[1] = "Rockville";
		  town[2] = "Gaithersburg";
		  town[3] = "Clarksburg";
		  town[4] = "Boyds";
		  town[5] = "Hyattstown";
		  town[6] = "Barnesville";
		  town[7] = "Dickerson";
		  town[8] = "Damascus";
		  town[9] = "Olney";
		  town[10] = "Urbana";
		  town[11] = "Frederick";

		  for (int i = 1; i < 12; i++) {
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 12, "355");
		  graph.addRoad(town[1], town[3], 14, "27");
		  graph.addRoad(town[1], town[5], 16, "Brink");
		  graph.addRoad(town[3], town[7], 11, "270");
		  graph.addRoad(town[3], town[8], 12, "15");
		  graph.addRoad(town[4], town[8], 13, "70");
		  graph.addRoad(town[6], town[9], 13, "97");
		  graph.addRoad(town[9], town[10], 14, "295");
		  graph.addRoad(town[8], town[10], 12, "495");
		  graph.addRoad(town[5], town[10], 15, "650");
		  graph.addRoad(town[10], town[11], 13, "40");
		  graph.addRoad(town[2], town[11], 16, "66");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("15", roads.get(0));
		assertEquals("27", roads.get(1));
		assertEquals("270", roads.get(2));
		assertEquals("295", roads.get(3));
		graph.addRoad(town[4], town[11], 1,"118");
		roads = graph.allRoads();
		assertEquals("118", roads.get(0));
		assertEquals("15", roads.get(1));
		assertEquals("27", roads.get(2));
		assertEquals("270", roads.get(3));
		assertEquals("295", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("66", graph.getRoad(town[2], town[11]));
		assertEquals("270", graph.getRoad(town[3], town[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Baltimore"));
		graph.addTown("Baltimore");
		assertEquals(true, graph.containsTown("Baltimore"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Baltimore"));
		graph.addTown("Baltimore");
		ArrayList<String> path = graph.getPath(town[1],"Baltimore");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Gaithersburg"));
		assertEquals(false, graph.containsTown("Baltimore"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("15", roads.get(0));
		assertEquals("27", roads.get(1));
		assertEquals("270", roads.get(2));
		assertEquals("97", roads.get(10));
		assertEquals("Brink", roads.get(11));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		graph.deleteRoadConnection(town[2], town[11], "66");
		assertEquals(false, graph.containsRoadConnection(town[2], town[11]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Gaithersburg"));
		graph.deleteTown(town[2]);
		assertEquals(false, graph.containsTown("Gaithersburg"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Barnesville", roads.get(0));
		assertEquals("Boyds", roads.get(1));
		assertEquals("Clarksburg", roads.get(2));
		assertEquals("Damascus", roads.get(3));
		assertEquals("Rockville", roads.get(9));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[11]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Rockville via 355 to Gaithersburg 12 mi",path.get(0).trim());
		  assertEquals("Gaithersburg via 66 to Frederick 16 mi",path.get(1).trim());

	}
	

}