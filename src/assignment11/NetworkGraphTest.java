package assignment11;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class NetworkGraphTest {
	
	@Test
    public void testConstructor(){
        try {
            NetworkGraph networkGraph = new NetworkGraph(new FileInputStream(new File("test-flights.csv")));
            Iterator<Entry<Airport, HashSet<Flight>>> it = networkGraph.airports.entrySet().iterator();
    		while(it.hasNext()) {
    			Map.Entry<Airport, HashSet<Flight>> pair = (Entry<Airport, HashSet<Flight>>)it.next();
    			System.out.println(pair.getKey().getOrigin() + " # Flights: " + pair.getValue().size());
    		}
    			
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
	@Test
    public void testConstructorSmall(){
        try {
            NetworkGraph networkGraph = new NetworkGraph(new FileInputStream(new File("testfile.csv")));
            networkGraph.getBestPath("LKG", "WTM", FlightCriteria.PRICE);
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	//@Test
	public void bestPathCost1() {
		try {
			NetworkGraph networkGraph = new NetworkGraph(new FileInputStream(new File("costTestFile.csv")));
			BestPath best = networkGraph.getBestPath("START", "FINAL", FlightCriteria.PRICE);
			System.out.println(best.toString());
		} catch(FileNotFoundException f) {
			f.printStackTrace();
		}
	}
	
	//@Test
	public void bestPathCost2() {
		try {
			NetworkGraph networkGraph = new NetworkGraph(new FileInputStream(new File("costTestFile.csv")));
			BestPath best = networkGraph.getBestPath("P1", "FINAL2", FlightCriteria.PRICE);
			System.out.println(best.toString());
		} catch(FileNotFoundException f) {
			f.printStackTrace();
		}
	}

    @Test
    public void bestPath(){
        try {
            NetworkGraph networkGraph = new NetworkGraph(new FileInputStream(new File("testfile.csv")));
            networkGraph.getBestPath("PCI", "PAZ", FlightCriteria.PRICE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
