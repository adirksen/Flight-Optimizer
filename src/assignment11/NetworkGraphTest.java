package assignment11;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NetworkGraphTest {
    @Test
    public void testConstructor(){
        try {
            NetworkGraph networkGraph = new NetworkGraph(new FileInputStream(new File("test-flights.csv")));
            for(Airport airport : networkGraph.airports){
                System.out.println(airport.getOrigin() + " # Flights: " + airport.getFlights().size());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
