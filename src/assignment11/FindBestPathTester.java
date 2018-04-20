package assignment11;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>An example of how a user will use your best flight API.</p>
 * <p>You will still be required to write JUnit tests to test your program.</p>
 *
 * @author CS2420 Teaching Staff - Spring 2018
 */
public class FindBestPathTester {

  private NetworkGraph airportGraph;

  @Before
  public void setUp() {
    airportGraph = null;
    try (FileInputStream fio = new FileInputStream(new File("flights-2017-q3.csv"));
        BufferedInputStream bufferedInput = new BufferedInputStream(fio)) {
      airportGraph = new NetworkGraph(bufferedInput);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @After
  public void tearDown() {
    airportGraph = null;
  }

  @Test
  public void bestPathDistanceAirlinerExample() {
    // Returns the shortest distance path of flights from SFO to DWF when flying with DL
    // Solution: a path of ['SFO', 'SLC', 'DFW'] and distance of 1588
    BestPath shortestDistancePath2 = airportGraph
        .getBestPath("SFO", "DFW", FlightCriteria.DISTANCE, "DL");
    System.out.println(shortestDistancePath2.toString());
  }

  @Test
  public void bestPathDistanceExample() {
    // Returns the shortest distance path of flights from MOB to ACV
    // Solution: a path of ['MOB', 'DFW', 'SFO', 'ACV'] and distance of 2253
    BestPath shortestDistancePath = airportGraph.getBestPath("MOB", "ACV", FlightCriteria.DISTANCE);
    System.out.println(shortestDistancePath.toString());
  }

  @Test
  public void bestPathTimeExample() {
    // Returns the shortest flight time path from MOB to SLC
    // Solution: a path of ['MOB', 'DFW', 'SLC'] and time of ~269.25
    BestPath shortestTimePath = airportGraph.getBestPath("MOB", "SLC", FlightCriteria.TIME);
    System.out.println(shortestTimePath.toString());
  }

  @Test
  public void bestPathPriceExample() {
    // Returns the fiscally cheapest path of flights from LAS to LAX
    // Solution: a path of ['LAS', 'LAX'] and cost of ~138.39
    BestPath cheapestPath = airportGraph.getBestPath("LAS", "LAX", FlightCriteria.PRICE);
    System.out.println(cheapestPath.toString());
  }

  @Test
  public void testMEItoPIBCost() {
    // This should be 0.0 with no path
    BestPath cheapestPath = airportGraph.getBestPath("MEI","PIB",FlightCriteria.PRICE);
    Assert.assertTrue(cheapestPath.getPathCost() == 0);
    System.out.println(cheapestPath.toString());
  }

  @Test
  public void testHIBtoINLCost() {
    BestPath cheapestPath = airportGraph.getBestPath("HIB","INL",FlightCriteria.PRICE);
    System.out.println(cheapestPath.toString());
  }


//  TEST FAILED: testSLCtoMVYDistanceWithDLCarrier - AssertionError @ org.junit.Assert.fail(Assert.java:86)
@Test
public void testSLCtoMVYDistanceWithDLCarrier() {
  BestPath cheapestPath = airportGraph.getBestPath("SLC","MVY",FlightCriteria.PRICE, "DL");
  System.out.println(cheapestPath.toString());
}
//  TEST FAILED: testDVLtoJMSCost - AssertionError @ org.junit.Assert.fail(Assert.java:86)
@Test
public void testDVLtoJMSCost() {
  BestPath cheapestPath = airportGraph.getBestPath("DVL","JMS",FlightCriteria.PRICE);
  System.out.println(cheapestPath.toString());
}

//  TEST FAILED: testINLtoHIBCost - AssertionError @ org.junit.Assert.fail(Assert.java:86)
  @Test
  public void testINLtoHIBCost() {
    BestPath cheapestPath = airportGraph.getBestPath("CDV","YAK",FlightCriteria.PRICE);
    System.out.println(cheapestPath.toString());
  }
//  TEST FAILED: testCDVtoYAKCost - AssertionError @ org.junit.Assert.fail(Assert.java:86)
@Test
public void testCDVtoYAKCost() {
  BestPath cheapestPath = airportGraph.getBestPath("CDV","YAK",FlightCriteria.PRICE);
  System.out.println(cheapestPath.toString());
}
//  TEST FAILED: testSAVtoBQKCost - AssertionError @ org.junit.Assert.fail(Assert.java:86)
  @Test
  public void testSAVtoBQKCost() {
    BestPath cheapestPath = airportGraph.getBestPath("SAV","BQK",FlightCriteria.PRICE);
    System.out.println(cheapestPath.toString());
  }
//  TEST FAILED: testIMTtoRHICost - AssertionError @ org.junit.Assert.fail(Assert.java:86)
  @Test
  public void testIMTtoRHICost() {
    BestPath cheapestPath = airportGraph.getBestPath("IMT","RHI",FlightCriteria.PRICE);
    System.out.println(cheapestPath.toString());
  }
//  TEST FAILED: testFCAtoMSOCost - AssertionError @ org.junit.Assert.fail(Assert.java:86)
  @Test
  public void testFCAtoMSOCost() {
    BestPath cheapestPath = airportGraph.getBestPath("FCA","MSO",FlightCriteria.PRICE);
    System.out.println(cheapestPath.toString());
  }
//  TEST FAILED: testRHItoIMTCost - AssertionError @ org.junit.Assert.fail(Assert.java:86)
  @Test
  public void testRHItoIMTCost() {
    BestPath cheapestPath = airportGraph.getBestPath("RHI","IMT",FlightCriteria.PRICE);
    System.out.println(cheapestPath.toString());
  }

}