package assignment11;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
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
    ArrayList<String> best = new ArrayList<>();
    best.add("SFO");
    best.add("SLC");
    best.add("DFW");
    BestPath shortestDistancePath2 = airportGraph
        .getBestPath("SFO", "DFW", FlightCriteria.DISTANCE, "DL");
    Assert.assertEquals(best, shortestDistancePath2.getPath());
    Assert.assertEquals(1588.0, shortestDistancePath2.getPathCost(), 1588.0 / Math.pow(10, 6));
  }

  @Test
  public void bestPathDistanceExample() {
    // Returns the shortest distance path of flights from MOB to ACV
    // Solution: a path of ['MOB', 'DFW', 'SFO', 'ACV'] and distance of 2253
    ArrayList<String> best = new ArrayList<>();
    best.add("MOB");
    best.add("DFW");
    best.add("SFO");
    best.add("ACV");
    BestPath shortestDistancePath = airportGraph.getBestPath("MOB", "ACV", FlightCriteria.DISTANCE);
    Assert.assertEquals(best, shortestDistancePath.getPath());
    Assert.assertEquals(2253, shortestDistancePath.getPathCost(), 2253 / Math.pow(10, 6));
  }

  @Test
  public void bestPathTimeExample() {
    // Returns the shortest flight time path from MOB to SLC
    // Solution: a path of ['MOB', 'DFW', 'SLC'] and time of ~269.25
    ArrayList<String> best = new ArrayList<>();
    best.add("MOB");
    best.add("DFW");
    best.add("SLC");
    BestPath shortestTimePath = airportGraph.getBestPath("MOB", "SLC", FlightCriteria.TIME);
    Assert.assertEquals(best, shortestTimePath.getPath());
    Assert.assertEquals(269.253414531118, shortestTimePath.getPathCost(), 0.001);
  }

  @Test
  public void bestPathPriceExample() {
    // Returns the fiscally cheapest path of flights from LAS to LAX
    // Solution: a path of ['LAS', 'LAX'] and cost of ~138.39
    ArrayList<String> best = new ArrayList<>();
    best.add("LAS");
    best.add("LAX");
    BestPath cheapestPath = airportGraph.getBestPath("LAS", "LAX", FlightCriteria.PRICE);
    Assert.assertEquals(best, cheapestPath.getPath());
    Assert.assertEquals(138.39, cheapestPath.getPathCost(), 0.0000001);
  }

  @Test
  public void testMEItoPIBCost() {
    // This should be 0.0 with no path
    BestPath cheapestPath = airportGraph.getBestPath("MEI", "PIB", FlightCriteria.PRICE);
    Assert.assertEquals(0, cheapestPath.getPathCost(), 0.0);
    Assert.assertTrue(cheapestPath.getPath().isEmpty());
  }

  @Test
  public void testHIBtoINLCost() {
    ArrayList<String> best = new ArrayList<>();
    best.add("HIB");
    best.add("MSP");
    best.add("INL");
    BestPath cheapestPath = airportGraph.getBestPath("HIB", "INL", FlightCriteria.PRICE);
    Assert.assertEquals(best, cheapestPath.getPath());
    Assert.assertEquals(271.5200000000003, cheapestPath.getPathCost(), 0.0000001);
  }

  @Test
  public void testSLCtoMVYDistanceWithDLCarrier() {
    BestPath cheapestPath = airportGraph.getBestPath("SLC", "MVY", FlightCriteria.DISTANCE, "DL");
    Assert.assertTrue(cheapestPath.getPath().isEmpty() && cheapestPath.getPathCost() == 0);
  }

  @Test
  public void testDVLtoJMSCost() {
    ArrayList<String> best = new ArrayList<>();
    best.add("DVL");
    best.add("DEN");
    best.add("JMS");
    BestPath cheapestPath = airportGraph.getBestPath("DVL", "JMS", FlightCriteria.PRICE);
    Assert.assertEquals(340.92999999999927, cheapestPath.getPathCost(), 0.00001);
    Assert.assertEquals(best, cheapestPath.getPath());
  }

  @Test
  public void testCDVtoYAKCost() {
    ArrayList<String> best = new ArrayList<>();
    best.add("CDV");
    best.add("ANC");
    best.add("JNU");
    best.add("YAK");
    BestPath cheapestPath = airportGraph.getBestPath("CDV", "YAK", FlightCriteria.PRICE);
    Assert.assertEquals(521.5, cheapestPath.getPathCost(), 0.00001);
    Assert.assertEquals(best, cheapestPath.getPath());
  }

  @Test
  public void testSAVtoBQKCost() {
    ArrayList<String> best = new ArrayList<>();
    best.add("SAV");
    best.add("ATL");
    best.add("BQK");
    BestPath cheapestPath = airportGraph.getBestPath("SAV", "BQK", FlightCriteria.PRICE);
    Assert.assertEquals(430.6499999999959, cheapestPath.getPathCost(), 0.0000001);
    Assert.assertEquals(best, cheapestPath.getPath());
  }

  @Test
  public void testIMTtoRHICost() {
    ArrayList<String> best = new ArrayList<>();
    best.add("IMT");
    best.add("MSP");
    best.add("RHI");
    BestPath cheapestPath = airportGraph.getBestPath("IMT", "RHI", FlightCriteria.PRICE);
    Assert.assertEquals(288.30999999999926, cheapestPath.getPathCost(), 0.0000001);
    Assert.assertEquals(best, cheapestPath.getPath());
  }

  @Test
  public void testFCAtoMSOCost() {
    ArrayList<String> best = new ArrayList<>();
    best.add("FCA");
    best.add("SLC");
    best.add("MSO");
    BestPath cheapestPath = airportGraph.getBestPath("FCA", "MSO", FlightCriteria.PRICE);
    Assert.assertEquals(576.9999999999997, cheapestPath.getPathCost(), 0.0000001);
    Assert.assertEquals(best, cheapestPath.getPath());
  }

  @Test
  public void testRHItoIMTCost() {
    ArrayList<String> best = new ArrayList<>();
    best.add("RHI");
    best.add("MSP");
    best.add("IMT");
    BestPath cheapestPath = airportGraph.getBestPath("RHI", "IMT", FlightCriteria.PRICE);
    Assert.assertEquals(348.50000000000034, cheapestPath.getPathCost(), 0.0000001);
    Assert.assertEquals(best, cheapestPath.getPath());
  }

}