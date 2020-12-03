


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		  town = new Town[12];
		  
		  town[1] = new Town("Rockville");
		  town[2] = new Town("Gaithersburg");
		  town[3] = new Town("Clarksburg");
		  town[4] = new Town("Boyds");
		  town[5] = new Town("Hyattstown");
		  town[6] = new Town("Barnesville");
		  town[7] = new Town("Dickerson");
		  town[8] = new Town("Damascus");
		  town[9] = new Town("Olney");
		  town[10] = new Town("Urbana");
		  town[11] = new Town("Frederick");

		  
		  for (int i = 1; i < 12; i++) {
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 12, "355");
		  graph.addEdge(town[1], town[3], 14, "27");
		  graph.addEdge(town[1], town[5], 16, "Brink");
		  graph.addEdge(town[3], town[7], 11, "270");
		  graph.addEdge(town[3], town[8], 12, "15");
		  graph.addEdge(town[4], town[8], 13, "70");
		  graph.addEdge(town[6], town[9], 13, "97");
		  graph.addEdge(town[9], town[10], 14, "295");
		  graph.addEdge(town[8], town[10], 12, "495");
		  graph.addEdge(town[5], town[10], 15, "650");
		  graph.addEdge(town[10], town[11], 13, "40");
		  graph.addEdge(town[2], town[11], 16, "66");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[2], town[11],16, "66"), graph.getEdge(town[2], town[11]));
		assertEquals(new Road(town[3], town[7],11, "270"), graph.getEdge(town[3], town[7]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[3], town[5]));
		graph.addEdge(town[3], town[5], 11, "124");
		assertEquals(true, graph.containsEdge(town[3], town[5]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Thurmont");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		assertEquals(false, graph.containsEdge(town[3], town[9]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Gaithersburg")));
		assertEquals(false, graph.containsVertex(new Town("Thurmont")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("15", roadArrayList.get(0));
		assertEquals("27", roadArrayList.get(1));
		assertEquals("270", roadArrayList.get(2));
		assertEquals("295", roadArrayList.get(3));
		assertEquals("355", roadArrayList.get(4));
		assertEquals("97", roadArrayList.get(10));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("27", roadArrayList.get(0));
		assertEquals("355", roadArrayList.get(1));
		assertEquals("Brink", roadArrayList.get(2));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[11]));
		graph.removeEdge(town[2], town[11], 6, "124");
		assertEquals(false, graph.containsEdge(town[2], town[11]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[10]));
		assertEquals(true, roads.contains(town[11]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
	}

  
	  
	  @Test
	  public void testTown1ToTown_10() {
		  String beginTown = "Rockville", endTown = "Urbana";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Rockville via Brink to Hyattstown 16 mi",path.get(0).trim());
			  assertEquals("Hyattstown via 650 to Urbana 15 mi",path.get(1).trim());

		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_4ToTown_11() {
		  String beginTown = "Boyds", endTown = "Frederick";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Boyds via 70 to Damascus 13 mi",path.get(0).trim());
			  assertEquals("Damascus via 495 to Urbana 12 mi",path.get(1).trim());
			  assertEquals("Urbana via 40 to Frederick 13 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
}